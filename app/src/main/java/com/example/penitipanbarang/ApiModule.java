package com.example.penitipanbarang;

import com.example.penitipanbarang.model.CategoryResponse;
import com.example.penitipanbarang.model.DataCategoryy;
import com.example.penitipanbarang.model.DataLoker;
import com.example.penitipanbarang.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiModule {

//    @GET("loker/index")
//    Call<DataLoker> getItems();

    @GET("loker/index")
    Call<DataLoker> getItems(@Query("page") int page, @Query("limit") int limit);

    @GET("category/index")
    Call<DataCategoryy> getItemsCategory();

    @POST("loker/create")
    Call<Item> createLoker(@Body Item item);

    @GET("loker/index")
    Call<DataLoker> searchLoker(@Query("search") String searchTerm);
}
