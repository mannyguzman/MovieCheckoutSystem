package edu.wccnet.mguzman4.movieCheckout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.wccnet.mguzman4.movieCheckout.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
 //   List<Customer> findById(int id);
	
	@Query("SELECT c.name FROM Customer c WHERE c.id = :customerId")
    String findNameById(@Param("customerId") int customerId);

}
