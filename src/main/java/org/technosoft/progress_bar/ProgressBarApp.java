package org.technosoft.progress_bar;

public class ProgressBarApp {

    /*     Объект класса Task запускается в своём треде и делает бессмысленную работу по созданию коллекции,
    заполнению её рандомными значениями типа Double, затем в цикле превращает тип Double в String, засыпает на 50 мс
    для имитации большого объёма вычислений и вызывает метод setCounter у потокобезопасного класса - счётчика Counter,
    тем самым инкрементируя значение этого счётчика. Таким образом имитируется фиксация прогресса выполнения классом
    Task своей работы.
           Объект класса ProgressBar запускается в своём треде и с помощью StringBuffer рендерит прогресс - бар в
     консоли в зависимости от состояния счётчика Counter.
            Много хард - кода. Но как учебное задание... */

    public static void main(String[] args) {

        int barLength = 80;
        int currentTask = 0;
        int totalTask = 100;

        var thread1 = new Thread(new ProgressBar(barLength, currentTask, totalTask));
        thread1.start();
        var thread2 = new Thread(new Task());
        thread2.start();
    }
}

