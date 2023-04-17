
package com.ap.ap.Security.Repository;

import com.ap.ap.Security.Entity.Rol;
import com.ap.ap.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
    
}
