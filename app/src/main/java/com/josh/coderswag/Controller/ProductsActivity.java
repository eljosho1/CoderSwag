package com.josh.coderswag.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.josh.coderswag.Adapters.ProductRecyclerAdapter;
import com.josh.coderswag.Model.Product;
import com.josh.coderswag.R;
import com.josh.coderswag.Services.DataService;
import com.josh.coderswag.Utilities.Constants;

import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    private ProductRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        Intent intent = getIntent();
        TextView productCategory = (TextView)findViewById(R.id.productCategory);
        String extraCategory = intent.getStringExtra(Constants.EXTRA_CATEGORY);
        productCategory.setText(extraCategory);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.productRecyclerView);

        List<Product> productList = DataService.getDataService().getProducts(extraCategory);

        adapter = new ProductRecyclerAdapter(this, productList);

        int orientation = getResources().getConfiguration().orientation;
        int spanCount = 2;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3;
        }

        int screenSize = getResources().getConfiguration().screenWidthDp;
        if (screenSize > 720){
            spanCount = 4;
        }

        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, spanCount, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Log.d("ProductsActivity", "Finished OnCreate");

    }
}