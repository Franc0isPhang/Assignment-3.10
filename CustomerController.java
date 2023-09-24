package sg.ntu.edu.demo;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")

//if i use requestmapping, i can take away all the customer in the request mapping
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(Customer.class);

  private ArrayList<Customer> customers = new ArrayList<>();

  public CustomerController() {
    customers.add(new Customer("apple", 2,"its a fruit"));
    customers.add(new Customer( "hair dryer",100, "its v nice"));
    customers.add(new Customer("cup",5, "v good to hold water"));


  }

@PostMapping("")
public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    customers.add(customer);
    logger.info("🟢 customer added");
    return new ResponseEntity<>(customer, HttpStatus.CREATED);

    // Alternate syntax
    // return ResponseEntity.status(HttpStatus.CREATED).body(customer);
}
    
//get all
    @GetMapping("")
public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
    return new ResponseEntity<>(customers, HttpStatus.CREATED);
    // return customers;
    //u would get an empty array
}

}