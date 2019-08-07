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

public class budget extends AppCompatActivity {
    List<product> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        recyclerView = (RecyclerView) findViewById(R.id.recycler1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();

        productList.add(
                new product(
                        1,
                        "Redmi Note 7 Pro",
                        "Best Camera & Performance",
                        4.8,
                        13999,
                        R.drawable.rn7));

        productList.add(
                new product(
                        2,
                        "Samsung Galaxy M30",
                        "Reliability & Triple Camera",
                        4.2,
                        14999,
                        R.drawable.m30));

        productList.add(
                new product(
                        3,
                        "Realme 3 Pro",
                        "Performance to Price ratio",
                        4.5,
                        14999,
                        R.drawable.re3));

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