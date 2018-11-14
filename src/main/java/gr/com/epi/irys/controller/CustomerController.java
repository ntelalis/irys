package gr.com.epi.irys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gr.com.epi.irys.entity.Customer;
import gr.com.epi.irys.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/customers/{id}")
	public Customer retrieveCustomerById(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		return customer;
	}

	@PostMapping("/customers")
	public Customer insertCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PutMapping("/customers/{id}")
	public Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		customer = new Customer(id, newCustomer.getFirstName(), newCustomer.getLastName());
		return customerRepository.save(customer);

	}

	@PatchMapping("/customers/{id}")
	public Customer modifyCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@DeleteMapping("/customers/{id}")
	void deleteCustomer(@PathVariable Long id) {
		customerRepository.deleteById(id);
	}
}