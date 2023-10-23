package com.example.penitipanbarang;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import retrofit2.Call;

import android.util.CloseGuard;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.penitipanbarang.model.Data;
import com.example.penitipanbarang.model.DataLoker;
import com.example.penitipanbarang.model.Item_1;
import com.google.gson.Gson;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {
    private Button btnView;
    private Button btnSimpan;
    private Button btnCari;
    private TextView txtId;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnView = findViewById(R.id.btnView);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnCari = findViewById(R.id.btnCari);


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, ViewBarangActivity.class));
            }
        });
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, InsertActivity.class));
            }
        });
        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, SearchActivity.class));
            }
        });


    }
}
