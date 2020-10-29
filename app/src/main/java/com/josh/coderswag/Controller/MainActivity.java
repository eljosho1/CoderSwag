package com.josh.coderswag.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.josh.coderswag.Adapters.CategoryAdapter;
import com.josh.coderswag.Model.Category;
import com.josh.coderswag.R;
import com.josh.coderswag.Services.DataService;

public class MainActivity extends AppCompatActivity {

    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new CategoryAdapter(this,
                DataService.getDataService().getCategories());
//        adapter = new ArrayAdapter<Category>(this,
//                android.R.layout.simple_list_item_1,
//                DataService.getDataService().getCategories());

        ListView categoryListView = (ListView)findViewById(R.id.categoryListView);
        categoryListView.setAdapter(adapter);

        //Not for recycler views
//        categoryListView.setOnItemClickListener((parent, view, position, id) -> {
//            Category category = DataService.getDataService().getCategories().get(position);
//            Toast.makeText(MainActivity.this, "You clicked the " + category.getTitle() + " cell", Toast.LENGTH_SHORT).show();
//        });
    }
}