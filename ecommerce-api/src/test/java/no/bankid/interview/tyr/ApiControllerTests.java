package no.bankid.interview.tyr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import net.minidev.json.JSONArray;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCheckoutEndpoint() throws Exception {
        JSONArray requestBody = new JSONArray();
        requestBody.add("0001");
        requestBody.add("0002");

        int expectedTotal = 1080;
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/checkout")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody.toJSONString()))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        assertEquals("{\"price\":" + expectedTotal + "}", response);

    }
}
