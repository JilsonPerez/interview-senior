package org.interview.app.models;

public class Product {
  private String name;
  private Double unitCost;
  private Double markup;
  private String markupType;
  private int promotion;

  public Product(String name, Double unitCost, Double markup, String markupType, int promotion) {
    this.name = name;
    this.unitCost = unitCost;
    this.markup = markup;
    this.markupType = markupType;
    this.promotion = promotion;
  }

  public String getName() {
    return name;
  }

  private Double getProductCost() {
    double unitPrice;
    if (this.markupType.equals("%")) {
      unitPrice = this.unitCost + (this.unitCost * (this.markup/100D));
    } else {
      unitPrice = this.unitCost + this.markup;
    }
    return unitPrice;
  }
  public Double getProductCostWithPromotion(int quantity) {
    double unitPrice = quantity * this.getProductCost();
    return unitPrice - unitPrice * (this.promotion/100D);
  }

  public String showDetails(int quantity) {
    return "Product: " + name + ", Quantity: " + quantity + ", Base Unit Price: " + unitCost +
      ", Line Total: " + String.format("%.2f", getProductCostWithPromotion(quantity)) + " (EUR)";
  }
}
