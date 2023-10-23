package com.example.penitipanbarang;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.penitipanbarang.model.DataLoker;
import com.example.penitipanbarang.model.Item_1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewBarangActivity extends AppCompatActivity {
    private RecyclerView rvLoker;
    List<Item_1> item_1s;
    private int currentPage = 1;
    private int limit = 4;
    private boolean isLoading = false;
    private RecyclerViewLoker recyclerViewLoker;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        rvLoker = findViewById(R.id.rvLoker);
        item_1s = new ArrayList<>();
        recyclerViewLoker = new RecyclerViewLoker(item_1s);
        rvLoker.setAdapter(recyclerViewLoker);
        rvLoker.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration itemDecoration = new DividerItemDecoration(rvLoker.getContext(), LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider_item_decorator));
        rvLoker.addItemDecoration(itemDecoration);
        recyclerViewLoker.setListernerClick(new RecyclerViewLoker.ListernerClick() {
            @Override
            public void onClick(int position, Item_1 item1) {
                Bundle bundle = new Bundle();
                bundle.putString("namaBarang", item1.getNamaBarang());
                bundle.putString("deskripsiBarang", item1.getDeskripsiBarang());
                bundle.putString("kondisi", item1.getKondisi());
                bundle.putString("tgl_penitipan", item1.getTglPenitipan());
                bundle.putString("tgl_pengambilan", item1.getTglPengambilan());
                bundle.putString("nama_customer", item1.getNamaCustomer());
                bundle.putString("category", item1.getCategory().getCategoryName());
                bundle.putString("created_at", item1.getCreatedAt());
                Intent intent = new Intent(ViewBarangActivity.this, ResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        rvLoker.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!recyclerView.canScrollVertically(1) && !isLoading) {
                    loadMoreItems();
                }
            }


        });
        loadItems();





    }

    private void loadItems() {
        isLoading = true;
        ApiModule apiService = RetroClient.getClient().create(ApiModule.class);
        Call<DataLoker> api = apiService.getItems(currentPage, limit);

        api.enqueue(new Callback<DataLoker>() {
            @Override
            public void onResponse(Call<DataLoker> call, Response<DataLoker> response) {
                if (response.isSuccessful()) {
                    isLoading = false;
                    List<Item_1> listItem = response.body().getData().getItems();
                    for (int i = 0; i < listItem.size(); i++) {
                        item_1s.add(new Item_1(listItem.get(i).getNamaBarang(), listItem.get(i).getDeskripsiBarang(), listItem.get(i).getKondisi(), listItem.get(i).getTglPenitipan(), listItem.get(i).getTglPengambilan(), listItem.get(i).getNamaCustomer(), listItem.get(i).getCategory()));

                    }
                    currentPage++;
                    if (listItem.isEmpty()){
                        Toast.makeText(ViewBarangActivity.this, "Tidak ada data lagi", Toast.LENGTH_SHORT).show();
                    }
                    recyclerViewLoker.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<DataLoker> call, Throwable t) {
                isLoading = false;
                t.printStackTrace();
            }
        });

    }
    private void loadMoreItems() {
        isLoading = true;
        Toast.makeText(this, "Sedang memuat data...", Toast.LENGTH_SHORT).show();
        loadItems();
    }


}
