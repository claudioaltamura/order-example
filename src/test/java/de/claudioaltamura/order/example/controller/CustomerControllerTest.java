package de.claudioaltamura.order.example.controller;

import de.claudioaltamura.order.example.entity.Customer;
import de.claudioaltamura.order.example.repository.CustomerRepository;
import de.claudioaltamura.order.example.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @MockBean
    private CustomerRepository repository;

    @Test
    void whenAddCustomerThenReturnIsCreated() throws Exception {
        String request = "{\"name\":\"Sam\"}";

        Customer createdCustomer = new Customer();
        createdCustomer.setId(1L);
        createdCustomer.setName("Sam");
        when(service.add(any(Customer.class))).thenReturn(createdCustomer);

        mockMvc.perform(post("/customers/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isCreated());

        verify(service).add(any(Customer.class));
    }

}