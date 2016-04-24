package za.ac.cput.assignment6.Repos.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashSet;
import java.util.Set;

import za.ac.cput.assignment6.Domain.Invoice;
import za.ac.cput.assignment6.Repos.InvoiceRepo;
import za.ac.cput.assignment6.conf.databases.DBConstants;

/**
 * Created by louisane Malu on 4/21/2016.
 */
public class InvoiceRepoImpl extends SQLiteOpenHelper implements InvoiceRepo {

    public static final String TABLE_NAME = "invoiceDetails";
    private SQLiteDatabase db;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NUM = "invNumber";
    public static final String COLUMN_CASHIER= "cashier";
    public static final String COLUMN_AMOUNT = "amount";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NUM + " TEXT NOT NULL , "
            + COLUMN_CASHIER + " TEXT NOT NULL , "
            + COLUMN_AMOUNT + " TEXT NOT NULL ); ";

    public InvoiceRepoImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Invoice findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NUM,
                        COLUMN_CASHIER,
                        String.valueOf(COLUMN_AMOUNT),},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Invoice b = new Invoice.Builder()
                    .identification(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .invoiceNum(cursor.getInt(cursor.getColumnIndex(COLUMN_NUM)))
                    //.cashier(cursor.getString(cursor.getColumnIndex(COLUMN_TASK)))
                    .amount(cursor.getDouble(cursor.getColumnIndex(String.valueOf(COLUMN_AMOUNT))))
                    .build();
            return b;
        } else {
            return null;
        }
    }

    @Override
    public Invoice save(Invoice entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getIdentification());
        values.put(COLUMN_NUM, entity.getInvoiceNum());
        values.put(COLUMN_CASHIER, String.valueOf(entity.getCashier()));
        values.put(String.valueOf(COLUMN_AMOUNT), entity.getAmount());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Invoice insertedEntity = new Invoice.Builder()
                .copy(entity)
                .identification(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Invoice update(Invoice entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getIdentification());
        values.put(COLUMN_NUM, entity.getInvoiceNum());
        values.put(COLUMN_CASHIER, String.valueOf(entity.getCashier()));
        values.put(String.valueOf(COLUMN_AMOUNT), entity.getAmount());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getIdentification())}
        );
        return entity;
    }

    @Override
    public Invoice delete(Invoice entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getIdentification())});
        return entity;
    }

    @Override
    public Set<Invoice> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Invoice> i = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                final Invoice inv = new Invoice.Builder()
                        .identification(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .invoiceNum(cursor.getInt(cursor.getColumnIndex(COLUMN_NUM)))
                        //.cashier(cursor.getString(cursor.getColumnIndex(COLUMN_CASHIER)))
                        .amount(cursor.getDouble(cursor.getColumnIndex(String.valueOf(COLUMN_AMOUNT))))
                        .build();
                i.add(inv);
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

