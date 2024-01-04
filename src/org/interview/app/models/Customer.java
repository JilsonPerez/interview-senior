package org.interview.app.models;

public class Customer {
  private int id;
  private int basicCustomerDiscount;
  private int firstBulkDiscount;
  private int secondBulkDiscount;

  public Customer(int id, int basicCustomerDiscount, int firstBulkDiscount, int secondBulkDiscount) {
    this.id = id;
    this.basicCustomerDiscount = basicCustomerDiscount;
    this.firstBulkDiscount = firstBulkDiscount;
    this.secondBulkDiscount = secondBulkDiscount;
  }

  public int getId() {
    return id;
  }

  public int getFirstBulkDiscount() {
    return firstBulkDiscount;
  }

  public int getSecondBulkDiscount() {
    return secondBulkDiscount;
  }

  public Double getAdditionalBulkDiscountTotal(Double total) {
    return total - (total * (getAbove(total)/100D));
  }

  public int getAbove(Double total) {
    if (total > 30000) {
      return getSecondBulkDiscount();
    } else if (total > 10000) {
      return getFirstBulkDiscount();
    } else {
      return 0;
    }
  }

  public double getTotal(Double total) {
    double basicDiscount = total - total * (this.basicCustomerDiscount/100D);
    return getAdditionalBulkDiscountTotal(basicDiscount);
  }

  @Override
  public String toString() {
    return "Customer ID: " + id +
      "\nBasic Customer Discount: " + basicCustomerDiscount + "%" +
      "\nAbove EUR 10000: " + firstBulkDiscount + "%" +
      "\nAbove EUR 30000: " + secondBulkDiscount + "%";
  }
}
