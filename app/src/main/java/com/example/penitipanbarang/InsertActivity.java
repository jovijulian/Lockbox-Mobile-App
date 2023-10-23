package com.example.penitipanbarang;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.penitipanbarang.model.DataCategory;
import com.example.penitipanbarang.model.DataCategoryy;
import com.example.penitipanbarang.model.Item;
import com.example.penitipanbarang.model.ItemsCategory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InsertActivity extends AppCompatActivity {
    private Spinner spinner;
    private EditText edNamaBarang;
    private EditText edDeskripsi;
    private EditText edKondisi;
    private EditText edPenitipan;
    private EditText edPengambilan;
    private EditText edNamaCustomer;
    private Button btnSubmit;
    private CustomSpinnerAdapter spinnerAdapter;
    private Calendar calendar;

    List<ItemsCategory> itemsCategories = new ArrayList<>();
    List<Item> itemList = new ArrayList<>();

    Object mApiService = RetroClient.getClient();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        spinner = findViewById(R.id.spinner);
        edNamaBarang = findViewById(R.id.edNamaBarang);
        edDeskripsi = findViewById(R.id.edDeskripsi);
        edKondisi = findViewById(R.id.edKondisi);
        edPenitipan = findViewById(R.id.edPenitipan);
        edPengambilan = findViewById(R.id.edPengambilan);
        edNamaCustomer = findViewById(R.id.edNamaCustomer);
        btnSubmit = findViewById(R.id.btnSubmit);
        calendar = Calendar.getInstance();

        edPenitipan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerPenitipan();
            }
        });

        edPengambilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerPengambilan();
            }
        });

        spinnerAdapter = new CustomSpinnerAdapter(this, android.R.layout.simple_spinner_item, itemsCategories);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                ItemsCategory selectedItem = itemsCategories.get(position);
                String selectedCategoryId = String.valueOf(selectedItem.getId());
                String selectedCategoryName = String.valueOf(selectedItem.getCategoryName());
                Toast.makeText(getApplicationContext(), "Kategori yang dipilih : " + selectedCategoryName, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        fetchDataFromApi();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createLoker();
            }
        });
    }

    private void fetchDataFromApi() {
        ApiModule apiService = RetroClient.getClient().create(ApiModule.class);
        Call<DataCategoryy> api = apiService.getItemsCategory();

        api.enqueue(new Callback<DataCategoryy>() {
            @Override
            public void onResponse(Call<DataCategoryy> call, Response<DataCategoryy> response) {
                if(response.isSuccessful()){
                    List<ItemsCategory> listCategory = response.body().getDataCategory().getItems();
                    for (int i = 0; i < listCategory.size(); i++) {
                        ItemsCategory category = new ItemsCategory(
                                listCategory.get(i).getId(),
                                listCategory.get(i).getCategoryName()
                        );
                        itemsCategories.add(category);
                    spinnerAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<DataCategoryy> call, Throwable t) {

            }
        });
    }

    private void createLoker() {
        String nama_barang = edNamaBarang.getText().toString();
        String deskripsi_barang = edDeskripsi.getText().toString();
        String kondisi = edKondisi.getText().toString();
        String tgl_penitipan = edPenitipan.getText().toString();
        String tgl_pengambilan = edPengambilan.getText().toString();
        String nama_customer = edNamaCustomer.getText().toString();
        int selectedPosition = spinner.getSelectedItemPosition();
        ItemsCategory selectedItem = itemsCategories.get(selectedPosition);
        String category_id = selectedItem.getId().toString();
        Item loker = new Item(nama_barang, deskripsi_barang, kondisi, tgl_penitipan, tgl_pengambilan, nama_customer, category_id);
        ApiModule apiService = RetroClient.getClient().create(ApiModule.class);
        Call<Item> itemCall = apiService.createLoker(loker);
        itemCall.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                if(!response.isSuccessful()){
                    try {
                        String errorBody = response.errorBody().string();
                        Toast.makeText(InsertActivity.this, errorBody, Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            itemList.add(response.body());
                Toast.makeText(InsertActivity.this, "Berhasil simpan barang!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(InsertActivity.this, ViewBarangActivity.class));
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
                Toast.makeText(InsertActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showDatePickerPenitipan() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                        LocalDate selectedDate = LocalDate.of(year, month + 1, dayOfMonth);

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                        String formattedDate = selectedDate.format(formatter);

                        edPenitipan.setText(formattedDate);

                    }
                },
                year,
                month,
                day
        );

        datePickerDialog.show();
    }

    private void showDatePickerPengambilan() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                        LocalDate selectedDate = LocalDate.of(year, month + 1, dayOfMonth);

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                        String formattedDate = selectedDate.format(formatter);


                        edPengambilan.setText(formattedDate);
                    }
                },
                year,
                month,
                day
        );

        datePickerDialog.show();
    }

}
