package com.hackerrank.challenges;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CompletableFutureCheck {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicInteger count = new AtomicInteger(0);
        CompletableFuture<Void> combinedFuture =
                CompletableFuture.allOf(IntStream.range(0, 10).mapToObj(n -> CompletableFuture.supplyAsync(() -> {
                    try {
                        check(count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                    return count;
                })).toArray(CompletableFuture[]::new));
        combinedFuture.get();
    }

    private static AtomicInteger check(AtomicInteger count) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " - " + count.getAndIncrement());
        return count;
    }
}
