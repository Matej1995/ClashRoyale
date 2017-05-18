package cz.matej.clashroyaleapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import cz.matej.clashroyaleapp.model.CardEntity;

/**
 * Created by Fanda on 16.5.2017.
 */

public class DatabaseManager {

    private SQLiteDatabase database;
    private DatabaseHelper helper;
    private Context mContext;

    public DatabaseManager(Context context) {
        mContext = context;
        helper = new DatabaseHelper(context);
    }

    // open
    public void open() throws SQLException{
        database = helper.getWritableDatabase();
    }
    // close
    public void close(){
        database.close();
    }
    // insert
    public void selectAllCards(List<CardEntity> cardEntities){
        try {
            for (CardEntity entity : cardEntities) {
                ContentValues values = new ContentValues();
                values.put(DatabaseHelper.COL_2_NAME, entity.getName());
                values.put(DatabaseHelper.COL_3_RARITY, entity.getRarity());
                values.put(DatabaseHelper.COL_4_TYPE, entity.getType());
                database.insert(DatabaseHelper.TABLE_NAME, null, values);
            }
        }
        catch (Exception e){
            Log.e("Problém :D ", e.getMessage());
        }
    }

}
