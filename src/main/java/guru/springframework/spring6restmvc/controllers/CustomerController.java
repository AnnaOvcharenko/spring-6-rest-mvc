package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.model.CustomerDTO;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{customerId}")
    public ResponseEntity patchCustomer(@PathVariable("customerId") UUID id,
                                        @RequestBody CustomerDTO customer){
        log.debug("Patch customer - in controller");
        service.patchCustomer(id, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity deleteCustomer(@PathVariable("customerId") UUID id) {
        log.debug("Delete customer - in controller");
        service.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable("customerId") UUID id,
                                         @RequestBody CustomerDTO customer) {
        CustomerDTO updatedCustomer = service.updateCustomer(id, customer);
        log.debug("Update customer - in controller");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerDTO customer) {
        CustomerDTO savedCustomer = service.addCustomer(customer);
        log.debug("Add Customer - in controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedCustomer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CustomerDTO> listCustomers() {
        log.debug("List customers - in controller");
        return service.listCustomers();
    }

    @GetMapping("/{customerId}")
    public CustomerDTO getCustomerById(@PathVariable("customerId") UUID id) {
        log.debug("Get customer by ID - in controller");
        return service.getCustomerById(id).orElseThrow(NotFoundException::new);
    }
}
