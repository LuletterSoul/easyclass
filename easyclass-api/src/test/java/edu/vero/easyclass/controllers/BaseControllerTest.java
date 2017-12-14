package edu.vero.easyclass.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.vero.easyclass.web.EasyClassApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  1:14 2017/12/15.
 * @since easyclass
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EasyClassApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class BaseControllerTest {

    protected ObjectMapper objectMapper = new ObjectMapper();

    protected MockMvc mockMvc;

    @Autowired
    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }
}
