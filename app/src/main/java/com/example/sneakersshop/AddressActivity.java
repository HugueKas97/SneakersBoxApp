package com.example.sneakersshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddressActivity extends AppCompatActivity {

    private Button AddBtn, ReturnBtn;
    ListView listViewAddress;
    List<Address> addressList;

    DatabaseReference databaseSneakers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        databaseSneakers = FirebaseDatabase.getInstance().getReference("address");

        AddBtn = (Button) findViewById(R.id.add_address_btn);
        listViewAddress = (ListView) findViewById(R.id.list_address);

        addressList = new ArrayList<>();

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddressActivity.this, AddAddressActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseSneakers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                addressList.clear();
                for(DataSnapshot addressSnapshot : dataSnapshot.getChildren()){
                    Address address = addressSnapshot.getValue(Address.class);
                    addressList.add(address);
                }

                AddressList adapter = new AddressList(AddressActivity.this, addressList);
                listViewAddress.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
