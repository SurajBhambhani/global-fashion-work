package com.bhambhani.fashion.gallery.mapper;

import com.bhambhani.fashion.gallery.model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper implements RowMapper<Product> {

  @Override
  public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
    Product product = new Product();
    product.setProductId(rs.getLong("product_id"));
    product.setTitle(rs.getString("title"));
    product.setBrand(rs.getString("brand"));
    product.setDescription(rs.getString("description"));
    product.setColor(rs.getString("color"));
    product.setPrice(rs.getBigDecimal("price"));

    return product;
  }
}
