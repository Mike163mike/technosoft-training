package org.technosoft.progress_bar;

import java.util.List;
import java.util.stream.DoubleStream;

public class Task implements Runnable {
    @Override
    public void run() {
        List<Double> doubles = DoubleStream.generate(Math::random)
                .limit(101)
                .sorted()
                .boxed()
                .toList();
        for (Double d : doubles) {
            Counter.setCounter();
            System.out.print("    d = " + d + "\r");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
