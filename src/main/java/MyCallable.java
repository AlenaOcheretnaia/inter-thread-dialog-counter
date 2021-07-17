import java.util.Random;
import java.util.concurrent.Callable;
import static java.lang.Thread.sleep;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() {
        Random rand = new Random();
        int num = rand.nextInt(11);

        int count = 0;

        for (int i = 0; i < num; i++) {
            try {

                    System.out.println("Всем привет! от " + Thread.currentThread().getName());
                    count++;
                    sleep(3000);

            } catch (InterruptedException err) {
                System.out.println("Всем пока! от " + Thread.currentThread().getName());
                //err.printStackTrace();
                break;
            }
        }
        return count;
    }


}