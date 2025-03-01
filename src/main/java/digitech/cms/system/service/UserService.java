package digitech.cms.system.service;

import digitech.cms.system.entity.User;
import digitech.cms.system.entity.UserRole;
import digitech.cms.system.repository.UserRepository;
import digitech.cms.system.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public UserRole createRole(UserRole role) {
        return userRoleRepository.save(role);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public List<UserRole> listRoles() {
        return userRoleRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserRole getRoleById(Long id) {
        return userRoleRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteRole(Long id) {
        userRoleRepository.deleteById(id);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    public UserRole updateRole(Long id, UserRole roleDetails) {
        UserRole role = userRoleRepository.findById(id).orElse(null);
        if (role != null) {
            role.setName(roleDetails.getName());
            role.setModelGUI(roleDetails.getModelGUI());
            role.setDescription(roleDetails.getDescription());
            return userRoleRepository.save(role);
        }
        return null;
    }
}