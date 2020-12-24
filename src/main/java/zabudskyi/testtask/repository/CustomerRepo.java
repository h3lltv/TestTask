package zabudskyi.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zabudskyi.testtask.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
