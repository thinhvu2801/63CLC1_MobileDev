package com.vmt.sqlite_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase bookDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookDB = openOrCreateDatabase("Sach.db", MODE_PRIVATE, null );
        String sqlXoaBangNeuDaCo = "DROP TABLE IF EXISTS BOOKS";
        String sqlTaoBang = "CREATE TABLE BOOKS(BookID integer PRIMARY KEY, "+
                "BookName text, "+
                "Page integer, "+
                "Price float, "+
                "Description text)";

        bookDB.execSQL(sqlXoaBangNeuDaCo);
        bookDB.execSQL(sqlTaoBang);

        String sqlThemDong1 = "INSERT INTO BOOKS VALUES(1, 'Java',100,9.99,'Sách về Java')";
        bookDB.execSQL(sqlThemDong1);
        String sqlThemDong2 = "INSERT INTO BOOKS VALUES(1, 'Android',320, 19.00,'Android')";
        bookDB.execSQL(sqlThemDong2);
        Button btnBN;
        btnBN = findViewById(R.id.btnBooknavi);

        btnBN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookNavigationActivity.class);
                startActivity(intent);
            }
        });

    }
}