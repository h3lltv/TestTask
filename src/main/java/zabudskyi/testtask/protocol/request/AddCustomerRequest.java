package zabudskyi.testtask.protocol.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AddCustomerRequest {
    @NotBlank
    @Length(min = 2, max = 50)
    private String fullName;

    @NotBlank
    @Length(min = 2, max = 100)
    private String email;

    @Pattern(regexp="^\\+\\d{6,14}$")
    private String phone;

    public AddCustomerRequest() {
    }

    public AddCustomerRequest(
            @NotBlank @Length(min = 2, max = 50) String fullName,
            @NotBlank @Length(min = 2, max = 100) String email,
            @Pattern(regexp = "^\\+\\d{6,14}$") String phone
    ) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
