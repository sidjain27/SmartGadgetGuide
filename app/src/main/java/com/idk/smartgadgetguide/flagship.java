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

public class flagship extends AppCompatActivity {
    List<product> productList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flagship);

        recyclerView = (RecyclerView) findViewById(R.id.recycler3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();

        productList.add(
                new product(
                        1,
                        "OnePlus 6T",
                        "Flagship Processor, Fast Top Ups",
                        4.8,
                        36999,
                        R.drawable.op6t));

        productList.add(
                new product(
                        2,
                        "Samsung Galaxy S10+",
                        "Versatile Camera, Allround Performer",
                        4.7,
                        69999,
                        R.drawable.s10));

        productList.add(
                new product(
                        3,
                        "Huawei P30 Pro",
                        "Periscope Camera, Beautiful Design",
                        4.7,
                        74999,
                        R.drawable.huap30));
        productList.add(
                new product(
                        3,
                        "Iphone XS Max",
                        "iOS Ecosystem and Performance",
                        4.5,
                        99999,
                        R.drawable.ipxs));

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
