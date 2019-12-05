package com.example.sneakersshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProductsActivity extends AppCompatActivity {

    private Button P1Purchase, P2Purchase, P3Purchase;

    private static TextView ProductInfo;
    private static EditText ProductSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        P1Purchase = (Button) findViewById(R.id.product1_btn);
        P2Purchase = (Button) findViewById(R.id.product2_btn);
        P3Purchase = (Button) findViewById(R.id.product3_btn);


        P1Purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductInfo = (TextView) findViewById(R.id.product_name);
                ProductSize = (EditText) findViewById(R.id.product1_size);
                Intent intent = new Intent(ProductsActivity.this, PurchaseActivity.class);
                startActivity(intent);
            }
        });

        P2Purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductInfo = (TextView) findViewById(R.id.product_name2);
                ProductSize = (EditText) findViewById(R.id.product2_size);
                Intent intent = new Intent(ProductsActivity.this, PurchaseActivity.class);
                startActivity(intent);
            }
        });

        P3Purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductInfo = (TextView) findViewById(R.id.product_name3);
                ProductSize = (EditText) findViewById(R.id.product3_size);
                Intent intent = new Intent(ProductsActivity.this, PurchaseActivity.class);
                startActivity(intent);
            }
        });
    }

    public static String getDataProduct(){
        String ProductInfo2 = ProductInfo.getText().toString();
        return ProductInfo2;
    }

    public static String getDataSize(){
        String ProductSize2 = ProductSize.getText().toString();
        return ProductSize2;
    }
}
