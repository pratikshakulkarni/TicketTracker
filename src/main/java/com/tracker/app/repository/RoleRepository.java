package com.tracker.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.app.model.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role,Integer>{

	public Role findByRole(String role);
}
