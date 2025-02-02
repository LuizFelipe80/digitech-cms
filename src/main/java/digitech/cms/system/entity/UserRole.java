package digitech.cms.system.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String modelGUI;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "user_role_grants",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "granted_role_id")
    )
    private Set<UserRole> grantableRoles;

    public UserRole() {
        this.grantableRoles = new HashSet<>();
    }

    public UserRole(String modelGUI, String name, String description) {
        this.modelGUI = modelGUI;
        this.name = name;
        this.description = description;
        this.grantableRoles = new HashSet<>();
    }

    public UserRole(String modelGUI, String name, String description, Set<UserRole> grantableRoles) {
        this.modelGUI = modelGUI;
        this.name = name;
        this.description = description;
        this.grantableRoles = Collections.unmodifiableSet(new HashSet<>(grantableRoles));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelGUI() {
        return modelGUI;
    }

    public void setModelGUI(String modelGUI) {
        this.modelGUI = modelGUI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UserRole> getGrantableRoles() {
        return grantableRoles;
    }

    public void setGrantableRoles(Set<UserRole> grantableRoles) {
        this.grantableRoles = grantableRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(id, userRole.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}