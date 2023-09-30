package org.ai4hr.loginapi;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testSuccessfulLogin() throws Exception {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        when(userService.validateUser(anyString(), anyString())).thenReturn(user);

        mockMvc.perform(post("/login")
                        .contentType("application/json")
                        .content("{\"username\":\"testUser\", \"password\":\"testPassword\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUnsuccessfulLogin() {
        when(userService.validateUser(anyString(), anyString())).thenReturn(null);

        User user = new User();
        user.setUsername("invalidUsername");
        user.setPassword("invalidPassword");

        assertThrows(LoginException.class, () -> {
            mockMvc.perform(post("/login")
                            .contentType("application/json")
                            .content("{\"username\":\"testUser\", \"password\":\"testPassword\"}"));
        });
    }
}
