package cz.matej.clashroyaleapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fanda on 13.5.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = " ClashRoyale.db ";
    public static final String TABLE_NAME = " Cards_table ";
    private static final int DB_VERSION = 1;
    public static final String COL_1_ID = " _ID ";
    public static final String COL_2_NAME = " NAME ";
    public static final String COL_3_RARITY = " RARITY ";
    public static final String COL_4_TYPE = " TYPE ";

    private static final String DB_CREATE =
            " CREATE TABLE " + TABLE_NAME + " ( " +
                    COL_1_ID + " Integer primary key autoincrement, " +
                    COL_2_NAME + " Name " +
                    COL_3_RARITY + " Rarity " +
                    COL_4_TYPE + " Type " + ")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
