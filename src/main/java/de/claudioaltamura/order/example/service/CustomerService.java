package de.claudioaltamura.order.example.service;

import de.claudioaltamura.order.example.entity.Customer;
import de.claudioaltamura.order.example.exception.CustomerExistsException;
import de.claudioaltamura.order.example.exception.CustomerNotFoundException;
import de.claudioaltamura.order.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> find() {
        return customerRepository.findAll();
    }

    public Customer findById(long id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    public Customer add(Customer customer) {
        List<Customer> existingCustomers = customerRepository.findByName(customer.getName());

        if(!existingCustomers.isEmpty()) {
            throw new CustomerExistsException();
        }

        return customerRepository.save(customer);
    }

    public void delete(long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        customer.ifPresentOrElse(c -> customerRepository.delete(c), CustomerNotFoundException::new);
    }
}
