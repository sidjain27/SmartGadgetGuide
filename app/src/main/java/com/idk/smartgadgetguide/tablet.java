package com.idk.smartgadgetguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
public class tablet extends AppCompatActivity {
    List<product> productList;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();

        productList.add(
                new product(
                        1,
                        "Lenovo Yoga Tab 3 Pro",
                        "10.1 inch, Best In Class Design",
                        4.4,
                        39999,
                        R.drawable.yoga));

        productList.add(
                new product(
                        2,
                        "Ipad Mini 5",
                        "7.9 inch, Apple's Ecosystem",
                        4.2,
                        24000,
                        R.drawable.ipad));

        productList.add(
                new product(
                        3,
                        "Samsung Galaxy Tab S4 Pro ",
                        "10.4 inch, Business Class Tablet",
                        4.6,
                        55999,
                        R.drawable.tabs4));

        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
    public void goTogsm (View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://m.gsmarena.com"));
        startActivity(intent);
    }
    public void goToxda(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.xda-developers.com"));
        startActivity(intent);
    }
}