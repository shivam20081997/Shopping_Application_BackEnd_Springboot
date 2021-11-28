package niit.com.service;

import niit.com.exception.ProductAlreayExistsException;
import niit.com.exception.ProductNotFoundException;
import niit.com.model.Product;
import niit.com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PropertyPermission;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProductDetails(Product details) throws ProductAlreayExistsException {
        if(productRepository.findById(details.getProductCode()).isPresent()){
            throw new ProductAlreayExistsException();
        }
        return productRepository.save(details);
    }

    @Override
    public boolean deleteProductDetails(int productCode) throws ProductNotFoundException {
        boolean result = false;
        if (productRepository.findById(productCode).isEmpty()) {
            throw new ProductNotFoundException();
        } else {
            productRepository.deleteById(productCode);
            result = true;
        }
        return result;
    }

    @Override
    public Product getById(int productCode) {

        Product pro=null;
        Product product = new Product();
        if (productCode == product.getProductCode()) {
            pro = product;
        }
        return pro;
    }
    @Override
    public Product updatePrice(Product product) {
        Product product2=productRepository.save(product);
        return  product2;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
