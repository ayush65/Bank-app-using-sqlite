package in.learncodeonline.bankapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public final static String DATABASE_NAME = "bank.db";
    public final static String TABLE_NAME = "BANK_TABLE";
    public final static String  COL1 = "USER";
    public final static String  COL2 = "ACCOUNT_NUMBER";
    public final static String COL3 = "NAME";
    public final static String COL4 = "EMAIL_ADDRESS";
    public final static String  COL5 = "PHONE_NUMBER";




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME+ " (  USER INTEGER   PRIMARY KEY AUTOINCREMENT , " +
                "NAME TEXT ," +
                " ACCOUNT_NUMBER TEXT  ,"+
                " EMAIL_ADDRESS TEXT , " +
                " PHONE_NUMBER INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
         sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
         onCreate(sqLiteDatabase);
    }

    public boolean insertData(String account_number,String name, String email , String phoneNumber){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

        contentvalues.put(COL2,name);
        contentvalues.put(COL3,account_number);
        contentvalues.put(COL4,email);
        contentvalues.put(COL5,phoneNumber);



        long result = db.insert(TABLE_NAME,null,contentvalues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }



    public boolean updateData(String name,String accountNumber, String email , String phoneNumber){




        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();

        contentvalues.put(COL1, name);
        contentvalues.put(COL2, accountNumber);
        contentvalues.put(COL3,email);
        contentvalues.put(COL4,phoneNumber);

        db.update(TABLE_NAME,contentvalues,"ACCOUNT_NUMBER=?",new String[]{accountNumber});
        return true;

    }
    public Cursor getData(String user){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE USER ='"+user+"'";
        Cursor cursor = db.rawQuery(query,null);

        return cursor;
    }

    public Integer deleteData(String user){


        SQLiteDatabase db   = this.getWritableDatabase();

        return db.delete(TABLE_NAME,"USER=?",new String[]{user});
    }


    public Cursor getallData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor;



    }


}
