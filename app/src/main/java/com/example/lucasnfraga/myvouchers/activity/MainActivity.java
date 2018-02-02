package com.example.lucasnfraga.myvouchers.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lucasnfraga.myvouchers.R;

public class MainActivity extends AppCompatActivity
{
    private Button btNovoUsuario;
    private Button btNovaEmpresa;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btNovoUsuario = (Button) findViewById(R.id.bt_novo_usuario_id);
        btNovaEmpresa = (Button) findViewById(R.id.bt_nova_empresa_id);
        //btLogin       = (Button) findViewById(R.id.bt_login_id);

        btNovoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormUserActivity.class ));
            }
        });

        btNovaEmpresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormEmpresaActivity.class ));
            }
        });

        /*btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormLoginActivity.class ));
            }
        });*/
    }
}
