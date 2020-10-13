package in.learncodeonline.bankapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TransactionScreen extends AppCompatActivity {


    DatabaseHelper1 yDB;
    EditText  accountedit , accountedit1 , userR , amount ;
    Button adatrans , showtrans , deletetrans , Clear ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_transaction_screen);







        yDB = new DatabaseHelper1(this);



        accountedit = findViewById(R.id.editTextTextPersonName);
        accountedit1= findViewById(R.id.editTextTextPersonName5);
        userR = findViewById(R.id.editTextPhone4);
        amount = findViewById(R.id.editTextPhone2);




        adatrans = findViewById(R.id.button6);
        showtrans = findViewById(R.id.button13);
        deletetrans = findViewById(R.id.button17);
        Clear = findViewById(R.id.button7);


        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountedit.getText().clear();
                accountedit1.getText().clear();
                amount.getText().clear();
                userR.getText().clear();
            }
        });

        addData();
        getAll();
        deletedata();



    }




    public  void addData(){

        adatrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInerted = yDB.insertData(accountedit.getText().toString(),amount.getText().toString(),accountedit1.getText().toString());

                if(isInerted == true){
                    Toast.makeText(TransactionScreen.this,"Data inserted ",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(TransactionScreen.this,"Something went wrong ",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    public void getAll() {

        showtrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = yDB.getallData();

                if (cursor.getCount() == 0) {
                    showMes("Error", "Not a valid data");
                    return;
                }

                StringBuffer buffer = new StringBuffer();


                while (cursor.moveToNext()) {
                    buffer.append("USER:" + cursor.getString(0) + "\n");
                    buffer.append("ACCOUNT_NUMBER1:" + cursor.getString(1) + "\n");
                    buffer.append("AMOUNT:" + cursor.getString(2) + "\n");
                    buffer.append("ACCOUNT_NUMBER2:" + cursor.getString(3) + "\n");

                }
                showMes("All Data", buffer.toString());
            }
        });


    }

    public void deletedata(){

        deletetrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer deleteRow = yDB.deleteData(userR.getText().toString());

                if (deleteRow > 0){
                    Toast.makeText(TransactionScreen.this,"Delete Done",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(TransactionScreen.this,"oopssss",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }




    private void showMes(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();


    }



















}