package com.bhambhani.fashion.gallery.controller;

import com.bhambhani.fashion.gallery.bz.IProductService;
import com.bhambhani.fashion.gallery.model.Product;
import com.bhambhani.fashion.gallery.model.SearchProduct;
import java.util.List;
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
@RequestMapping("/v2")
public class ProductControllerV2 {

  @Autowired
  IProductService productService;

  /**
   * Get method for listing all products by pagination
   *
   * @return ResponseEntity<List < Product>>
   */
  @RequestMapping(value = "/product/{start}/{end}", method = RequestMethod.GET)
  public ResponseEntity<List<Product>> listAllProducts(@PathVariable("start") int start,
      @PathVariable("end") int end) {

    if (start > end) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    int endValue = end - start;
    //Send start and end value
    List<Product> products = productService.getSetOfProducts(start, endValue);
    if (products.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(products, HttpStatus.OK);
  }


  /**
   * Get method for searching and sorting
   *
   *    URL :- http://localhost:8080/v2/product/
   *   Request Example
   *    {
   *       "paginationStart":1,
   *       "paginationEnd":10,
   *       "sortBy":"product_Id,price",
   *       "searchBy":"title = 'Jeans' and brand='YRA'"
   *
   *    }
   *
   * @return ResponseEntity<List<Product>>
   */
  @RequestMapping(value = "/product/", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Product>> listAllProductsByCrieteria(@RequestBody SearchProduct searchProduct) {

    List<Product> products = productService.getSetOfProducts(searchProduct);
    if (products.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(products, HttpStatus.OK);
  }


}
