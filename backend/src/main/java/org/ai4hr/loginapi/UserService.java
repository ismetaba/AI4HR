package org.ai4hr.loginapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for user-related operations.
 *
 * @author ismetabaci
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Validates a user based on the provided username and password.
     *
     * @param username the username of the user.
     * @param password the password of the user.
     * @return the user if valid, null otherwise.
     */
    public User validateUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
