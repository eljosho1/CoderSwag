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

import com.josh.coderswag.Model.Product;
import com.josh.coderswag.R;

import java.util.List;
import java.util.function.Consumer;

public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.HolderProduct> {

    private static final String PRODUCT_RECYCLER_TAG = "ProductRecyclerAdapter";
    private Context context;
    private List<com.josh.coderswag.Model.Product> productList;
    private Consumer<Product> clickConsumer;

//    public interface ClickConsumer{
//        void customClick(Product product);
//    }

    public ProductRecyclerAdapter(Context context, List<com.josh.coderswag.Model.Product> productList, Consumer<Product> clickConsumer) {
        this.context = context;
        this.productList = productList;
        this.clickConsumer = clickConsumer;
    }

    @NonNull
    @Override
    public HolderProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productView = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false);
        Log.d(PRODUCT_RECYCLER_TAG, "created Holder Product");

        return new HolderProduct(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderProduct holder, int position) {
        Log.d(PRODUCT_RECYCLER_TAG, "bind product at " + position);
        holder.bindProduct(productList.get(position), context);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    class HolderProduct extends RecyclerView.ViewHolder {

        TextView productName = itemView.findViewById(R.id.productName);
        TextView productPrice = itemView.findViewById(R.id.productPrice);
        ImageView productImage = itemView.findViewById(R.id.productImage);

        public HolderProduct(@NonNull View itemView) {
            super(itemView);
        }


        public void bindProduct(Product product, Context context) {
            productName.setText(product.getTitle());
            productPrice.setText(product.getPrice());
            int identifier = context.getResources().getIdentifier(product.getImage(), "drawable", context.getPackageName());
            productImage.setImageResource(identifier);
            itemView.setOnClickListener(v -> clickConsumer.accept(product));
        }
    }
}
