package org.ai4hr.loginapi;

import java.io.IOException;

/**
 * Exception thrown when a login attempt fails.
 */
public class LoginException extends IOException {

    /**
     * Constructs a new LoginException with a default message.
     */
    public LoginException() {
        super("Invalid login credentials");
    }

    /**
     * Constructs a new LoginException with the specified detail message.
     *
     * @param message the detail message.
     */
    public LoginException(String message) {
        super(message);
    }
}
