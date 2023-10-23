package com.example.penitipanbarang;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class ResultActivity extends AppCompatActivity {
private TextView txNamaBarang;
private TextView txDeskripsi;
private TextView txNamaPemilik;
private TextView txKondisi;
private TextView txPenitipan;
private TextView txPengambilan;
private TextView txKategori;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        Bundle bundle = getIntent().getExtras();
        txNamaBarang = findViewById(R.id.txNamaBarang);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        txNamaPemilik = findViewById(R.id.txNamaPemilik);
        txKondisi = findViewById(R.id.txKondisi);
        txPenitipan = findViewById(R.id.txPenitipan);
        txPengambilan = findViewById(R.id.txPengambilan);
        txKategori = findViewById(R.id.txKategori);
        txNamaBarang.setText("" + bundle.getString("namaBarang"));
        txDeskripsi.setText("" +bundle.getString("deskripsiBarang"));
        txNamaPemilik.setText("" +bundle.getString("nama_customer"));
        txKondisi.setText("" +bundle.getString("kondisi"));
        txPenitipan.setText("" + bundle.getString("tgl_penitipan"));
        txPengambilan.setText("" + bundle.getString("tgl_pengambilan"));
        txKategori.setText("" + bundle.getString("category"));
    }
}
