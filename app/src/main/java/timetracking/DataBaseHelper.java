package timetracking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {


    private static final String TAG = "Databasehelper";

    private static final String TABLE_NAME = "timetracking";
    private static final String COL1 = "DatumAnfang";
    private static final String COL2 = "DatumEnde";

    public DataBaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "DatumAnfang" +COL1 + "DatumEnde" +COL2;
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP IF TABLE EXISTS " +TABLE_NAME);
        onCreate(db);

    }

    public boolean addData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, item);
        contentValues.put(COL2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //falls daten falsch eingegeben wurden return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //return all data which is in the database
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);

        return data;
    }

 /*   public void updateAnfang(String anfangneu, int id, String anfangalt){

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "UPDATE" + TABLE_NAME + "SET" + COL2 + "=" +anfangneu + "WHERE " + COL1 +"=" +id;

    }*/

}
