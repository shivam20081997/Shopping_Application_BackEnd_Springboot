package niit.com.service;

import niit.com.exception.ProductAlreayExistsException;
import niit.com.exception.ProductNotFoundException;
import niit.com.model.Product;
import niit.com.model.ProductDescription;

import java.util.List;

public interface ProductService {
    public Product saveProductDetails(Product details) throws ProductAlreayExistsException;
    public boolean deleteProductDetails(int productCode) throws ProductNotFoundException;
    public Product getById(int productCode);
    public Product updatePrice(Product product);
    public List<Product> getAllProduct();

}
