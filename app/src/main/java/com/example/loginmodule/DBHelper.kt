package com.example.loginmodule

import android.content.Context
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.properties.Delegates

class DBHelper(context: Context) :
    SQLiteOpenHelper(context,"USERDB",null,1) {

//    private lateinit var USER_TABLE:String
//    private var ID_COL by Delegates.notNull<Int>()
//    private lateinit var NAME_COL:String
//    private lateinit var EMAIL_COL:String
//    private lateinit var PASSWORD_COL:String
//    private lateinit var MOBILENO_COL:String

    override fun onCreate(db: SQLiteDatabase?) {


//
//        val query = ("CREATE TABLE "+USER_TABLE + " ("+
//                ID_COL+" INTEGER PRIMARY KEY, " +
//                NAME_COL+"TEXT,"+
//                EMAIL_COL+"TEXT," +
//                PASSWORD_COL+"TEXT,"+
//                MOBILENO_COL+"TEXT"+
//                ") ")
//
//        db?.execSQL(query)

        db?.execSQL("CREATE TABLE USER ( ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME VARCHAR(30),EMAIL VARCHAR(100),PASSWORD VARCHAR(20),MOBILENO VARCHAR(20) )")


//        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT,EMAIL TEXT,PASSWORD TEXT)")
//        db?.execSQL("INSERT INTO USERS(EMAIL,PASSWORD) VALUES('jaynee0202@gmail.com','testrun')")
//        db?.execSQL("INSERT INTO USERS(EMAIL,PASSWORD) VALUES('jaynesh@gmail.com','testrun')")
//        db?.execSQL("INSERT INTO USERS(EMAIL,PASSWORD) VALUES('jay0202@gmail.com','testrun')")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {


    }

    fun insertUserData(name:String,email:String,password:String,mobile:String) {

        val db : SQLiteDatabase = this.writableDatabase
        val values : ContentValues = ContentValues()
        values.put("NAME",name)
        values.put("EMAIL",email)
        values.put("PASSWORD",password)
        values.put("MOBILENO",mobile)

        db.insert("USER",null,values)
        db.close()

    }

    fun verifyCredentials(email: String,password: String) : Boolean {
        val db = this.readableDatabase
//        val query = "SELECT * FROM USER WHERE EMAIL=?  AND PASSWORD=?"
        val cursor = db.rawQuery("SELECT * FROM USER WHERE EMAIL=?  AND PASSWORD=?", arrayOf(email,password))
        if(cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

//    fun addName(name:String, email:String, password:String, mobileNo:String) {
//
//        val values=ContentValues()
//
//        values.put(NAME_COL,name)
//        values.put(EMAIL_COL,email)
//        values.put(PASSWORD_COL,password)
//        values.put(MOBILENO_COL,mobileNo)
//
//        val db=this.writableDatabase
//
//        db.insert(USER_TABLE,null,values)
//        db.close()
//
//    }
}