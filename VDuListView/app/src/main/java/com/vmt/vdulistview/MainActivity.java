    package com.vmt.vdulistview;

    import androidx.appcompat.app.AppCompatActivity;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.ListView;
    import android.widget.Toast;

    import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

        ArrayList<String> dsNNLT = new ArrayList<String>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            getWidget();
            dsNNLT.add("C");
            dsNNLT.add("C++");
            dsNNLT.add("Java");
            dsNNLT.add("Python");
            dsNNLT.add("JavaScript");
            dsNNLT.add("Ruby");
            dsNNLT.add("Go");
            dsNNLT.add("Swift");
            dsNNLT.add("Kotlin");
            dsNNLT.add("C#");
            dsNNLT.add("PHP");
            dsNNLT.add("R");
            ArrayAdapter<String> adapterNNLT = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dsNNLT);
            listViewNNLT.setAdapter(adapterNNLT);
            listViewNNLT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    // code xu ly
                    // i laf vi tri item duoc chon
                    // vd lay ve gia tri
                    // cach 1
                    //String mucchon = adapternnlt.getItem(i);
                    // cach 2
                    String mucchon1 = dsNNLT.get(i).toString();
                    //xử lí dữ liệu
                    //Toast
                    String chuoiTB = "You selected "+ mucchon1;
                    Toast.makeText(MainActivity.this,chuoiTB,Toast.LENGTH_LONG).show();
                }
            });
        }
        public void getWidget(){
            listViewNNLT = findViewById(R.id.lvNNLT);
        }
        ListView listViewNNLT;

    }