package mdalcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping(path = "api/v1/student")
public class CustomerController {
	
	private final CustomerService customerservice;
	
	@Autowired
	public CustomerController(CustomerService customerservice) {
		this.customerservice = customerservice;
	}
	
	/*@GetMapping
	public List<Customer> getCustomers()
	{
		return customerservice.getCustomers();
	}*/
    @GetMapping("/register")
    public ModelAndView showRegistrationForm() {
        return new ModelAndView("register");
    }
	@PostMapping("/register")
	public void registerNewCustomer(@RequestBody Customer customer) {
		
		customerservice.addNewCustomer(customer);
	}
	@DeleteMapping(path = "{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Long id) {
		customerservice.deleteCustomer(id);
	}
	@PutMapping(path = "{customerId}")
	public void updateCustomer(
			@PathVariable("customerId") Long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		customerservice.updateCustomer(id, name, email);
	}
}
