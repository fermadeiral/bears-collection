package assembleiavirtual.login;

import assembleiavirtual.SuperControllerHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class LoginControllerTest extends SuperControllerHelper {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LoginController loginController;

    @Test
    public void contextLoads() {
        assertThat(loginController).isNotNull();
    }

    @Test
    public void testRoot() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testWithouBody() throws Exception {
        mockMvc.perform(get("/login")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testEmptyBody() throws Exception {
        mockMvc.perform(get("/login")
                .contentType(APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testUnauthorized() throws Exception {
        when(loginService.login(any(String.class), any(String.class))).thenReturn(false);

        mockMvc.perform(get("/login")
                .contentType(APPLICATION_JSON)
                .content("{\"email\":\"email@email.email\"}"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testAuthorized() throws Exception {
        when(loginService.login(any(String.class), any(String.class))).thenReturn(true);

        mockMvc.perform(get("/login")
                .contentType(APPLICATION_JSON)
                .content("{\"email\":\"email@email.email\"}"))
                .andExpect(status().isFound());
    }

}
