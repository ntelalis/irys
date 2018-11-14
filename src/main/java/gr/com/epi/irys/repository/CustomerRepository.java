package gr.com.epi.irys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.com.epi.irys.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Optional<Customer> findById(Long id);
	
}
