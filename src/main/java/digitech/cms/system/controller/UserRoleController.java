package digitech.cms.system.controller;

import digitech.cms.system.entity.UserRole;
import digitech.cms.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class UserRoleController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserRole> createRole(@RequestBody UserRole role) {
        UserRole createdRole = userService.createRole(role);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserRole>> listRoles() {
        List<UserRole> roles = userService.listRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getRoleById(@PathVariable Long id) {
        UserRole role = userService.getRoleById(id);
        if (role != null) {
            return new ResponseEntity<>(role, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRole> updateRole(@PathVariable Long id, @RequestBody UserRole roleDetails) {
        UserRole updatedRole = userService.updateRole(id, roleDetails);
        if (updatedRole != null) {
            return new ResponseEntity<>(updatedRole, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        userService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}