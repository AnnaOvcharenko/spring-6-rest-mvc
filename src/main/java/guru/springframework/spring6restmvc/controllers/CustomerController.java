package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author Anna Ovcharenko
 */

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public List<Customer> listCustomers(){
        log.debug("List customers - in controller");
        return service.listCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") UUID id){
        log.debug("Get customer by ID - in controller");
        return service.getCustomerById(id);
    }
}
