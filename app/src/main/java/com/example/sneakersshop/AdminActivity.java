package com.example.sneakersshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminActivity extends AppCompatActivity {

    private Button AddBtn, ReturnBtn;
    private EditText Description, Price, Stock, Status, Detail;

    DatabaseReference databaseSneakers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        databaseSneakers = FirebaseDatabase.getInstance().getReference("product");

        AddBtn = (Button) findViewById(R.id.add_product_btn);
        ReturnBtn = (Button) findViewById(R.id.return_btn);
        Description = (EditText) findViewById(R.id.add_description);
        Price = (EditText) findViewById(R.id.add_price);
        Stock = (EditText) findViewById(R.id.add_stock);
        Status = (EditText) findViewById(R.id.add_status);
        Detail = (EditText) findViewById(R.id.add_detail);

        ReturnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();

            }
        });
    }

    private void addProduct() {
        String description = Description.getText().toString();
        String price = Price.getText().toString();
        String stock = Stock.getText().toString();
        String status = Status.getText().toString();
        String detail = Detail.getText().toString();

        String id = databaseSneakers.push().getKey();

        Product product = new Product(id, description, price, stock, status, detail);

        databaseSneakers.child(id).setValue(product);



        if (TextUtils.isEmpty(description)){
            Toast.makeText(this, "Por favor escribe el nombre del producto", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(price)){
            Toast.makeText(this, "Por favor escribe el precio", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(stock)){
            Toast.makeText(this, "Por favor escribe el stock", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(status)){
            Toast.makeText(this, "Por favor escribe el estado del producto", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(detail)){
            Toast.makeText(this, "Por favor escribe los detalles del producto", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Producto Añadido", Toast.LENGTH_LONG).show();
            Description.setText("Nombre del Producto");
            Price.setText("Precio");
            Stock.setText("Stock del Producto");
            Status.setText("Estado del Producto");
            Detail.setText("Detalle");
        }


    }
}
