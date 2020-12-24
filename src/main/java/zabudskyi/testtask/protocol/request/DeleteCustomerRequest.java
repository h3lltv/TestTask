package zabudskyi.testtask.protocol.request;

import javax.validation.constraints.NotNull;

public class DeleteCustomerRequest {

    @NotNull
    private Long id;

    public DeleteCustomerRequest() {
    }

    public DeleteCustomerRequest(@NotNull Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
