package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Anna Ovcharenko
 */
public interface CustomerService {
    List<Customer> listCustomers();

    Optional<Customer> getCustomerById(UUID id);

    Customer addCustomer(Customer customer);

    Customer updateCustomer(UUID id, Customer customer);

    void deleteCustomer(UUID id);

    void patchCustomer(UUID id, Customer customer);
}
