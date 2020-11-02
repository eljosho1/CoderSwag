package com.josh.coderswag.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.josh.coderswag.Model.Product;
import com.josh.coderswag.R;
import com.josh.coderswag.Utilities.Constants;

import org.w3c.dom.Text;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        Intent originIntent = getIntent();
        Product product = originIntent.getParcelableExtra(Constants.EXTRA_PRODUCT);

        TextView viewTitle = (TextView)findViewById(R.id.productDetailTitle);
        viewTitle.setText(product.getTitle());

        TextView viewPrice = (TextView) findViewById(R.id.productDetailPrice);
        viewPrice.setText(product.getPrice());

        int imageIdenifier = getResources().getIdentifier(product.getImage(), "drawable", getPackageName());
        ImageView viewImage = (ImageView) findViewById(R.id.productDetailImage);
        viewImage.setImageResource(imageIdenifier);

        Button buyButton = findViewById(R.id.productDetailBuyButton);
        buyButton.setOnClickListener((v)->{
            Toast.makeText(this, "Added to cart!!", Toast.LENGTH_SHORT).show();
        });
    }
}