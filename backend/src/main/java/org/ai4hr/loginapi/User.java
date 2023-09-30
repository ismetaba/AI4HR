package org.ai4hr.loginapi;

import jakarta.persistence.*;

/**
 * Represents a user entity in the system.
 * This entity is used for authentication purposes.
 *
 * @author ismetabaci
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Role role;

    /**
     * Enum representing user roles in the system.
     */
    public enum Role {
        /** Represents a regular user. */
        USER,

        /** Represents an administrator. */
        ADMIN
    }

    /**
     * Gets the username of the user.
     *
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for the user.
     *
     * @param username the username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the user.
     *
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the ID of the user.
     *
     * @return the user ID.
     */
    public Long getId() {
        return id;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
