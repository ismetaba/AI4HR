package org.ai4hr.loginapi;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing and querying User entities.
 *
 * @author ismetabaci
 */
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * Finds a user based on the provided username and password.
     *
     * @param username the username of the user.
     * @param password the password of the user.
     * @return the user if found, null otherwise.
     */
    User findByUsernameAndPassword(String username, String password);
}
