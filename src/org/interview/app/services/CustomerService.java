package org.interview.app.services;

import org.interview.app.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
  private List<Customer> customers;

  public CustomerService() {
    setDataSource();
  }
  private void setDataSource() {
    customers = new ArrayList<>();
    customers.add(new Customer(1, 5, 0, 2));
    customers.add(new Customer(2, 4, 1, 2));
    customers.add(new Customer(3, 3, 1, 3));
    customers.add(new Customer(4, 2, 3, 5));
    customers.add(new Customer(5, 0, 5, 7));
  }

  public Customer getCustomer(int customerId) {
    return this.customers.stream()
      .filter(c -> c.getId() == customerId)
      .findFirst()
      .orElseThrow(() -> new IllegalStateException("Customer not found"));
  }
}
