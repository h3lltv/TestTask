package zabudskyi.testtask.protocol.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import zabudskyi.testtask.domain.Customer;

public class UpdateCustomerDto {

    @JsonProperty
    private String fullName;

    @JsonProperty
    private String phone;

    public UpdateCustomerDto(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }

    public static UpdateCustomerDto fromCustomer(Customer customer) {
        return new UpdateCustomerDto(customer.getFullName(), customer.getPhone());
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }
}
