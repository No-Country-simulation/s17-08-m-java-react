package com.nocountry.server.repository;

import com.nocountry.server.model.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

    List<Role> findRolesByRoleEnumIn(List<String> roles);
}
