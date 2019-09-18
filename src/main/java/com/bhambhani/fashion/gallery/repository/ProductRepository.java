package com.bhambhani.fashion.gallery.repository;

import com.bhambhani.fashion.gallery.mapper.ProductRowMapper;
import com.bhambhani.fashion.gallery.model.Product;
import com.bhambhani.fashion.gallery.model.SearchProduct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * @Author Suraj Bhambhani Repository class for crud operations of Product. TODO More Appropriate
 * Exception handling
 */
@Repository
public class ProductRepository implements IProductRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;


  @Override
  public List<Product> findAll() {
    return jdbcTemplate.query("select * from product", new ProductRowMapper());
  }

  @Override
  public int deleteById(long id) {
    return jdbcTemplate.update("delete from product where product_id=?", new Object[]{
        id
    });
  }

  @Override
  public int insert(Product product) {
    return jdbcTemplate
        .update("insert into product (title, brand, price, description, color) "
                + "values(?, ?, ?, ?, ?)",
            new Object[]{
                product.getTitle(), product.getBrand(), product.getPrice(),
                product.getDescription(), product.getColor()
            });
  }

  @Override
  public int update(Product product) {
    return jdbcTemplate
        .update(
            "update product " + " set title = ?, brand = ?, price = ?, description = ?, color = ? "
                + " where product_id = ?",
            new Object[]{
                product.getTitle(), product.getBrand(), product.getPrice(),
                product.getDescription(), product.getColor(), product.getProductId()
            });
  }

  /**
   * Find by id.
   */
  @Override
  public Product findById(long id) {
    try {
      return jdbcTemplate
          .queryForObject("select * from product where product_id = ?", new Object[]{id},
              new ProductRowMapper());
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  public List<Product> findByOffSet(int start, int end) {
    return jdbcTemplate
        .query("select * from product order by product_id offset ? rows fetch next ? rows only",
            new Object[]{start, end},
            new ProductRowMapper());
  }

  @Override
  public List<Product> findProductByCriteria(SearchProduct searchProduct) {

    try {

      StringBuilder query = new StringBuilder("select * from product ");

      // Criteria
      if (!searchProduct.getSearchBy().isEmpty()) {
        query.append(" where ").append(searchProduct.getSearchBy());
      }

      // Sorting
      if (!searchProduct.getSortBy().isEmpty()) {
        query.append(" order by ").append(searchProduct.getSortBy());
      }

      // Getting Paginated values
      if (!(searchProduct.getPaginationStart() == 0 || searchProduct.getPaginationEnd() == 0)) {
        int endValue = searchProduct.getPaginationEnd() - searchProduct.getPaginationStart();
        query.append(" offset ").append(searchProduct.getPaginationStart()).append(" rows ");
        query.append(" fetch next ").append(endValue).append(" rows only ");
      }

      return jdbcTemplate.query(query.toString(), new ProductRowMapper());

    } catch (Exception e) {
      // throw User Based Exception
      return null;
    }
  }

}
