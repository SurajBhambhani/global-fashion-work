package com.bhambhani.fashion.gallery.repository;

import com.bhambhani.fashion.gallery.model.Product;
import com.bhambhani.fashion.gallery.model.SearchProduct;
import java.util.List;

/**
 * @Author Suraj Bhambhani Repository interface for crud operations of Product.
 */
public interface IProductRepository {

  /**
   * Method which helps in finding all the values of Product.
   *
   * @return List<Product>
   */
  List<Product> findAll();

  /**
   * Method which helps in deleting a Product by its product_id.
   */
  int deleteById(long id);

  /**
   * Method which helps in creating a Product.
   */
  int insert(Product product);

  /**
   * Method which helps in updating a Product details.
   */
  int update(Product product);

  Product findById(long id);

  List<Product> findByOffSet(int start, int end);

  List<Product> findProductByCriteria(SearchProduct searchProduct);
}
