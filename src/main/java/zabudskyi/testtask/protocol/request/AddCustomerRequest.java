package zabudskyi.testtask.protocol.request;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AddCustomerRequest {

    private Long id;
    @NotBlank
    @Length(min = 2, max = 50)
    private String fullName;

    @NotBlank
    @Length(min = 2, max = 100)
    private String email;

    @Nullable
    @Pattern(regexp="^\\+\\d{6,14}$")
    private String phone;

    public AddCustomerRequest() {
    }

    public AddCustomerRequest(
            Long id,
            @NotBlank @Length(min = 2, max = 50) String fullName,
            @NotBlank @Length(min = 2, max = 100) String email,
            @Nullable @Pattern(regexp = "^\\+\\d{6,14}$") String phone
    ) {
        this.id=id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
