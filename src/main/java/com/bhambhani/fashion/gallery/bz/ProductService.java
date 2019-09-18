package com.bhambhani.fashion.gallery.bz;

import com.bhambhani.fashion.gallery.model.Product;
import com.bhambhani.fashion.gallery.model.SearchProduct;
import com.bhambhani.fashion.gallery.repository.IProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

  @Autowired
  IProductRepository iProductRepository;

  @Override
  public List<Product> getAllProducts() {
    return iProductRepository.findAll();
  }

  @Override
  public List<Product> getSetOfProducts(int start, int end) {
    return iProductRepository.findByOffSet(start, end);
  }

  @Override
  public List<Product> getSetOfProducts(SearchProduct searchProduct) {
    return iProductRepository.findProductByCriteria(searchProduct);
  }

  @Override
  public Product findById(long id) {
    return iProductRepository.findById(id);
  }

  @Override
  public void saveProducts(List<Product> products) {
    products.forEach(product ->
        iProductRepository.insert(product));
  }

  @Override
  public int updateProduct(Product product) {
    return iProductRepository.update(product);
  }

  @Override
  public void deleteUserById(long id) {
    iProductRepository.deleteById(id);
  }


}
