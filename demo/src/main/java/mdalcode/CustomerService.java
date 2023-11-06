package mdalcode;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	public List<Customer> getStudents() 
	{
		
		return customerRepository.findAll();
	}
	public void addNewCustomer(Customer customer) {
		Optional<Customer> customerOptional = customerRepository.
				findCustomerByEmail(customer.getEmail());
		if(customerOptional.isPresent()) 
		{
			throw new IllegalStateException("This email was taken");
		}
		customerRepository.save(customer);
	}
	public void deleteCustomer(Long customerid) 
	{
		if(!customerRepository.existsById(customerid)) {
			throw new IllegalStateException("A customer with this id:" + customerid + "doesn't exists");
		}else {
		customerRepository.deleteById(customerid);
		}
	}
	@Transactional
	public void updateCustomer(Long id, String name, String email) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(()-> new IllegalStateException("A customer with this id:" + id + "doesn't exist"));
		if(name != null && name.length() >0 
				&& !Objects.equals(customer.getEmail(), name)) {
			customer.setName(name);
		}
		if(email != null && email.length() >0 
				&& !Objects.equals(customer.getEmail(), email)) {
			Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
			if(customerOptional.isPresent()) {
				throw new IllegalStateException("This email has been registered");
			}
			customer.setEmail(email);
		}
	}
}
