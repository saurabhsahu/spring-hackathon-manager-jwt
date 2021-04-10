package com.hackthon.manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackthon.manager.controlller.HackathonController;
import com.hackthon.manager.entity.AuthenticationRequest;
import com.hackthon.manager.entity.Challenge;
import com.hackthon.manager.service.ChallengeService;
import com.hackthon.manager.service.EmployeeDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.assertEquals;



@WebMvcTest(value = HackathonController.class)
@WithMockUser
@SpringBootTest
public class HackathonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeDetailsService employeeDetailsService;
    @MockBean
    private ChallengeService challengeService;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private HackathonController hackathonController;


    @Test
    void authenticateTest() throws Exception {
        AuthenticationRequest authRequest = new AuthenticationRequest("1","password");
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/authenticate")
                .accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(authRequest))
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void addChallenge() throws Exception {
        Challenge challenge = new Challenge(1,"challenge1","Description",new String[]{"admin","test"},0,1);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/authenticate")
                .accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(challenge))
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals("Challenge added successfully.", response.getContentAsString());
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

}
