package com.louissegarcia.orderyjoy.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.louissegarcia.orderyjoy.Model.Role;


public interface RoleRepository extends JpaRepository<Role, Long >{
    Optional<Role> findByName(String name);
}
