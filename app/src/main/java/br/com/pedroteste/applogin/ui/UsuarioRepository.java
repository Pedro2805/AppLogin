package br.com.pedroteste.applogin.ui;

import android.app.Application;

import androidx.lifecycle.LiveData;

public class UsuarioRepository<UsuarioDao> {
    private UsuarioDao usuarioDao;
    private LiveData<Usuario> usuario;
    UsuarioRepository(Application application) {
        AlunoRoomDatabase db = AlunoRoomDatabase.getDatabase(application);
        db.usuarioDao();

    }
    LiveData<Usuario> getUsuario() {
        return usuario;
    }
    void insert(Usuario usuario) {
        AlunoRoomDatabase.databaseWriteExecutor.execute(() -> {

        });
    }
}
