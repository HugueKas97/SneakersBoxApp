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

public class PurchaseActivity extends AppCompatActivity{

    private Button AddBtn, ExitBtn;
    private EditText Mail, Address, Card_number, Cvv, Product, ProductSize;

    private static EditText AddressInfo, ProductInfo, ProductSizeInfo;

    DatabaseReference databaseSneakers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        databaseSneakers = FirebaseDatabase.getInstance().getReference("order");

        AddBtn = (Button) findViewById(R.id.purchase_btn);
        ExitBtn = (Button) findViewById(R.id.purchase_return_btn);

        Mail = (EditText) findViewById(R.id.purchase_mail);
        Address = (EditText) findViewById(R.id.purchase_address);
        Card_number = (EditText) findViewById(R.id.purchase_card);
        Cvv = (EditText) findViewById(R.id.purchase_cvv);
        Product = (EditText) findViewById(R.id.purchase_item);
        ProductSize = (EditText) findViewById(R.id.purchase_item_size);

        AddressInfo = (EditText) findViewById(R.id.purchase_address);
        ProductInfo = (EditText) findViewById(R.id.purchase_item);
        ProductSizeInfo = (EditText) findViewById(R.id.purchase_item_size);

        String mailtext = LoginActivity.getData();
        String addresstext = AddAddressActivity.getData();
        String card_numbertext = CardActivity.getData();
        String producttext = ProductsActivity.getDataProduct();
        String productsize = ProductsActivity.getDataSize();

        Mail.setText(mailtext);
        Address.setText(addresstext);
        Card_number.setText(card_numbertext);
        Product.setText(producttext);
        ProductSize.setText(productsize);

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOrder();
            }
        });
        ExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PurchaseActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void addOrder() {

        String mail = Mail.getText().toString();
        String address = Address.getText().toString();
        String card_number = Card_number.getText().toString();
        String cvv = Cvv.getText().toString();
        String product = Product.getText().toString();
        String productsize = ProductSize.getText().toString();

        String id = databaseSneakers.push().getKey();

        Order order = new Order(id, mail, address, card_number, cvv, product, productsize);

        databaseSneakers.child(id).setValue(order);



        if (TextUtils.isEmpty(mail)){
            Toast.makeText(this, "Por favor escribe el mail de usuario", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(address)){
            Toast.makeText(this, "Por favor escribe la dirección", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(card_number)){
            Toast.makeText(this, "Por favor escribe el número de tarjeta", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(cvv)){
            Toast.makeText(this, "Por favor escribe el cvv de tarjeta", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(product)){
            Toast.makeText(this, "Por favor escribe el producto", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(productsize)){
            Toast.makeText(this, "Por favor escribe la talla deseada", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Orden Completada", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(PurchaseActivity.this, PurchaseCompletedActivity.class);
            startActivity(intent);
        }
    }

    public static String getDataAddress(){
        String AddressInfo2 = AddressInfo.getText().toString();
        return AddressInfo2;
    }

    public static String getDataItem(){
        String ProductInfo2 = ProductInfo.getText().toString();
        return ProductInfo2;
    }

    public static String getDataItemSize(){
        String ProductSizeInfo2 = ProductSizeInfo.getText().toString();
        return ProductSizeInfo2;
    }
}