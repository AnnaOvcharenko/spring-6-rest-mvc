package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.mappers.CustomerMapper;
import guru.springframework.spring6restmvc.model.CustomerDTO;
import guru.springframework.spring6restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Anna Ovcharenko
 */
@Service
@RequiredArgsConstructor
@Primary
public class CustomerServiceJPA implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public List<CustomerDTO> listCustomers() {
        return null;
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.empty();
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public CustomerDTO updateCustomer(UUID id, CustomerDTO customer) {
        return null;
    }

    @Override
    public void deleteCustomer(UUID id) {

    }

    @Override
    public void patchCustomer(UUID id, CustomerDTO customer) {

    }
}
