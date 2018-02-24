package com.example.lucasnfraga.myvouchers.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lucasnfraga.myvouchers.R;

public class CriarContaActivity extends AppCompatActivity
{
    private Button btNovoUsuario;
    private Button btNovaEmpresa;
    private TextView btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btNovoUsuario = (Button) findViewById(R.id.bt_novo_usuario);
        btNovaEmpresa = (Button) findViewById(R.id.bt_nova_empresa);
        btLogin       = (TextView) findViewById(R.id.bt_voltar_login);

        btNovoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CriarContaActivity.this, FormUserActivity.class ));
            }
        });

        btNovaEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CriarContaActivity.this, FormEmpresaActivity.class ));
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CriarContaActivity.this, MainActivity.class ));
            }
        });
    }
}
