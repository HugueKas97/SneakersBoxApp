package com.example.sneakersshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddAddressActivity extends AppCompatActivity {

    private Button AddBtn, ReturnBtn;
    private EditText Name, Address, Reference;
    private static EditText AddressInfo;

    DatabaseReference databaseSneakers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        databaseSneakers = FirebaseDatabase.getInstance().getReference("address");

        AddBtn = (Button) findViewById(R.id.add_address_btn);
        ReturnBtn = (Button) findViewById(R.id.return_address_btn);
        Name = (EditText) findViewById(R.id.add_address_name);
        Address = (EditText) findViewById(R.id.add_address_detail);
        Reference = (EditText) findViewById(R.id.add_address_reference);

        AddressInfo = (EditText) findViewById(R.id.add_address_detail);

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAddress();
            }
        });

        ReturnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddAddressActivity.this, AddressActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addAddress() {
        String name = Name.getText().toString();
        String address = Address.getText().toString();
        String reference = Reference.getText().toString();




        String id = databaseSneakers.push().getKey();

        Address address1 = new Address(id, name, address, reference);

        databaseSneakers.child(id).setValue(address1);



        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "Por favor escribe el nombre del producto", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(address)){
            Toast.makeText(this, "Por favor escribe el precio", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(reference)){
            Toast.makeText(this, "Por favor escribe el stock", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Dirección Añadida", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(AddAddressActivity.this, HomeOptionsActivity.class);
            startActivity(intent);
        }
    }

    public static String getData(){
        String AddressInfo2 = AddressInfo.getText().toString();
        return AddressInfo2;
    }
}
