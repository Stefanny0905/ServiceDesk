package com.aquino.servicedesk.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aquino.servicedesk.R;
import com.aquino.servicedesk.model.Usuario;
import com.aquino.servicedesk.repository.UsuarioRepository;

public class MainActivity extends AppCompatActivity {

    EditText text_user;
    EditText text_password;
    Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_user = (EditText)findViewById(R.id.user);
        text_password = (EditText)findViewById(R.id.password);
        button_login = (Button)findViewById(R.id.login);

        UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
        usuarioRepository.inicializar();
    }

    public void login(View view) {
        String user= text_user.getText().toString();
        String password= text_password.getText().toString();
        Usuario usuario=UsuarioRepository.validarUsuario(user, password);
        if(usuario!=null){
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("nombre", usuario.getNombres());
            intent.putExtra("rol", String.valueOf(usuario.getRol()));
            startActivity(intent);

        }else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }

    }
}
