package com.example.sneakersshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PurchaseCompletedActivity extends AppCompatActivity {

    private TextView Address, Product, ProductSize;
    private Button ReturnBtn, BuyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_completed);

        Address = (TextView) findViewById(R.id.purchase_retreive_address);
        Product = (TextView) findViewById(R.id.purchase_retreive_product);
        ProductSize = (TextView) findViewById(R.id.purchase_retreive_product_size);

        ReturnBtn = (Button) findViewById(R.id.return_purchase_completed_btn);
        BuyBtn = (Button) findViewById(R.id.buy_purchase_completed_btn);

        String addresstext = PurchaseActivity.getDataAddress();
        String producttext = PurchaseActivity.getDataItem();
        String productsize = PurchaseActivity.getDataItemSize();


        Address.setText(addresstext);
        Product.setText(producttext);
        ProductSize.setText(productsize);

        ReturnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PurchaseCompletedActivity.this, HomeOptionsActivity.class);
                startActivity(intent);
            }
        });

        BuyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PurchaseCompletedActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });
    }
}
