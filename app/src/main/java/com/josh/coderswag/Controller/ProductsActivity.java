package com.josh.coderswag.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.josh.coderswag.Adapters.ProductRecyclerAdapter;
import com.josh.coderswag.Model.Product;
import com.josh.coderswag.R;
import com.josh.coderswag.Services.DataService;

import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        Intent intent = getIntent();
        TextView productCategory = (TextView)findViewById(R.id.productCategory);
        String extraCategory = intent.getStringExtra(MainActivity.EXTRA_CATEGORY);
        productCategory.setText(extraCategory);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.productRecyclerView);

        List<Product> productList;
        if (extraCategory.equals("HATS")) {
            productList = DataService.getDataService().getHats();
        } else if (extraCategory.equals("SHIRTS")){
            productList = DataService.getDataService().getShirts();
        } else if (extraCategory.equals("HOODIES")){
            productList = DataService.getDataService().getHoodies();
        //} else if (extraCategory.equals("DIGITAL")){
        //    productList = DataService.getDataService().getDigital();
        } else {
            productList = DataService.getDataService().getHats();
        }

        ProductRecyclerAdapter adapter = new ProductRecyclerAdapter(this, productList);

        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Log.d("ProductsActivity", "Finished OnCreate");

    }
}