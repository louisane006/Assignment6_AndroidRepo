package za.ac.cput.assignment6.Repos.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashSet;
import java.util.Set;

import za.ac.cput.assignment6.Domain.Brochure;
import za.ac.cput.assignment6.Repos.BrochureRepo;
import za.ac.cput.assignment6.conf.databases.DBConstants;

/**
 * Created by louisane Malu on 4/21/2016.
 */
public class BrochureRepoImpl extends SQLiteOpenHelper implements BrochureRepo {

    public static final String TABLE_NAME = "brochure";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DESC = "Desription";
   // public static final String COLUMN_CUSTOMER = "customer";
   // public static final String COLUMN_DESIGNER = "designer";
    public static final String COLUMN_PRICE= "price";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "( "
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DESC + " TEXT NOT NULL , "
            //+ COLUMN_CUSTOMER + " CUSTOMER NOT NULL , "
            //+ COLUMN_DESIGNER + " TEXT NOT NULL , "
            + COLUMN_PRICE + " TEXT NOT NULL ); ";

    public BrochureRepoImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Brochure findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_DESC,
                        //COLUMN_CUSTOMER,
                        //COLUMN_DESIGNER,
                        COLUMN_PRICE,},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Brochure b = new Brochure.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .desc(cursor.getString(cursor.getColumnIndex(COLUMN_DESC)))
                   // .designer(AppUtil.getDesigner(cursor.getString(cursor.getColumnIndex(COLUMN_DESIGNER))
                   // .customer(AppUtil.getCustomer(cursor.getString(cursor.getColumnIndex(COLUMN_CUSTOMER)))
                    .price(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)))
                    .build();
            return b;
        } else {
            return null;
        }
    }

    @Override
    public Brochure save(Brochure entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_DESC, entity.getDescription());
        //values.put(COLUMN_CUSTOMER, String.valueOf(entity.getCustomer()));
        //values.put(COLUMN_DESIGNER, String.valueOf(entity.getDesigner()));
        values.put(COLUMN_PRICE, entity.getPrice());
        long id = db.insertOrThrow(TABLE_NAME,null, values);
        Brochure insertedEntity = new Brochure.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }
    @Override
    public Brochure update(Brochure entity){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_DESC, entity.getDescription());
        //values.put(COLUMN_CUSTOMER, String.valueOf(entity.getCustomer()));
        //values.put(COLUMN_DESIGNER, String.valueOf(entity.getDesigner()));
        values.put(COLUMN_PRICE, entity.getPrice());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }
    @Override
    public Brochure delete(Brochure entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Brochure> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Brochure> b = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Brochure bro = new Brochure.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .desc(cursor.getString(cursor.getColumnIndex(COLUMN_DESC)))
                        //.customer(cursor.getString(cursor.getColumnIndex(COLUMN_CUSTOMER)))
                        //.designer(cursor.getString(cursor.getColumnIndex(COLUMN_DESIGNER)))
                        .price(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)))
                        .build();
                b.add(bro);
            } while (cursor.moveToNext());
        }
        return b;
    }
    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
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