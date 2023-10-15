package com.pluralsight.jp.validator;

import com.pluralsight.jp.cc.Predicate;

import java.util.function.Supplier;

public interface Validator<T> {

    ValidatorSupplier<T> on(T t);

    default Validator<T> thenValidate(Predicate<T> predicate, String message) {
        return t -> {
            try {
                on(t).validate();
                return validate(predicate, message, t);
            } catch (ValidationException validationException) {
                if (!predicate.test(t)) {
                    validationException.addSuppressed(new IllegalArgumentException(message));
                }
                return () -> {
                    throw validationException;
                };
            }
        };
    }

    private static <T> ValidatorSupplier<T> validate(Predicate<T> predicate, String message, T t) {
        if (predicate.test(t)) {
            return () -> t;
        } else {
            return () -> {
                ValidationException validationException = new ValidationException("The object is not valid");
                validationException.addSuppressed(new IllegalArgumentException(message));
                throw validationException;
            };
        }
    }

    static <T> Validator<T> validate(Predicate<T> predicate, String message) {
        return t -> validate(predicate, message, t);
    }

    interface ValidatorSupplier<T> extends Supplier<T> {
        default T validate() {
            return get();
        }
    }

    class ValidationException extends RuntimeException {
        public ValidationException(String message) {
            super(message);
        }
    }
}
