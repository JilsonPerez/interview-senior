import org.interview.app.models.Customer;
import org.interview.app.models.Product;
import org.interview.app.services.CustomerService;
import org.interview.app.services.ProductService;

import java.util.*;

public class InterviewApplication {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Add datasource
    ProductService productService = new ProductService();
    CustomerService customerService = new CustomerService();
    // Get each product
    Product productA = productService.getProductByName("A");
    Product productB = productService.getProductByName("B");
    Product productC = productService.getProductByName("C");
    Product productD = productService.getProductByName("D");

    // Get data from console
    int customerId = 0;
    do {
      System.out.print("Enter the customer id (between 1 and 5): ");
      customerId = sc.nextInt();
    } while (customerId > 5 || customerId < 1);

    Customer customer = customerService.getCustomer(customerId);

    System.out.print("Enter the quantity for product A: ");
    int quantityProductA = sc.nextInt();
    System.out.print("Enter the quantity for product B: ");
    int quantityProductB = sc.nextInt();
    System.out.print("Enter the quantity for product C: ");
    int quantityProductC = sc.nextInt();
    System.out.print("Enter the quantity for product D: ");
    int quantityProductD = sc.nextInt();

    double totalBeforeDiscount = productA.getProductCostWithPromotion(quantityProductA) +
      productB.getProductCostWithPromotion(quantityProductB) +
      productC.getProductCostWithPromotion(quantityProductC) +
      productD.getProductCostWithPromotion(quantityProductD);

    double totalAfterDiscount = customer.getTotal(totalBeforeDiscount);

    // Display order
    System.out.println("\n" + customer);
    System.out.println("\nOrder Summary:");
    System.out.println("\t" + productA.showDetails(quantityProductA));
    System.out.println("\t" + productB.showDetails(quantityProductB));
    System.out.println("\t" + productC.showDetails(quantityProductC));
    System.out.println("\t" + productD.showDetails(quantityProductD));
    System.out.println("\n\tTotal Amount (before discounts): " + formatResult(totalBeforeDiscount) + " (EUR)");
    System.out.println("\tTotal Amount (after discounts): " + formatResult(totalAfterDiscount) + " (EUR)");
  }

  public static String formatResult(double value) {
    return String.format("%.2f", value);
  }
}
