package in.learncodeonline.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Mainscreen extends AppCompatActivity {

    public Button button4;

    public Button button5;
    public Button button16;
    public Button button14;
    public Button button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mainscreen);


        button4 = findViewById(R.id.button11);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainscreen.this,UserScreen.class);
                startActivity(intent);
            }
        });


        button5 = findViewById(R.id.button14);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mainscreen.this,TransactionScreen.class);
                startActivity(intent);
            }
        });





    }
}