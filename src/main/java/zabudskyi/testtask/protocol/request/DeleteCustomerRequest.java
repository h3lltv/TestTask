package zabudskyi.testtask.protocol.request;

import javax.validation.constraints.NotBlank;

public class DeleteCustomerRequest {

    @NotBlank
    public Long id;

    public DeleteCustomerRequest() {
    }

    public DeleteCustomerRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
