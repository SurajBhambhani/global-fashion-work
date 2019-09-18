package com.bhambhani.fashion.gallery.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

  private Long productId;
  private String title;
  private String brand;
  private BigDecimal price;
  private String description;
  private String color;

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product that = (Product) o;
    return Objects.equals(productId, that.productId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId);
  }

  @Override
  public String toString() {
    return "Product{" +
        "productId=" + productId +
        ", title='" + title + '\'' +
        ", brand='" + brand + '\'' +
        ", price=" + price +
        ", description='" + description + '\'' +
        ", color='" + color + '\'' +
        '}';
  }
}
