import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Main {

    public static void main(String[] args) {

        final int NUMBER = 4;

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER);
        List<MyCallable> taskList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MyCallable task = new MyCallable();
            taskList.add(task);
        }

        List<Future<Integer>> resultList = null;

        try {
            resultList = executor.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        System.out.println("\n========Printing the results for invokeAll======");

        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> future = resultList.get(i);
            try {
                int result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

}

