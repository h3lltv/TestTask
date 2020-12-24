package zabudskyi.testtask.protocol.request;

import javax.validation.constraints.NotNull;

public class GetCustomerRequest {
    @NotNull
    private Long id;

    public GetCustomerRequest() {
    }

    public GetCustomerRequest(@NotNull Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
