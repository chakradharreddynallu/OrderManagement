//    package com.orderManagement.demo.service;
//
//    import com.orderManagement.demo.model.Customer;
//    import com.orderManagement.demo.repository.CustomerRepository;
//    import org.springframework.beans.factory.annotation.Autowired;
//    import org.springframework.stereotype.Service;
//
//    @Service
//    public class CustomerService {
//        @Autowired
//        private CustomerRepository customerRepo;
//
//        public Customer createCustomer(Customer customer) {
//            return customerRepo.save(customer);
//        }
//
//        public Customer getCustomer(Long id) {
//            return customerRepo.findById(id).orElseThrow();
//        }
//    }

package com.orderManagement.demo.service;

import com.orderManagement.demo.dto.CustomerDTO;
import com.orderManagement.demo.model.Customer;
import com.orderManagement.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());

        Customer savedCustomer = customerRepo.save(customer);

        return new CustomerDTO(savedCustomer.getId(), savedCustomer.getName(), savedCustomer.getEmail());
    }

    public CustomerDTO getCustomer(Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow();
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail());
    }
}
