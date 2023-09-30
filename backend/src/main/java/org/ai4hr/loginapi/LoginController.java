package org.ai4hr.loginapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for handling user login requests.
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint to validate user login.
     *
     * @param user The user credentials to validate.
     * @return A message indicating the result of the login attempt.
     */
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws LoginException {
        User validatedUser = userService.validateUser(user.getUsername(), user.getPassword());
        if (validatedUser != null) {
            return user;
        } else {
            throw new LoginException();
        }
    }
}
