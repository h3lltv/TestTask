package zabudskyi.testtask.protocol.request;

import com.sun.istack.Nullable;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdateCustomerRequest {
    @NotNull
    private Long id;
    @Length(min = 2, max = 50)
    private String name;
    @Nullable
    @Pattern(regexp = "^\\+\\d{6,14}$")
    private String phone;


    public UpdateCustomerRequest(@NotNull Long id,
                                 @Length(min = 2, max = 50) String name,
                                 @Nullable @Pattern(regexp = "^\\+\\d{6,14}$") String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public UpdateCustomerRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
