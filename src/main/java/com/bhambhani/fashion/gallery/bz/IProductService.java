package com.bhambhani.fashion.gallery.bz;

import com.bhambhani.fashion.gallery.model.Product;
import com.bhambhani.fashion.gallery.model.SearchProduct;
import java.util.List;

public interface IProductService {

  List<Product> getAllProducts();

  List<Product> getSetOfProducts(int start, int end);

  List<Product> getSetOfProducts(SearchProduct searchProduct);

  Product findById(long id);

  void saveProducts(List<Product> products);

  int updateProduct(Product product);

  void deleteUserById(long id);
}
