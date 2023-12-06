package com.vmt.sqlite_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookNavigationActivity extends AppCompatActivity {
    SQLiteDatabase bookDB;
    Cursor csPointToRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_navigation);
        bookDB = openOrCreateDatabase("Sach.db", MODE_PRIVATE, null );
        //
        csPointToRecord= bookDB.rawQuery("Select * from BOOKS", null);
        csPointToRecord.moveToFirst(); //

        Button btFirst = findViewById(R.id.btnBookFirst);
        Button btLast = findViewById(R.id.btnBookLast);
        Button btNext = findViewById(R.id.btnBookNext);
        Button btPrevious = findViewById(R.id.btnBookPrevious);

        btFirst.setOnClickListener(xuLyFirst);
        btFirst.setOnClickListener(xuLyNext);
    }
    //==========================================================================
    // Cac bo lang nghe va xu lys
    View.OnClickListener xuLyFirst = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            csPointToRecord.moveToFirst();
            capNhatView();
        }
    } ;
    //==========================================================================
    void capNhatView() {
        //Lay du lieu, dat len cac dieu khien
        int ID = csPointToRecord.getInt(0) ;
        String name  =csPointToRecord.getString(1) ;
        int numPage = csPointToRecord.getInt(2) ;
        float price = csPointToRecord.getInt(3) ;
        String des= csPointToRecord.getString(4);
        TextView tvID  = findViewById(R.id.tvBookId);
        TextView tvName  = findViewById(R.id.tvBookName);
        TextView tvPage  = findViewById(R.id.tvBookPage);
        TextView tvPrice  = findViewById(R.id.tvBookPrice);
        TextView tvDes  = findViewById(R.id.tvBookDes);
        tvID.setText( String.valueOf(ID) );
        tvName.setText(name);
        tvPage.setText(String.valueOf(numPage) );
        tvPrice.setText( String.valueOf(price) );
        tvDes.setText( des );
    }
    //==========================================================================
    View.OnClickListener xuLyNext = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            csPointToRecord.moveToNext();
            //Lay du lieu, dat len cac dieu khien
            capNhatView();
        }
    };

}