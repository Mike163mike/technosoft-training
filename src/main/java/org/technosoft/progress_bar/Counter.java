package org.technosoft.progress_bar;

import java.util.concurrent.atomic.AtomicInteger;

public final class Counter {

    private static final AtomicInteger counter = new AtomicInteger(0);

    private Counter() {
    }

    public static int getCounter() {
        synchronized (Counter.class) {
            return counter.get();
        }
    }

    public static void setCounter() {
        synchronized (Counter.class) {
            counter.getAndIncrement();
        }
    }
}
