package com.example.sneakersshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeOptionsActivity extends AppCompatActivity {

    private Button ProductsBtn, OrdersBtn, AddressBtn, CardBtn, ExitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_options);

        ExitBtn = (Button) findViewById(R.id.main_salir);
        ProductsBtn = (Button) findViewById(R.id.main_productos);
        AddressBtn = (Button) findViewById(R.id.main_direcciones);
        OrdersBtn = (Button) findViewById(R.id.main_ordenes);
        CardBtn = (Button) findViewById(R.id.main_pagos);

        ProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeOptionsActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        AddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeOptionsActivity.this, AddressActivity.class);
                startActivity(intent);
            }
        });

        OrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeOptionsActivity.this, PurchaseActivity.class);
                startActivity(intent);
            }
        });

        CardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeOptionsActivity.this, CardActivity.class);
                startActivity(intent);
            }
        });

        ExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeOptionsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
