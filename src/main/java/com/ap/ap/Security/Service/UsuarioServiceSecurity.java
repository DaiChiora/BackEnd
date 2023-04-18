
package com.ap.ap.Security.Service;

import com.ap.ap.Security.Entity.UsuarioSecurity;
import com.ap.ap.Security.Repository.IUsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceSecurity {
    @Autowired
            @Lazy
    IUsuarioRepository iusuarioRepository;
    
    public Optional<UsuarioSecurity> getByNombreUsuario (String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    


    public void save (UsuarioSecurity usuarioSecurity) {
        iusuarioRepository.save (usuarioSecurity);
    }
    
}
