package zabudskyi.testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zabudskyi.testtask.domain.Customer;
import zabudskyi.testtask.exceptions.NotFoundException;
import zabudskyi.testtask.protocol.response.CustomerDto;
import zabudskyi.testtask.repository.CustomerRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerDto createCustomer(String name, String email, String phone) {
        Customer customer = new Customer(name, email, phone);
        customerRepo.save(customer);
        return CustomerDto.fromCustomer(customer);
    }

    public List<CustomerDto> findAll(){
        return customerRepo.findAll().stream().map(CustomerDto::fromCustomer).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Customer customer =
                customerRepo.findById(id).orElseThrow(() ->NotFoundException.customerNotFoundException(id));
        customer.setDeleted();
        customerRepo.save(customer);
    }

    @Override
    public CustomerDto getOne(Long id) {
        return CustomerDto.fromCustomer(customerRepo.findById(id).orElseThrow(() ->NotFoundException.customerNotFoundException(id)));
    }

    @Override
    public CustomerDto update(Long id, String name, String phone) {
        Customer customer = customerRepo.findById(id).orElseThrow(() ->NotFoundException.customerNotFoundException(id));
        customer.updateNameAndPhone(name, phone);
        customerRepo.save(customer);
        return CustomerDto.fromCustomer(customer);
    }
}
