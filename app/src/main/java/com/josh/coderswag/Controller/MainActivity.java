package com.josh.coderswag.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.josh.coderswag.Adapters.CategoryAdapter;
import com.josh.coderswag.Adapters.CategoryRecycleAdapter;
import com.josh.coderswag.Model.Category;
import com.josh.coderswag.R;
import com.josh.coderswag.Services.DataService;

public class MainActivity extends AppCompatActivity {

    CategoryRecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "num categores " + DataService.getDataService().getCategories().size());

        adapter = new CategoryRecycleAdapter(this,
                DataService.getDataService().getCategories());
//        adapter = new ArrayAdapter<Category>(this,
//                android.R.layout.simple_list_item_1,
//                DataService.getDataService().getCategories());

        RecyclerView categoryListView = (RecyclerView) findViewById(R.id.categoryListView);

        categoryListView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        categoryListView.setLayoutManager(layoutManager);

        //set this for optimisation, when the cells will always be the same size
        categoryListView.setHasFixedSize(true);

        Log.d("MainActivity", "OnCreate Completed!");

        //Not for recycler views
//        categoryListView.setOnItemClickListener((parent, view, position, id) -> {
//            Category category = DataService.getDataService().getCategories().get(position);
//            Toast.makeText(MainActivity.this, "You clicked the " + category.getTitle() + " cell", Toast.LENGTH_SHORT).show();
//        });
    }
}