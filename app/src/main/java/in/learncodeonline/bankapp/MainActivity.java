package in.learncodeonline.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private static int Splash_screen = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

     new Handler().postDelayed(new Runnable() {
         @Override
         public void run(){
             Intent intent = new Intent(MainActivity.this,Splash.class);
             startActivity(intent);
             finish();
         }
     },Splash_screen);


    }
}