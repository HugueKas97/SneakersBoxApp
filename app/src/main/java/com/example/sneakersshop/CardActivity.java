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

public class CardActivity extends AppCompatActivity {

    private Button AddBtn, ReturnBtn;
    private EditText Name, Number, Date, CVV;

    private static EditText CardInfo;

    DatabaseReference databaseSneakers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        databaseSneakers = FirebaseDatabase.getInstance().getReference("card");

        AddBtn = (Button) findViewById(R.id.add_card_btn);
        ReturnBtn = (Button) findViewById(R.id.card_return_btn);
        Name = (EditText) findViewById(R.id.card_name);
        Number = (EditText) findViewById(R.id.card_number);
        Date = (EditText) findViewById(R.id.card_date);
        CVV = (EditText) findViewById(R.id.card_cvv);

        CardInfo = (EditText) findViewById(R.id.card_number);

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCard();
            }
        });

        ReturnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardActivity.this, HomeOptionsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addCard() {
        String name = Name.getText().toString();
        String number = Number.getText().toString();
        String date = Date.getText().toString();
        String cvv = CVV.getText().toString();

        String id = databaseSneakers.push().getKey();

        PurchaseCard card = new PurchaseCard(id, name, number, date, cvv);

        databaseSneakers.child(id).setValue(card);



        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "Por favor escribe el nombre del titular", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(number)){
            Toast.makeText(this, "Por favor escribe el número de tarjeta", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(date)){
            Toast.makeText(this, "Por favor escribe la fecha de expiración", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(cvv)){
            Toast.makeText(this, "Por favor escribe el cvv de tarjeta", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Tarjeta Añadida", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(CardActivity.this, HomeOptionsActivity.class);
            startActivity(intent);
        }
    }

    public static String getData(){
        String CardInfo2 = CardInfo.getText().toString();
        return CardInfo2;
    }
}
