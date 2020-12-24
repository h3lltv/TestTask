package zabudskyi.testtask.protocol.request;

import javax.validation.constraints.NotBlank;

public class GetCustomerRequest {
    @NotBlank
    private Long id;

    public GetCustomerRequest() {
    }

    public GetCustomerRequest(@NotBlank Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
