package cn.com.fyl.learn.progress_bar_solid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MyCircleView circleView;
    private int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleView= (MyCircleView) findViewById(R.id.circle);
        circleView.setProgress(0);
        new Thread(new Runnable() {
            @Override
            public void run() {
               while (true){
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   progress++;
                   if (progress>100){
                       break;
                   }
                   runOnUiThread(new Runnable() {
                       @Override
                       public void run() {
                           if (progress<=100){
                               circleView.setProgress(progress);
                           }
                       }
                   });
               }
            }
        }).start();
    }
}
