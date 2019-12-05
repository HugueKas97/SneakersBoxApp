package com.example.sneakersshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;


import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private Button CreateAccountBtn;
    private EditText Inputname, Inputmail, Inputpassword;
    private ProgressDialog loadingBar;

    private FirebaseAuth mAuth;

    DatabaseReference databaseSneakers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        databaseSneakers = FirebaseDatabase.getInstance().getReference("userclient");

        CreateAccountBtn = (Button) findViewById(R.id.register_btn_n);
        Inputname = (EditText) findViewById(R.id.register_username_input);
        Inputmail = (EditText) findViewById(R.id.register_mail_input);
        Inputpassword = (EditText) findViewById(R.id.register_pass_input);
        loadingBar = new ProgressDialog(this);

        CreateAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });
    }

    private void CreateAccount() {
        String name = Inputname.getText().toString();
        String mail = Inputmail.getText().toString();
        String password = Inputpassword.getText().toString();

        if (TextUtils.isEmpty(name)){
            Toast.makeText(this, "Por favor escribe tu usuario", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(mail)){
            Toast.makeText(this, "Por favor escribe tu correo", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Por favor escribe tu contraseña", Toast.LENGTH_SHORT).show();
        }
        else{
            loadingBar.setTitle("Crear cuenta");
            loadingBar.setMessage("Por favor espere mientras se verifican las credenciales");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            String id = databaseSneakers.push().getKey();



            UserClient userclient = new UserClient(id,name,mail,password);
            databaseSneakers.child(id).setValue(userclient);

            Toast.makeText(this, "Usuario Agregado Correctamente", Toast.LENGTH_LONG).show();
            
            ValidateEmail(name, mail, password);
        }
    }

    private void ValidateEmail(String name, String mail, String password) {
        mAuth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registro Exitoso!", Toast.LENGTH_LONG).show();
                            loadingBar.dismiss();

                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Registro Fallido!", Toast.LENGTH_LONG).show();
                            loadingBar.dismiss();
                        }
                    }
                });
    }
}
