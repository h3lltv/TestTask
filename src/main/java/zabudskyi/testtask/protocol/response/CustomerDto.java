package zabudskyi.testtask.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import zabudskyi.testtask.domain.Customer;

public class CustomerDto {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String fullName;
    @JsonProperty
    private String email;
    @JsonProperty
    private String phone;

    public CustomerDto(Long id, String fullName, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public static CustomerDto fromCustomer(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getFullName(), customer.getEmail(), customer.getPhone());
    }
}
