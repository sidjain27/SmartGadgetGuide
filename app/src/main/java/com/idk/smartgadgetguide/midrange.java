package com.idk.smartgadgetguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class midrange extends AppCompatActivity {
    List<product> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midrange);

        recyclerView = (RecyclerView) findViewById(R.id.recycler2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();

        productList.add(
                new product(
                        1,
                        "Poco F1",
                        "Flagship Processor, Great Value for Money",
                        4.8,
                        19999,
                        R.drawable.pof1));

        productList.add(
                new product(
                        2,
                        "Nokia 9 Pureview",
                        "Great Penta Camera & Glass Body",
                        4.4,
                        34999,
                        R.drawable.nok9));

        productList.add(
                new product(
                        3,
                        "Samsung Galaxy A80",
                        "Great Camera, Bezeless Design",
                        4.5,
                        32999,
                        R.drawable.a80));

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
