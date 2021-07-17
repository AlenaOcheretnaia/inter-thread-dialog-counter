import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class MainInvokeAny {

    public static void main(String[] args) {

        final int NUMBER = 4;
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER);
        List<MyCallable> taskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyCallable task = new MyCallable();
            taskList.add(task);
        }

        int resultForAny = 0;

        try {
            resultForAny = executor.invokeAny(taskList);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        System.out.println("\n========Printing the result for invokeAny======");
        System.out.println(resultForAny);

    }

}

