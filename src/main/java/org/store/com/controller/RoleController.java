package org.store.com.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.com.model.Role;
import org.store.com.repo.RoleRepository;
import org.store.com.service.RoleService;

@RestController
public class RoleController {
	private RoleService roleService;
    private RoleRepository roleRepository;

    public RoleController(RoleService roleService, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/role/create")
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        return  roleService.addRole(role);
    }
	/*
	 * @DeleteMapping("/role/delete/{id}") public ResponseEntity<Object>
	 * deleteRole(@PathVariable Long id) { return roleService.deleteRole(id); }
	 * 
	 * @GetMapping("/role/details/{id}") public Role getRole(@PathVariable Long id)
	 * { if(roleRepository.findById(id).isPresent()) return
	 * roleRepository.findById(id).get(); else return null; }
	 * 
	 * @GetMapping("/role/all") public List<Role> getRoles() { return
	 * roleRepository.findAll(); }
	 * 
	 * @PutMapping("/role/update/{id}") public ResponseEntity<Object>
	 * updateRole(@PathVariable Long id, @RequestBody Role role) { return
	 * roleService.updateRole(id, role); }
	 */
}
