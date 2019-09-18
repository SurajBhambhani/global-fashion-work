package com.bhambhani.fashion.gallery.controller;

import com.bhambhani.fashion.gallery.bz.IProductService;
import com.bhambhani.fashion.gallery.model.Product;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ProductControllerV1 {

  Logger LOGGER = LoggerFactory.getLogger(ProductControllerV1.class);

  @Autowired
  IProductService productService;

  /**
   * Get method for listing all products.
   *
   * URL:- http://localhost:8080/v1/product/
   *
   * @return ResponseEntity<List < Product>>
   */
  @RequestMapping(value = "/product/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Product>> listAllProducts() {
    List<Product> products = productService.getAllProducts();
    if (products.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  /**
   * Get method for getting a product by an id.
   *
   * URL:- http://localhost:8080/v1/product/1
   *
   * @return ResponseEntity<List < Product>>
   */
  @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> getUser(@PathVariable("id") long id) {
    LOGGER.debug("Fetching Product with id ", id);
    Product product = productService.findById(id);
    if (product == null) {
      LOGGER.debug("Product with id ", id, " not found");
      return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Product>(product, HttpStatus.OK);
  }

  /**
   * Method for creating products
   *
   * URL:- http://localhost:8080/v1/product/
   *
   * Request
   *
   * [ { "title":"SOCKS", "brand":"H&M", "price":10.99, "description":"Ghost Price", "color":"Black"
   * }, { "title":"SOS", "brand":"YRA", "price":15.99, "description":"Ghost Price", "color":"Black"
   * } ]
   */
  @RequestMapping(value = "/product/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> createProduct(@RequestBody List<Product> products) {
    LOGGER.debug("Creating Products " + products.toString());

    //TODO Validate if product exists
    productService.saveProducts(products);
    return new ResponseEntity<>("Products Created Successfully.", HttpStatus.CREATED);
  }

  /**
   * Method for creating product
   *
   * URL :- http://localhost:8080/v1/product/
   *
   * Request
   *
   * { "productId":9, "title":"SOCKS", "brand":"H&M", "price":10.99, "description":"MOST Price",
   * "color":"Black" }
   */
  @RequestMapping(value = "/product/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> updateProduct(@RequestBody Product product) {
    LOGGER.debug("Creating Products " + product.toString());

    Product currentProduct = productService.findById(product.getProductId());

    if (currentProduct == null) {
      LOGGER.debug("Product with id " + product.getProductId() + " not found");
      return new ResponseEntity<>("Product does't exists", HttpStatus.NOT_FOUND);
    }

    //TODO Validation if required.
    productService.updateProduct(product);
    return new ResponseEntity<>("Products Updated Successfully.", HttpStatus.OK);
  }

  /**
   * Method for deleting product.
   *
   * URL :- http://localhost:8080/v1/product/1
   */
  @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {

    Product product = productService.findById(id);
    if (product == null) {
      System.out.println("Unable to delete. Product with id " + id + " not found");
      return new ResponseEntity<>("Unable to delete. Product with id " + id + " not found",
          HttpStatus.NOT_FOUND);
    }

    productService.deleteUserById(id);
    return new ResponseEntity<>("Product Deleted Successfully.", HttpStatus.OK);
  }

}
