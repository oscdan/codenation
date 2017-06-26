package com.codenation.vivediabetes.control;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.codenation.vivediabetes.beans.Catalog;
import com.codenation.vivediabetes.database.DataBaseHandler;

import java.util.ArrayList;

/**
 * @author oscarvargas
 * @since 19/06/17.
 */

public class ControlCatalog {

    /**
     * Insert a new DataBase Catalog Row
     * @param catalog Catalog Object
     * @param dh Previously Open DataBaseHandler Object
     * @return Row Id inserted
     */
    public long insertCatalog(Catalog catalog, DataBaseHandler dh){
        long inserted = 0;
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseHandler.KEY_ID, catalog.getId());
        values.put(DataBaseHandler.CATALOG_TYPE, catalog.getType());
        values.put(DataBaseHandler.CATALOG_ID_TYPE, catalog.getIdtype());
        values.put(DataBaseHandler.CATALOG_NAME, catalog.getName());
        values.put(DataBaseHandler.CATALOG_VISIBLE, catalog.getVisible());
        values.put(DataBaseHandler.CATALOG_ORDER_NO, catalog.getOrderNo());
        try {
            inserted = db.insert(DataBaseHandler.TABLE_CATALOG, null, values);
        }catch(Exception e){}
        db.close();
        values.clear();
        return inserted;
    }

    /**
     * Update DataBase Catalog Row
     * @param id Specific Catalog Row Id
     * @param type Specific Catalog Type Id
     * @param dh Previously Open DataBaseHandler Object
     */
    public void deleteCatalog(int id, int type, DataBaseHandler dh){
        SQLiteDatabase db = dh.getWritableDatabase();
        db.delete(DataBaseHandler.TABLE_CATALOG,
                DataBaseHandler.KEY_ID + " = ? AND " +
                        DataBaseHandler.CATALOG_TYPE + " = ?",
                new String[] { String.valueOf(id),
                        String.valueOf(type)});
        db.close();
    }

    /**
     * Update DataBase Catalog Row
     * @param catalog Catalog Object
     * @param dh Previously Open DataBaseHandler Object
     * @return Number of rows updated by query
     */
    public int updateCatalog(Catalog catalog, DataBaseHandler dh){
        int updated;
        SQLiteDatabase db = dh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataBaseHandler.CATALOG_ID_TYPE, catalog.getIdtype());
        values.put(DataBaseHandler.CATALOG_NAME, catalog.getName());
        values.put(DataBaseHandler.CATALOG_VISIBLE, catalog.getVisible());
        values.put(DataBaseHandler.CATALOG_ORDER_NO, catalog.getOrderNo());
        updated = db.update(DataBaseHandler.TABLE_CATALOG,
                values,
                DataBaseHandler.KEY_ID + " = ? AND " +
                        DataBaseHandler.CATALOG_TYPE + " = ?",
                new String[]{String.valueOf(catalog.getId()),
                        String.valueOf(catalog.getType())});
        db.close();
        return updated;
    }

    /**
     * Get Catalog Rows from specific Type
     * @param type Specific Catalog Type Id
     * @param dh Previously Open DataBaseHandler Object
     * @return Catalog ArrayList
     */
    public ArrayList<Catalog> getCatalogByType(int type, DataBaseHandler dh){
        String query = "SELECT " + DataBaseHandler.KEY_ID
                + ", " + DataBaseHandler.CATALOG_NAME
                + ", " + DataBaseHandler.CATALOG_VISIBLE
                + ", " + DataBaseHandler.CATALOG_ORDER_NO
                + ", " + DataBaseHandler.CATALOG_ID_TYPE
                + " FROM " + DataBaseHandler.TABLE_CATALOG
                + " WHERE " + DataBaseHandler.CATALOG_TYPE + " = " + type
                + " ORDER BY " + DataBaseHandler.CATALOG_ORDER_NO;
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<Catalog> catalogs = new ArrayList<>();
        while(cursor.moveToNext()){
            Catalog catalog = new Catalog();
            catalog.setId(cursor.getInt(0));
            catalog.setType(type);
            catalog.setName(cursor.getString(1));
            catalog.setVisible(cursor.getInt(2));
            catalog.setOrderNo(cursor.getInt(3));
            catalog.setIdtype(cursor.getInt(4));
            catalogs.add(catalog);
        }
        cursor.close();
        db.close();
        return catalogs;
    }

    /**
     * Get Full Catalog Content
     * @param dh Previously Open DataBaseHandler Object
     * @return Catalog ArrayList
     */
    public ArrayList<Catalog> getAllCatalog(DataBaseHandler dh){
        String query = "SELECT " + DataBaseHandler.KEY_ID
                + ", " + DataBaseHandler.CATALOG_TYPE
                + ", " + DataBaseHandler.CATALOG_NAME
                + ", " + DataBaseHandler.CATALOG_VISIBLE
                + ", " + DataBaseHandler.CATALOG_ORDER_NO
                + ", " + DataBaseHandler.CATALOG_ID_TYPE
                + " FROM " + DataBaseHandler.TABLE_CATALOG
                + " ORDER BY " + DataBaseHandler.CATALOG_TYPE + " ASC,"
                + DataBaseHandler.CATALOG_ORDER_NO + " ASC";
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<Catalog> catalogs = new ArrayList<>();
        while(cursor.moveToNext()){
            Catalog catalog = new Catalog();
            catalog.setId(cursor.getInt(0));
            catalog.setType(cursor.getInt(1));
            catalog.setName(cursor.getString(2));
            catalog.setVisible(cursor.getInt(3));
            catalog.setOrderNo(cursor.getInt(4));
            catalog.setIdtype(cursor.getInt(5));
            catalogs.add(catalog);
        }
        cursor.close();
        db.close();
        return catalogs;
    }

}
