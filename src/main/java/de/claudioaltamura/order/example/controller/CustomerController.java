package de.claudioaltamura.order.example.controller;

import de.claudioaltamura.order.example.entity.Customer;
import de.claudioaltamura.order.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> find() {
        return ResponseEntity.ok(customerService.find());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> findById(@PathVariable long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping(value= "/customers", consumes = "application/json")
    public ResponseEntity<Void> add(@RequestBody @Valid Customer customer) {
        Customer savedCustomer = customerService.add(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(savedCustomer.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value="/customers/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        customerService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
