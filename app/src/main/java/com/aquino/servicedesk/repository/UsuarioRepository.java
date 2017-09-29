package com.aquino.servicedesk.repository;
import com.aquino.servicedesk.model.Usuario;
import java.util.ArrayList;
import java.util.List;


public class UsuarioRepository {

    private static UsuarioRepository _INSTANCE = null;

    private UsuarioRepository(){}

    public static UsuarioRepository getInstance(){

        if(_INSTANCE == null)
            _INSTANCE = new UsuarioRepository();
        return _INSTANCE;

    }

    private static List<Usuario> usuarios = new ArrayList<>();

    public void inicializar(){
        Usuario u1= new Usuario("eaquino","123", "Eleen Aquino", 1);
        Usuario u2= new Usuario("rgomez","1234", "Raul Gomez", 2);
        Usuario u3= new Usuario("mcruz","12345", "Maria Cruz", 3);
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
    }

    public static Usuario validarUsuario(String user, String password){

            for(Usuario usuario: usuarios){
                    if(usuario.getUsername().equals(user) && usuario.getPassword().equals(password)) {
                        return usuario;
                    }
            }
            return null;
     }
}
