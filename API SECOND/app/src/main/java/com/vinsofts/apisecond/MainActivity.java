package com.vinsofts.apisecond;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.vinsofts.apisecond.adapter.MyAdapter;
import com.vinsofts.apisecond.model.ContactsRespone;
import com.vinsofts.apisecond.model.Item;
import com.vinsofts.apisecond.remote.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView recyclerView1;
    MyAdapter adapter;
    MyAdapter adapter1;
    List<Item> mList;
    List<Item> mList1;
    Call<ContactsRespone> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = new ArrayList<>();
        mList1 = new ArrayList<>();

        loadRespone();
        loadRespone1();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView1 = findViewById(R.id.recyclerview1);

        LinearLayoutManager manager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        LinearLayoutManager manager1 =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(manager1);

        adapter = new MyAdapter(this, mList);
        adapter1 = new MyAdapter(this, mList1);

        recyclerView.setAdapter(adapter);
        recyclerView1.setAdapter(adapter1);
    }

    public void loadRespone1() {
        call = RestClient.getClient().getRespone();
        call.enqueue(new Callback<ContactsRespone>() {
            @Override
            public void onResponse(Call<ContactsRespone> call, Response<ContactsRespone> response) {
                ContactsRespone result = response.body();
                List<Item> data = result.getItems();
                mList1.clear();
                mList1.addAll(data);
                adapter1.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<ContactsRespone> call, Throwable t) {
                Log.d("thangXXX", "111");
            }
        });
    }

    public void loadRespone() {

        call = RestClient.getClient().getData("ios");

        call.enqueue(new Callback<ContactsRespone>() {
            @Override
            public void onResponse(Call<ContactsRespone> call, Response<ContactsRespone> response) {
                ContactsRespone result = response.body();
                List<Item> data = result.getItems();
                mList.clear();
                mList.addAll(data);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ContactsRespone> call, Throwable t) {

            }
        });
    }




}
