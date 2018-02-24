package com.example.lucasnfraga.myvouchers.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lucasnfraga.myvouchers.R;

public class MainActivity extends AppCompatActivity
{
    private EditText fEmailLogin;
    private EditText fSenhaLogin;
    private Button btLogin;
    private TextView btCriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogin = (Button) findViewById(R.id.bt_login);
        fEmailLogin = (EditText) findViewById(R.id.f_email_login);
        fSenhaLogin = (EditText) findViewById(R.id.f_senha_login);
        btCriarConta = (TextView) findViewById(R.id.bt_criar_conta);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormUserActivity.class ));
            }
        });

        btCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CriarContaActivity.class ));
            }
        });
    }
}
