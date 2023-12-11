package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Anna Ovcharenko
 */

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID,Customer> customerMap;

    public CustomerServiceImpl(){
        log.debug("Set up map of customers in Customer Service");
        this.customerMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .name("First")
                .version(1)
                .createDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Second")
                .version(1)
                .createDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .id(UUID.randomUUID())
                .name("Third")
                .version(1)
                .createDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(),customer1);
        customerMap.put(customer2.getId(),customer2);
        customerMap.put(customer3.getId(),customer3);

    }

    @Override
    public List<Customer> listCustomers() {
        log.debug("List customers - in service");
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        log.debug("Get customer by ID - in service");
        return customerMap.get(id);
    }
}
