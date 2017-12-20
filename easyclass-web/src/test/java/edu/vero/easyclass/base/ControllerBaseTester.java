package edu.vero.easyclass.base;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.vero.easyclass.web.EasyClassApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 19:52 2017/12/20.
 * @since easyclass
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasyClassApplication.class
        ,webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ControllerBaseTester
{
    protected MockMvc mockMvc;

    protected ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public void setMockMvc(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }
}
