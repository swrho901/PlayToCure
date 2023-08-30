package com.example.teamcmw;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "USER_ID";

    // DBHelper 생성자
    public DBHelper(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    // game1 Table 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE game1(date TEXT, round INT, time REAL, wrong INT, result TEXT, detailResult TEXT)");
        db.execSQL("CREATE TABLE game2(date TEXT, round INT, time REAL, wrong INT, result TEXT, detailResult TEXT)");
        db.execSQL("CREATE TABLE game3(date TEXT, round INT, time REAL, wrong INT, result TEXT, detailResult TEXT)");
    }

    // game1 Table Upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS game1");
        db.execSQL("DROP TABLE IF EXISTS game2");
        db.execSQL("DROP TABLE IF EXISTS game3");
        onCreate(db);
    }

    // game1 Table 데이터 입력
    public void insertGame1(String date, int round, double time, int wrong, String result, String detailResult) {
        SQLiteDatabase db = getWritableDatabase();


        // INSERT 쿼리 실행
        db.execSQL("INSERT INTO game1 VALUES('" + date + "', " + round + ", " + time + ", " + wrong + ", '" + result + "', '" + detailResult + "')");


        db.close();
    }

    // game1 Table 조회
    public String getGame1Result() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM game1", null);
        while (cursor.moveToNext()) {
            // 결과가 있을 때 데이터 처리
            cursor.moveToLast();
            result = cursor.getString(4);

            return result;
        }

        return result;
    }

    public String getGame1DetailResult () {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM game1", null);
        while (cursor.moveToNext()) {
            // 결과가 있을 때 데이터 처리
            cursor.moveToLast();
            result = cursor.getString(5);

            return result;
        }

        return result;
    }

    public int getGame1Round() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        int result = 1;

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM game1", null);
        if (cursor.moveToFirst()) {
            // 결과가 있을 때 데이터 처리
            cursor.moveToLast();
            result += cursor.getInt(1);

        }

        return result;
    }

    // game2 Table 데이터 입력
    public void insertGame2(String date, int round, double time, int wrong, String result, String detailResult) {
        SQLiteDatabase db = getWritableDatabase();


        // INSERT 쿼리 실행
        db.execSQL("INSERT INTO game2 VALUES('" + date + "', " + round + ", " + time + ", " + wrong + ", '" + result + "', '" + detailResult + "')");


        db.close();
    }

    // game2 Table 조회
    public String getGame2Result() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM game2", null);
        while (cursor.moveToNext()) {
            // 결과가 있을 때 데이터 처리
            cursor.moveToLast();
            result = cursor.getString(4);

            return result;
        }

        return result;
    }

    public String getGame2DetailResult () {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM game2", null);
        while (cursor.moveToNext()) {
            // 결과가 있을 때 데이터 처리
            cursor.moveToLast();
            result = cursor.getString(5);

            return result;
        }

        return result;
    }

    public int getGame2Round() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        int result = 1;

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM game2", null);
        if (cursor.moveToFirst()) {
            // 결과가 있을 때 데이터 처리
            cursor.moveToLast();
            result += cursor.getInt(1);

        }

        return result;
    }

    // game2 Table 데이터 입력
    public void insertGame3(String date, int round, double time, int wrong, String result, String detailResult) {
        SQLiteDatabase db = getWritableDatabase();


        // INSERT 쿼리 실행
        db.execSQL("INSERT INTO game3 VALUES('" + date + "', " + round + ", " + time + ", " + wrong + ", '" + result + "', '" + detailResult + "')");


        db.close();
    }

    // game3 Table 조회
//    public String getGame3Result() {
//        // 읽기가 가능하게 DB 열기
//        SQLiteDatabase db = getReadableDatabase();
//        String result = "";
//
//        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
//        Cursor cursor = db.rawQuery("SELECT * FROM game3", null);
//        while (cursor.moveToNext()) {
//            result += " 날짜 : " + cursor.getString(0)
//                    + ", 회차 : "
//                    + cursor.getInt(1)
//                    + " 결과 : "
//                    + cursor.getString(4)
//                    + " 결과 상세 내용 : "
//                    + cursor.getString(5)
//                    + "\n";
//        }
//
//        System.out.print(result);
//
//        return result;
//    }

    public String getGame3Result() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM game3", null);
        while (cursor.moveToNext()) {
            // 결과가 있을 때 데이터 처리
            cursor.moveToLast();
            result = cursor.getString(4);

            return result;
        }

        return result;
    }

    public String getGame3DetailResult () {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM game3", null);
        while (cursor.moveToNext()) {
            // 결과가 있을 때 데이터 처리
            cursor.moveToLast();
            result = cursor.getString(5);

            return result;
        }

        return result;
    }

    public int getGame3Round() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        int result = 1;

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM game3", null);

        if (cursor.moveToFirst()) {
            // 결과가 있을 때 데이터 처리
            cursor.moveToLast();
            result += cursor.getInt(1);

        }


        return result;
    }

}
