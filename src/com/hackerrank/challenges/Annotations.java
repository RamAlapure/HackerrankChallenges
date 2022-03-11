package com.hackerrank.challenges;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.logging.Logger;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
    String userRole() default "GUEST";

    int budgetLimit();
}

class FamilyMember {

    public static final Logger log = Logger.getLogger(FamilyMember.class.getName());

    @FamilyBudget(userRole = "SENIOR", budgetLimit = 100)
    public void seniorMember(int budget, int moneySpend) {
        log.info("Senior Member");
        log.info("Spend: " + moneySpend);
        log.info("Budget Left: " + (budget - moneySpend));
    }

    @FamilyBudget(userRole = "JUNIOR", budgetLimit = 50)
    public void juniorUser(int budget, int moneySpend) {
        log.info("Junior Member");
        log.info("Spend: " + moneySpend);
        log.info("Budget Left: " + (budget - moneySpend));
    }
}

public class Annotations {

    public static final Logger log = Logger.getLogger(Annotations.class.getName());

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String role = in.next();
            int spend = in.nextInt();
            try {
                Class annotatedClass = FamilyMember.class;
                Method[] methods = annotatedClass.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(FamilyBudget.class)) {
                        FamilyBudget family = method.getAnnotation(FamilyBudget.class);
                        String userRole = family.userRole();
                        int budgetLimit = family.budgetLimit();
                        if (userRole.equals(role)) {
                            if (spend <= budgetLimit) {
                                method.invoke(FamilyMember.class.newInstance(), budgetLimit, spend);
                            } else log.info("Budget Limit Over");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            testCases--;
        }
    }
}
