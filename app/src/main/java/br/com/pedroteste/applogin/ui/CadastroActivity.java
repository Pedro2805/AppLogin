package br.com.pedroteste.applogin.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

import br.com.pedroteste.applogin.R;

public class CadastroActivity<UsuarioViewModel, Usuario> extends AppCompatActivity {
    private UsuarioViewModel usuarioViewModel;
    private Usuario usuarioCorrente;
    private EditText editTextNome;
    private EditText editTextCpf;
    private EditText editTextEmail;
    private EditText editTextSenha;

    public CadastroActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Hawk.init(this).build();

        editTextNome = findViewById(R.id.editTextNome);
        editTextCpf = findViewById(R.id.editTextCPF);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSenha = findViewById(R.id.editTextSenha);



    }

    private void updateView(Usuario usuario){


        }
    

    public void salvar(View view) {



        Hawk.put("tem_cadastro",true);
        Toast.makeText(this, "Registro salvo com sucesso!",
                Toast.LENGTH_SHORT).show();
        finish();
    }
}