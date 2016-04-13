package hello;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GreetingControllerTest {
	
	private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();

    @Test
    public void testGreeting() throws Exception {
        this.mockMvc.perform(get("/greeting/")
        	.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

    }

}
