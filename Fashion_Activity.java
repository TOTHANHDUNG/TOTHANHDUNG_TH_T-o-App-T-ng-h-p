package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Fashion_Activity extends AppCompatActivity {

    ListView lvFashion;
    ArrayList<Fashion> arrayFashion;
    FashionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dong_fashion);
        AnhXa();
        adapter = new FashionAdapter(this, R.layout.activity_fashion, arrayFashion);
        lvFashion.setAdapter(adapter);

        lvFashion.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Fashion_Activity.this, Detail_Activity.class);
                    startActivity(intent);
                }
            }
        });
        lvFashion.setOnItemLongClickListener(new ItemLongClickRemove());
    }
    private void AnhXa(){
        lvFashion = (ListView) findViewById(R.id.listviewFashion);
        arrayFashion = new ArrayList<>();

        arrayFashion.add(new Fashion("STAY","The Kid LAROI, Justin Bieber", R.drawable.abum1,"03:21"));
        arrayFashion.add(new Fashion("STAR WALKIN'","Lil Nas X",R.drawable.abum2,"04:35"));
        arrayFashion.add(new Fashion("Dancing With Your Ghost","Sasha Alex Sloan",R.drawable.abum3,"07:01"));
        arrayFashion.add(new Fashion("Sweet Dreams","Alan Walker,Imanbek",R.drawable.abum4,"02:58"));
        arrayFashion.add(new Fashion("double take","dhruv",R.drawable.abum5,"04:35"));
        arrayFashion.add(new Fashion("Kiss Me More","Doja Cat, SZA",R.drawable.abum6,"04.08"));
        arrayFashion.add(new Fashion("Mood","24KGoldn, lann Dior",R.drawable.abum7,"03.08"));
    }
    private class ItemLongClickRemove implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Fashion_Activity.this);
            alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
            alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // xóa sp đang nhấn giữ
                    arrayFashion.remove(position);
                    //cập nhật lại listview
                    adapter.notifyDataSetChanged();
                }
            });
            alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //không làm gì
                }
            });
            alertDialogBuilder.show();
            return true;
        }
    }
}