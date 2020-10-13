package in.learncodeonline.bankapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper1 extends SQLiteOpenHelper {


    public final static String DATABASE_NAME1 = "money.db";
    public final static String TABLE_NAME1 = "Transaction_TABLE";
    public final static String  COL1 = "USER";
    public final static String  COL2 = "ACCOUNT_NUMBER1";
    public final static String COL3 = "AMOUNT";
    public final static String COL4 = "ACCOUNT_NUMBER2";





    public DatabaseHelper1(Context context) {
        super(context,DATABASE_NAME1,null,1);
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME1+ " (  USER INTEGER   PRIMARY KEY AUTOINCREMENT , " +
                "ACCOUNT_NUMBER1 TEXT," +
                "AMOUNT INTEGER  ,"+
                " ACCOUNT_NUMBER2 TEXT )");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(sqLiteDatabase);

    }


    public boolean insertData(String account_number1,String amount, String account_number2){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

        contentvalues.put(COL2,account_number1);
        contentvalues.put(COL3,amount);
        contentvalues.put(COL4,account_number2);




        long result = db.insert(TABLE_NAME1,null,contentvalues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }



    public boolean updateData(String user,String accountNumber1, String amount , String accountNumber2){




        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

        contentvalues.put(COL1, user);
        contentvalues.put(COL2, accountNumber1);
        contentvalues.put(COL3,amount);
        contentvalues.put(COL4,accountNumber2);

        db.update(TABLE_NAME1,contentvalues,"USER=?",new String[]{user});
        return true;

    }

    public Cursor getData(String user){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME1+" WHERE USER ='"+user+"'";
        Cursor cursor = db.rawQuery(query,null);

        return cursor;
    }

    public Integer deleteData(String user){


        SQLiteDatabase db   = this.getWritableDatabase();

        return db.delete(TABLE_NAME1,"USER=?",new String[]{user});
    }


    public Cursor getallData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME1,null);
        return cursor;



    }










}
