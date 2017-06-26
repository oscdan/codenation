package com.codenation.vivediabetes.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Oscar Vargas
 * @since 18/06/17.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Diabetes.db";

    //TABLES
    public static final String TABLE_USER = "User";
    public static final String TABLE_USER_RECORD = "Record";
    public static final String TABLE_GLUCOSA = "Glucosa";
    public static final String TABLE_CATALOG = "Catalog";

    //*********   COLUMNS GENERIC NAMES   ******

    public static final String KEY_ID = "id";
    //*********   USER NAME & DOCTOR NAME  *****
    public static final String NAME = "name";


    //*********   COLUMNS SPECIFIC NAMES   *****

    public static final String USER_EMAIL = "email";
    public static final String USER_GENDER = "gender";
    public static final String USER_BIRTHDATE = "birthdate";
    public static final String USER_COUNTRY = "country";
    public static final String USER_WEIGHT = "weight";
    public static final String USER_HEIGHT = "height";
    public static final String USER_PHYSICAL = "physicalactivity";
    public static final String USER_LIFECYCLE = "lifecycle";
    public static final String USER_CARB_UNITS = "carbunits";

    public static final String RECORD_DIABETES_TYPE = "diabetestype";
    public static final String RECORD_DIAGNOSTIC_DATE = "diagnosticdate";
    public static final String RECORD_TREATMENT = "treatment";
    public static final String RECORD_FARMACO = "farmaco";
    public static final String RECORD_INSULIN_UNITS = "insulinUnits";

    public static final String GLUCOSA_DATE = "registerdate";
    public static final String GLUCOSA_VALUE = "glucosa";
    public static final String GLUCOSA_SESSION = "session";
    public static final String GLUCOSA_PERIOD = "period";
    public static final String GLUCOSA_RESULT = "result";
    public static final String GLUCOSA_COMMENT = "comment";
    public static final String GLUCOSA_CREATE_DATE = "createdate";

    public static final String CATALOG_TYPE = "type";
    public static final String CATALOG_ID_TYPE = "idtype";
    public static final String CATALOG_NAME = "name";
    public static final String CATALOG_VISIBLE = "visible";
    public static final String CATALOG_ORDER_NO = "orderno";

    private static final int DATABASE_VERSION = 1;
    private static DataBaseHandler dataBaseHandler;

    private DataBaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DataBaseHandler getInstance(Context context){
        if(dataBaseHandler == null){
            dataBaseHandler = new DataBaseHandler(context);
        }
        return dataBaseHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create CATALOG Table
        String CREATE_STRING = "CREATE TABLE " + TABLE_CATALOG
                + " (" + KEY_ID + " INTEGER PRIMARY KEY,"
                + CATALOG_TYPE +  " INTEGER,"
                + CATALOG_ID_TYPE +  " INTEGER,"
                + CATALOG_NAME +  " TEXT NOT NULL,"
                + CATALOG_VISIBLE + " INTEGER,"
                + CATALOG_ORDER_NO +  " INTEGER)";
        db.execSQL(CREATE_STRING);

        //Create USER Table
        CREATE_STRING = "CREATE TABLE " + TABLE_USER
                + " (" + USER_EMAIL + " TEXT NOT NULL,"
                + USER_GENDER + " INTEGER,"
                + NAME + " TEXT NOT NULL,"
                + USER_BIRTHDATE + " INTEGER,"
                + USER_COUNTRY + " INTEGER,"
                + USER_WEIGHT + " REAL,"
                + USER_HEIGHT + " REAL,"
                + USER_PHYSICAL + " INTEGER,"
                + USER_LIFECYCLE + " INTEGER,"
                + USER_CARB_UNITS + " INTEGER)";
        db.execSQL(CREATE_STRING);

        //Create USER_RECORD Table
        CREATE_STRING = "CREATE TABLE " + TABLE_USER_RECORD
                + " (" + RECORD_DIABETES_TYPE + " INTEGER NOT NULL,"
                + RECORD_DIAGNOSTIC_DATE + " INTEGER NOT NULL,"
                + RECORD_TREATMENT + " INTEGER,"
                + RECORD_FARMACO + " INTEGER,"
                + RECORD_INSULIN_UNITS + " REAL)";
        db.execSQL(CREATE_STRING);

        //Create GLUCOSA Table
        CREATE_STRING = "CREATE TABLE " + TABLE_GLUCOSA
                + " (" + KEY_ID + " INTEGER PRIMARY KEY,"
                + GLUCOSA_DATE + " INTEGER NOT NULL,"
                + GLUCOSA_VALUE + " INTEGER,"
                + GLUCOSA_SESSION + " INTEGER,"
                + GLUCOSA_PERIOD + " INTEGER,"
                + GLUCOSA_RESULT + " INTEGER,"
                + GLUCOSA_CREATE_DATE + " INTEGER,"
                + GLUCOSA_COMMENT + " TEXT)";
        db.execSQL(CREATE_STRING);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
