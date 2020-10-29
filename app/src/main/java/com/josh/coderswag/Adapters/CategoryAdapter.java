package com.josh.coderswag.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.josh.coderswag.Model.Category;
import com.josh.coderswag.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {

    private final Context context;
    private final List<Category> categories;
    private final String LOG_TAG = "CategoryAdapter";

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View categoryView;

        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null);
        ImageView categoryImage = categoryView.findViewById(R.id.categoryImage);
        TextView categoryName = categoryView.findViewById(R.id.categoryName);

        Category category = categories.get(position);
        categoryName.setText(category.getTitle());

        int resourceId = context.getResources().getIdentifier(category.getImage(), "drawable", context.getPackageName());
        categoryImage.setImageResource(resourceId);
        Log.d(LOG_TAG, "ResourceId: " + resourceId);

        return categoryView;
    }
}
