package org.technosoft.progress_bar;

public class ProgressBar implements Runnable {

    private final int barLength;
    private int currentTask;
    private final int totalTask;

    public ProgressBar(int barLength, int currentTask, int totalTask) {
        this.barLength = barLength;
        this.currentTask = currentTask;
        this.totalTask = totalTask;
    }

    @Override
    public void run() {
        StringBuilder progressBar = new StringBuilder("Calculating in progress...");
        System.out.println("Calculating in progress...");
        progressBar.append(" ".repeat(barLength));
        while (currentTask <= totalTask) {
            int progress = (int) (currentTask / (float) totalTask * barLength);
            StringBuffer bar = new StringBuffer(barLength + 10);
            bar.append("[");
            for (int i = 0; i < barLength; i++) {
                if (i < progress) {
                    char progressDone = '=';
                    bar.append(progressDone);
                } else if (i == progress) {
                    char inProgress = '>';
                    bar.append(inProgress);
                } else {
                    char noProgress = ' ';
                    bar.append(noProgress);
                }
            }
            bar.append("] ")
                    .append(progress * 100 / barLength)
                    .append("%");
            System.out.print("\r" + bar);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentTask = Counter.getCounter();
        }
    }
}


