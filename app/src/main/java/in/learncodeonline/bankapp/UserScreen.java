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

public class UserScreen extends AppCompatActivity {

    DatabaseHelper myDB;
    EditText name , accountedit , email , phoneNumber , userR;
    Button addUser , updateUser , deleteUser , userdelete , Clear;

    public Button button32;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_screen);








        myDB = new DatabaseHelper(this);


        name = findViewById(R.id.editTextTextPersonName2);
        accountedit = findViewById(R.id.editTextTextPersonName3);
        email = findViewById(R.id.editTextTextPersonName4);
        phoneNumber = findViewById(R.id.editTextPhone);
        userR = findViewById(R.id.editTextPhone3);




        addUser = findViewById(R.id.button3);
        button32 = findViewById(R.id.button4);
        deleteUser = findViewById(R.id.button5);
        userdelete = findViewById(R.id.button10);
        Clear = findViewById(R.id.button8);


        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.getText().clear();
                accountedit.getText().clear();
                email.getText().clear();
                phoneNumber.getText().clear();
                userR.getText().clear();
            }
        });




            addData();
            getdata();
            getAll();
            deletedata();




    }

        public  void addData(){

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInerted = myDB.insertData(name.getText().toString(),accountedit.getText().toString(),email.getText().toString(),phoneNumber.getText().toString());

                if(isInerted == true){
                Toast.makeText(UserScreen.this,"Data inserted ",Toast.LENGTH_SHORT).show();
            }
                else{
                    Toast.makeText(UserScreen.this,"Something went wrong ",Toast.LENGTH_SHORT).show();
                }

                }
        });

    }

            public void getdata() {

                    button32.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String user = userR.getText().toString();

                        if (user.equals(String.valueOf(""))) {
                            userR.setError("Enter user Number");
                            return;




                        }
                        Cursor cursor = myDB.getData(user);
                        String data = null;
                        if (cursor.moveToNext()) {
                            data = "USER:" + cursor.getString(0) + "\n" +
                                    "NAME:" + cursor.getString(1) + "\n" +
                                    "ACCOUNT_NUMBER:" + cursor.getString(2) + "\n" +
                                    "EMAIL:" + cursor.getString(3) + "\n" +
                                    "PHONE_Number:" + cursor.getString(4) + "\n";

                        }
                        showMes("data:", data);

                    }


                });


            }
            public void getAll() {

                deleteUser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor cursor = myDB.getallData();

                        if (cursor.getCount() == 0) {
                            showMes("Error", "Not a valid data");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();


                        while (cursor.moveToNext()) {
                            buffer.append("USER:" + cursor.getString(0) + "\n");
                            buffer.append("NAME:" + cursor.getString(1) + "\n");
                            buffer.append("ACCOUNT_NUMBER:" + cursor.getString(2) + "\n");
                            buffer.append("EMAIL:" + cursor.getString(3) + "\n");
                            buffer.append("pHONE_NUMBER:" + cursor.getString(4) + "\n");
                        }
                        showMes("All Data", buffer.toString());
                    }
                });


            }

            public void deletedata(){

                userdelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deleteRow = myDB.deleteData(userR.getText().toString());

                        if (deleteRow > 0){
                            Toast.makeText(UserScreen.this,"Delete Done",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(UserScreen.this,"oopssss",Toast.LENGTH_SHORT).show();
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

















