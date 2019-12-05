package com.example.sneakersshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;

public class LoginActivity extends AppCompatActivity {

    private Button LoginAccountBtn, TestBtn;
    private EditText Loginmail, Loginpassword;
    private TextView AdminLink;
    private ProgressDialog loadingBar;
    private static EditText LoginMailTry;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth = FirebaseAuth.getInstance();

        LoginAccountBtn = (Button) findViewById(R.id.login_btn_n);
        Loginmail = (EditText) findViewById(R.id.login_mail_input);
        LoginMailTry = (EditText) findViewById(R.id.login_mail_input);
        Loginpassword = (EditText) findViewById(R.id.login_pass_input);
        AdminLink = (TextView) findViewById(R.id.admin_link);
        loadingBar = new ProgressDialog(this);

        LoginAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/*                String emailvalue = Loginmail.getText().toString();
                Intent intent = new Intent(LoginActivity.this, PurchaseActivity.class);
                intent.putExtra("MAIL", emailvalue);
                startActivity(intent);*/

                LoginAccount();
            }
        });
        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = Loginmail.getText().toString();
                String password = Loginpassword.getText().toString();

                if(mail.equals("hugo-metallica@hotmail.com") && password.equals("abcd1234")){
                    Toast.makeText(LoginActivity.this, "Login Correcto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Error: Información de Admin incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void LoginAccount() {
        String mail = Loginmail.getText().toString();
        String password = Loginpassword.getText().toString();

        if (TextUtils.isEmpty(mail)){
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

            LoginEmail(mail, password);
        }
    }

    private void LoginEmail(String mail, String password) {
        mAuth.signInWithEmailAndPassword(mail, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Inicio Exitoso!", Toast.LENGTH_LONG).show();
                            loadingBar.dismiss();

                            Intent intent = new Intent(LoginActivity.this, HomeOptionsActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(getApplicationContext(), "Inicio Fallido!", Toast.LENGTH_LONG).show();
                            loadingBar.dismiss();
                        }
                    }
                });
    }

    public static String getData(){
        String LoginMailTry2 = LoginMailTry.getText().toString();
        return LoginMailTry2;
    }
}
