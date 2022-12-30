import java.util.TimerTask;
import java.util.Timer;
public class Runner
{
    public static void main(String[] args)
    {
        WelcomePage wel = new WelcomePage();
        TimerTask task = new TimerTask() {
            public void run()
            {
                wel.dispose();
                new Main();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,5000);
    }

}
