package com.example.lucasnfraga.myvouchers.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lucasnfraga.myvouchers.R;
import com.example.lucasnfraga.myvouchers.config.ConfiguracaoFirebase;
import com.example.lucasnfraga.myvouchers.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DatabaseReference;

public class FormUserActivity extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;
    private EditText email;
    private EditText senha;
    private Button botaoCadastrar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);

        nome = (EditText) findViewById(R.id.nome_usuario);
        cpf = (EditText) findViewById(R.id.cpf_usuario);
        email = (EditText) findViewById(R.id.email_usuario);
        senha = (EditText) findViewById(R.id.senha_usuario);
        botaoCadastrar = (Button) findViewById(R.id.salvar_usuario);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usuario = new Usuario();
                usuario.setNome(nome.getText().toString());
                usuario.setCpf(cpf.getText().toString());
                usuario.setEmail(email.getText().toString());
                usuario.setSenha(senha.getText().toString());
                cadastrarUsuario();
            }
        });
    }

    private void cadastrarUsuario(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(FormUserActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Toast.makeText(FormUserActivity.this,"Cadastro realizado com sucesso", Toast.LENGTH_LONG).show();

                    usuario.setId(task.getResult().getUser().getUid());
                    usuario.salvar();

                    Intent vouchers = new Intent(FormUserActivity.this, VoucherActivity.class);
                    startActivity(vouchers);
                }else{

                    String erroExcecao = "";

                    try{
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e){
                        erroExcecao = "Digite uma senha mais forte!";
                    } catch (FirebaseAuthInvalidCredentialsException e){
                        erroExcecao = "E-mail digitado inválido!";
                    } catch (FirebaseAuthUserCollisionException e){
                        erroExcecao = "E-mail já cadastrado!";
                    } catch (Exception e) {
                        erroExcecao = "Cadastro não realizado";
                        e.printStackTrace();
                    }
                    Toast.makeText(FormUserActivity.this,"Erro: " + erroExcecao, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
