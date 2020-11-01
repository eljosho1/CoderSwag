package com.josh.coderswag.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.josh.coderswag.Model.Category;
import com.josh.coderswag.R;

import java.util.List;

public class CategoryRecycleAdapter extends RecyclerView.Adapter<CategoryRecycleAdapter.Holder> {

    // Define the listener interface????
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    Context context;
    List<Category> categories;
    private OnItemClickListener listener;

    public CategoryRecycleAdapter(Context context, List<Category> categories, OnItemClickListener listener) {
        this.context = context;
        this.categories = categories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //infalte layout to view
        View categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false);
        Log.d("RecyclerView", "oncreateViewHolder()");
        //create holderwith the view
        return new Holder(categoryView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bindCategory(categories.get(position), context);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        private final ImageView categoryImage = itemView.findViewById(R.id.categoryImage);
        private final TextView categoryName = itemView.findViewById(R.id.categoryName);

        public Holder(@NonNull View itemView) {
            super(itemView);
        }

        public void bindCategory(Category category, Context context){
            categoryName.setText(category.getTitle());
            int identifier = context.getResources().getIdentifier(category.getImage(), "drawable", context.getPackageName());
            categoryImage.setImageResource(identifier);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });

            Log.d("RecyclerView", "Binding: " + category.getTitle() + ", " + category.getImage() + " (" + getAdapterPosition() + ")");
        }

    }




}
