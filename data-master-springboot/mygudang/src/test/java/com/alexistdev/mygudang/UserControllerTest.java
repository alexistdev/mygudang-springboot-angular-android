package com.alexistdev.mygudang;

import com.alexistdev.mygudang.controller.UserController;
import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    public void simpleRegistrationApiTest() throws Exception{
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/api/users";
        User user = new User();
        user.setPhone("082371408678");
        user.setName("Alex");
        user.setEmail("alexistdev@gmail.com");
        user.setPassword("1234");
        String inputJson = this.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}