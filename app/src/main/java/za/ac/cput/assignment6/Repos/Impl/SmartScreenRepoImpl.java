package za.ac.cput.assignment6.Repos.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashSet;
import java.util.Set;

import za.ac.cput.assignment6.Domain.SmartScreen;
import za.ac.cput.assignment6.Repos.SmartScreenRepo;
import za.ac.cput.assignment6.conf.databases.DBConstants;

/**
 * Created by louisane Malu on 4/21/2016.
 */
public class SmartScreenRepoImpl extends SQLiteOpenHelper implements SmartScreenRepo {

    public static final String TABLE_NAME = "smartScreenDetails";
    private SQLiteDatabase db;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CODE = "code";
    public static final String COLUMN_PRICE = "amount";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT NOT NULL , "
            + COLUMN_CODE + " TEXT NOT NULL , "
            + COLUMN_PRICE + " TEXT NOT NULL ); ";

    public SmartScreenRepoImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public SmartScreen findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_CODE,
                        String.valueOf(COLUMN_PRICE),},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final SmartScreen b = new SmartScreen.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_CODE)))
                    .code(cursor.getString(cursor.getColumnIndex(COLUMN_CODE)))
                    .costPrice(cursor.getDouble(cursor.getColumnIndex(String.valueOf(COLUMN_PRICE))))
                    .build();
            return b;
        } else {
            return null;
        }
    }

    @Override
    public SmartScreen save(SmartScreen entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getIdentification());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_CODE, entity.getCode());
        values.put(String.valueOf(COLUMN_PRICE), entity.getPrice());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        SmartScreen insertedEntity = new SmartScreen.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public SmartScreen update(SmartScreen entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getIdentification());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_CODE, entity.getCode());
        values.put(String.valueOf(COLUMN_PRICE), entity.getPrice());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getIdentification())}
        );
        return entity;
    }

    @Override
    public SmartScreen delete(SmartScreen entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getIdentification())});
        return entity;
    }

    @Override
    public Set<SmartScreen> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<SmartScreen> i = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                final SmartScreen c = new SmartScreen.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_CODE)))
                        .code(cursor.getString(cursor.getColumnIndex(COLUMN_CODE)))
                        .costPrice(cursor.getDouble(cursor.getColumnIndex(String.valueOf(COLUMN_PRICE))))
                        .build();
                i.add(c);
            } while (cursor.moveToNext());
        }
        return i;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME, null, null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
