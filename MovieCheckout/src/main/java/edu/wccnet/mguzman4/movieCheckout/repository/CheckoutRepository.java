package edu.wccnet.mguzman4.movieCheckout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.wccnet.mguzman4.movieCheckout.entity.Checkout;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Integer> {
    List<Checkout> findByCustomerId(int customerId);
    
    
}



