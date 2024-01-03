package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Anna Ovcharenko
 */

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl() {
        log.debug("Set up map of customers in Customer Service");
        this.customerMap = new HashMap<>();

        CustomerDTO customer1 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("First")
                .version(1)
                .createDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO customer2 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Second")
                .version(1)
                .createDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        CustomerDTO customer3 = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Third")
                .version(1)
                .createDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
        customerMap.put(customer3.getId(), customer3);

    }

    @Override
    public List<CustomerDTO> listCustomers() {
        log.debug("List customers - in service");
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        log.debug("Get customer by ID - in service");
        return Optional.of(customerMap.get(id));
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customer) {
        CustomerDTO newCustomer = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .createDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .name(customer.getName())
                .version(customer.getVersion())
                .build();
        customerMap.put(newCustomer.getId(), newCustomer);
        log.debug("Add customer - in service");
        return newCustomer;
    }

    @Override
    public CustomerDTO updateCustomer(UUID id, CustomerDTO customer) {
        CustomerDTO updatedCustomer = customerMap.get(id);
        updatedCustomer.setVersion(customer.getVersion());
        updatedCustomer.setName(customer.getName());
        updatedCustomer.setLastModifiedDate(LocalDateTime.now());
        log.debug("Update customer - in service");
        return updatedCustomer;
    }

    @Override
    public void deleteCustomer(UUID id) {
        log.debug("Delete customer - in service");
        customerMap.remove(id);
    }

    @Override
    public void patchCustomer(UUID id, CustomerDTO customer) {
        CustomerDTO patchedCustomer = customerMap.get(id);
        if (StringUtils.hasText(customer.getName())) {
            patchedCustomer.setName(customer.getName());
        }
        if (customer.getVersion() != null) {
            patchedCustomer.setVersion(customer.getVersion());
        }
        patchedCustomer.setLastModifiedDate(LocalDateTime.now());
        log.debug("Patch customer - in service");
    }
}
