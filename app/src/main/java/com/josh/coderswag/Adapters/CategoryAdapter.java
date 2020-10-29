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
        ViewHolder holder;

        //if there are no list view cells
        if (convertView == null){
            // so this inflating the layout to a view, is only done once
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null);
            holder = new ViewHolder();
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage);
            holder.categoryName = categoryView.findViewById(R.id.categoryName);

            categoryView.setTag(holder);
            Log.d(LOG_TAG, "View created pos: " + position);
        } else {
            holder = (ViewHolder)convertView.getTag();
            categoryView = convertView;
        }


        Category category = categories.get(position);
        holder.categoryName.setText(category.getTitle());

        int resourceId = context.getResources().getIdentifier(category.getImage(), "drawable", context.getPackageName());
        holder.categoryImage.setImageResource(resourceId);
        Log.d(LOG_TAG, "Pos: " + position + ", ResourceId: " + resourceId);

        return categoryView;
    }

    private class ViewHolder {
        ImageView categoryImage;
        TextView categoryName;
    }
}
