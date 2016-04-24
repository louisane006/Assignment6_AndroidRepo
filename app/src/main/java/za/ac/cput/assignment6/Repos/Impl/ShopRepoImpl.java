package za.ac.cput.assignment6.Repos.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashSet;
import java.util.Set;

import za.ac.cput.assignment6.Domain.Shop;
import za.ac.cput.assignment6.Repos.ShopRepo;
import za.ac.cput.assignment6.conf.databases.DBConstants;

/**
 * Created by louisane Malu on 4/20/2016.
 */
public class ShopRepoImpl extends SQLiteOpenHelper implements ShopRepo {

    public static final String TABLE_NAME = "shopDetails";
    private SQLiteDatabase db ;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_SIZE = "size";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_PARTS = "parts";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SIZE + " TEXT NOT NULL , "
            + COLUMN_ADDRESS + " TEXT , "
            + COLUMN_PARTS + " TEXT NOT NULL ); ";

    public ShopRepoImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Shop findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_SIZE,
                        COLUMN_ADDRESS,
                        COLUMN_PARTS,},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Shop c = new Shop.Builder()
                    .identification(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .size(cursor.getDouble(cursor.getColumnIndex(COLUMN_SIZE)))
                    .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                    .part(cursor.getString(cursor.getColumnIndex(COLUMN_PARTS)))
                    .build();
            return c;
        } else {
            return null;
        }
    }
    @Override
    public Shop save(Shop entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getIdentification());
        values.put(COLUMN_SIZE, entity.getSize());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        values.put(COLUMN_PARTS, String.valueOf(entity.getPart()));
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Shop insertedEntity = new Shop.Builder()
                .copy(entity)
                .identification(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Shop update(Shop entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getIdentification());
        values.put(COLUMN_SIZE, entity.getSize());
        values.put(COLUMN_ADDRESS, entity.getAddress());
        values.put(COLUMN_PARTS, String.valueOf(entity.getPart()));
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getIdentification())}
        );
        return entity;
    }

    @Override
    public Shop delete(Shop entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getIdentification())});
        return entity;
    }

    @Override
    public Set<Shop> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Shop> d = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                final Shop des = new Shop.Builder()
                        .identification(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .size(cursor.getDouble(cursor.getColumnIndex(COLUMN_SIZE)))
                        .address(cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS)))
                        .part(cursor.getString(cursor.getColumnIndex(COLUMN_PARTS)))
                        .build();
                d.add(des);
            } while (cursor.moveToNext());
        }
        return d;
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
