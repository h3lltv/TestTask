package zabudskyi.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zabudskyi.testtask.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    @Modifying
    @Query("update Customer c set c.fullName =:name, c.phone=:phone where c.id=:id")
    void update(@Param("id") Long id, @Param("phone") String phone, @Param("name") String name);
}
