package org.ai4hr.loginapi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Tests {@link UserService} class.
 *
 * @author ismetabaci
 */
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testValidateUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPass");

        when(userRepository.findByUsernameAndPassword("testUser", "testPass")).thenReturn(user);

        User result = userService.validateUser("testUser", "testPass");
        assertNotNull(result);
        assertEquals("testUser", result.getUsername());
    }
}
