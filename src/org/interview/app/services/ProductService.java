package org.interview.app.services;

import org.interview.app.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
  private List<Product> products;

  public ProductService() {
    setDataSource();
  }

  private void setDataSource() {
    products = new ArrayList<>();
    products.add(new Product("A", 0.52, 80.0, "%", 0));
    products.add(new Product("B", 0.38, 120.0, "%", 30));
    products.add(new Product("C", 0.41, 0.9, "eur", 0));
    products.add(new Product("D", 0.60, 1.0, "eur", 20));
  }

  public Product getProductByName(String name) {
    return products.stream()
      .filter(p -> p.getName().equals(name))
      .findFirst()
      .orElse(null);
  }
}
