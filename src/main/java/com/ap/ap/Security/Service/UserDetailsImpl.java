
package com.ap.ap.Security.Service;

import com.ap.ap.Security.Entity.UsuarioPrincipal;
import com.ap.ap.Security.Entity.UsuarioSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService{
    @Autowired
    UsuarioServiceSecurity usuarioServiceSecurity;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        UsuarioSecurity usuarioSecurity = usuarioServiceSecurity.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuarioSecurity);
    }


}
