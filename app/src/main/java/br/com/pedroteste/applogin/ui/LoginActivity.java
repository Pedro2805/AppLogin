package br.com.pedroteste.applogin.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

import br.com.pedroteste.applogin.R;

public class LoginActivity extends AppCompatActivity {

    private TextView textViewNovoCadastro;
    private Button buttonLogin;
    private UsuarioViewModel usuarioViewModel;
    private Usuario usuarioCorrente;
    private EditText editTextEmail;
    private EditText editTextSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Hawk.init(this).build();
        editTextEmail = findViewById(R.id.editTextUsuário);
        editTextSenha = findViewById(R.id.editTextSenha);

        textViewNovoCadastro = findViewById(R.id.textViewNovoCadastro);
        buttonLogin = findViewById(R.id.buttonLogin);

        usuarioCorrente = new Usuario();


        usuarioViewModel = new ViewModelProvider(this).get(UsuarioViewModel.class);
        usuarioViewModel.getUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(@Nullable final Usuario usuario) {
                updateUsuario(usuario);
            }
        });

    }

    private void updateUsuario(Usuario usuario) {
        this.usuarioCorrente = usuario;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Hawk.contains("tem_cadastro")) {

            if (Hawk.get("tem_cadastro")) {
                habilitarLogin();
            }else{
                desabilitarLogin();
            }

        }else{
            desabilitarLogin();
        }
    }

    private void habilitarLogin() {
        textViewNovoCadastro.setVisibility(View.GONE);
        buttonLogin.setEnabled(true);
        buttonLogin.setBackgroundColor(getColor(R.color.colorPrimary));
    }

    private void desabilitarLogin() {
        textViewNovoCadastro.setVisibility(View.VISIBLE);
        buttonLogin.setEnabled(false);
        buttonLogin.setBackgroundColor(getResources().getColor(R.color.gray));
    }

    public void novoCadastro(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }


    public void login(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}