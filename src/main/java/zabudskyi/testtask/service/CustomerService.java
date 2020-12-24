package zabudskyi.testtask.service;

import zabudskyi.testtask.protocol.response.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(String name, String email, String phone);
    List<CustomerDto> findAll();
    void delete(Long id);
    CustomerDto getOne(Long id);
    CustomerDto update(Long id, String name, String phone);
}
