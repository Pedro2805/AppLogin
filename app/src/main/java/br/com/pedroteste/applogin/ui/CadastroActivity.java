package br.com.pedroteste.applogin.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

import br.com.pedroteste.applogin.R;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Hawk.init(this).build();
    }

    public void salvar(View view) {
        Hawk.put("tem_cadastro",true);
        Toast.makeText(this, "Registro salvo com sucesso!",
                Toast.LENGTH_SHORT).show();
        finish();
    }
}