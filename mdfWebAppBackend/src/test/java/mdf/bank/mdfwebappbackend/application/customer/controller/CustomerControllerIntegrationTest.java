package mdf.bank.mdfwebappbackend.application.customer.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static mdf.bank.mdfwebappbackend.ObjectUtils.objectOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void shouldGetCustomer() throws Exception {
        //given
        int userLogin = 100;
        //when
        CustomerResponse result = objectOf(mockMvc.perform(get("/customer/data/" + userLogin))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn(), CustomerResponse.class);
        //then
        assertThat(result.getLogin()).isEqualTo(userLogin);
    }
}