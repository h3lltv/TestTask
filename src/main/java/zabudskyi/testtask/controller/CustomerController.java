package zabudskyi.testtask.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zabudskyi.testtask.domain.Customer;
import zabudskyi.testtask.protocol.request.AddCustomerRequest;
import zabudskyi.testtask.protocol.request.DeleteCustomerRequest;
import zabudskyi.testtask.protocol.request.UpdateCustomerRequest;
import zabudskyi.testtask.protocol.response.CustomerDto;
import zabudskyi.testtask.service.CustomerService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<CustomerDto>> list() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid AddCustomerRequest request) {
        CustomerDto customer = customerService.createCustomer(request.getFullName(), request.getEmail(), request.getPhone());
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getOne(@PathVariable("id") Customer customer) {
        return ResponseEntity.ok(CustomerDto.fromCustomer(customer));
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerDto> update(
            @PathVariable("id") Customer customerFromDb,
            @Valid @RequestBody Customer customer
    ) {
        BeanUtils.copyProperties(customer, customerFromDb, "id", "creationDate", "updateDate");
        CustomerDto customer1 = customerService.createCustomer(customer.getFullName(),
                customer.getEmail(),
                customer.getPhone());
        customerFromDb.setUpdateDate(LocalDateTime.now());
        return ResponseEntity.ok(customer1);
    }

    @Transactional
    @DeleteMapping("{id}")
    public void delete(@RequestBody @Valid DeleteCustomerRequest request) {
        customerService.delete(request.getId());
    }
}