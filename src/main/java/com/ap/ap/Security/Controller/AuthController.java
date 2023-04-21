
package com.ap.ap.Security.Controller;

import com.ap.ap.Security.Dto.JwtDto;
import com.ap.ap.Security.Dto.LoginUsuario;
import com.ap.ap.Security.Dto.NuevoUsuario;
import com.ap.ap.Security.Entity.Rol;
import com.ap.ap.Security.Entity.UsuarioSecurity;
import com.ap.ap.Security.Enums.RolNombre;
import com.ap.ap.Security.Service.RolService;
import com.ap.ap.Security.Service.UsuarioServiceSecurity;
import com.ap.ap.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins ="**")
public class AuthController {
    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;
    @Autowired
    @Lazy
    AuthenticationManager authenticationManager;
    @Autowired
    @Lazy
    UsuarioServiceSecurity usuarioServiceSecurity;
    @Autowired
    @Lazy
    RolService rolService;
    @Autowired
    @Lazy
    JwtProvider jwtProvider;
    
    
    @PostMapping ("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje ("Campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        
     
         
         UsuarioSecurity usuarioSecurity = new UsuarioSecurity(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
         nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
         
         Set<Rol> roles = new HashSet <>();
         roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
         
         if (nuevoUsuario.getRoles().contains("admin"))
             roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
         usuarioSecurity.setRoles(roles);
         usuarioServiceSecurity.save(usuarioSecurity);
         
         return new ResponseEntity(new Mensaje ("Usuario guardado"), HttpStatus.CREATED);
         
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje ("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
}
