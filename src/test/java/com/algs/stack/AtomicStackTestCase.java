package com.algs.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

final class AtomicStackTestCase {

    @RepeatedTest(5)
    void test() throws Exception {
        var service = Executors.newFixedThreadPool(15);
        final CountDownLatch latch = new CountDownLatch(1);
        var stack = new AtomicStack();
        for (int i = 0; i < 20; i++) {
            final int cnt = i;
            service.submit(() -> {
                        latch.await();
                        stack.push(cnt);
                        return null;
                    }
            );
        }
        latch.countDown();
        service.shutdown();
        service.awaitTermination(10, TimeUnit.SECONDS);
        for (int i = 0; i < 20; i++) {
            Assertions.assertNotEquals(stack.pop(), -1);
        }
    }
}
