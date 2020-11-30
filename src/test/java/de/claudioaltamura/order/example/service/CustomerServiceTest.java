package de.claudioaltamura.order.example.service;

import de.claudioaltamura.order.example.entity.Address;
import de.claudioaltamura.order.example.entity.Customer;
import de.claudioaltamura.order.example.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@Import({CustomerService.class, CustomerRepository.class})
class CustomerServiceTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    void test() {
        Customer customer = new Customer();
        customer.setName("Peter");

        Customer result = new Customer();
        result.setName("Peter");
        result.setId(1L);
        when(customerRepository.save(any(Customer.class))).thenReturn(result);

        customerService.add(customer);

        //assertThet
        
        verify(customerRepository).save(any(Customer.class));
    }

}
