package com.example.penitipanbarang;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.penitipanbarang.model.DataLoker;
import com.example.penitipanbarang.model.Item;
import com.example.penitipanbarang.model.Item_1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class SearchActivity extends AppCompatActivity {
    private Button btnSearch;
    private RecyclerView rvSearch;
    private EditText edCustomer;
    List<Item_1> item_1s;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        btnSearch = findViewById(R.id.btnSearch);
        rvSearch = findViewById(R.id.rvSearch);
        edCustomer = findViewById(R.id.edCustomer);
        item_1s = new ArrayList<>();
        RecyclerViewSearch recyclerViewSearch = new RecyclerViewSearch(item_1s);
        rvSearch.setAdapter(recyclerViewSearch);
        rvSearch.setLayoutManager(new LinearLayoutManager(this));



        btnSearch.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                String searchTerm = edCustomer.getText().toString();
                searchLoker(searchTerm);
                recyclerViewSearch.notifyDataSetChanged();
            }

            private void searchLoker(String searchTerm) {
                item_1s.clear();
                ApiModule apiService = RetroClient.getClient().create(ApiModule.class);
                Call<DataLoker> api = apiService.searchLoker(searchTerm);
                api.enqueue(new Callback<DataLoker>() {
                    @Override
                    public void onResponse(Call<DataLoker> call, Response<DataLoker> response) {
                        if (response.isSuccessful()) {
                            List<Item_1> listItem =  response.body().getData().getItems();
                            for (int i = 0; i < listItem.size(); i++){
                                item_1s.add(new Item_1(listItem.get(i).getNamaBarang(), listItem.get(i).getDeskripsiBarang(), listItem.get(i).getKondisi(), listItem.get(i).getTglPenitipan(), listItem.get(i).getTglPengambilan(), listItem.get(i).getNamaCustomer(), listItem.get(i).getCategory()));
                            }
                            recyclerViewSearch.notifyDataSetChanged();
                            Toast.makeText(SearchActivity.this, "Data ada", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SearchActivity.this, "Gagal melakukan pencarian", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DataLoker> call, Throwable t) {
                        // Tangani kesalahan saat melakukan pencarian
                        Toast.makeText(SearchActivity.this, "Terjadi kesalahan: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
