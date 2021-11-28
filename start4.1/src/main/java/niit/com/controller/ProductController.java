package niit.com.controller;

import niit.com.exception.ProductAlreayExistsException;
import niit.com.exception.ProductNotFoundException;
import niit.com.model.Product;
import niit.com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2/productservice/")
public class ProductController  {
    @Autowired
    private ProductService productService;
    private ResponseEntity responseEntity;

    @PostMapping("/add")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) throws ProductAlreayExistsException {
        try{
            productService.saveProductDetails(product);
            responseEntity = new ResponseEntity(product, HttpStatus.CREATED);
        }
        catch (ProductAlreayExistsException e){
            throw new ProductAlreayExistsException();
        }
        catch (Exception ex){
            responseEntity=new ResponseEntity("error while adding product data",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/delete-product/{productCode}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productCode") int productCode) throws ProductNotFoundException {
        try{
            productService.deleteProductDetails(productCode);
            responseEntity=new ResponseEntity("Product deleted successfully",HttpStatus.OK);
        }
        catch (ProductNotFoundException e){
            throw new ProductNotFoundException();
        }
        catch (Exception ex){
            responseEntity=new ResponseEntity("error while deleting product data",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        try {
            responseEntity=new ResponseEntity(productService.getAllProduct(),HttpStatus.OK);
        }
        catch (Exception ex){
            responseEntity=new ResponseEntity("error while fetching product data",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/get-by-id/{productCode}")
    public Product getByID(@PathVariable("productCode") int productCode)
    {
        Product product=productService.getById(productCode);
        return  product;
    }

    @PostMapping("/update-product")
    public ResponseEntity<String> updateMovie(@RequestBody Product product)
    {
        Product product2=productService.updatePrice(product);
        if(product!=null)
        {
            return new ResponseEntity<>("Product Updated Succesfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Updating Product was not successful",HttpStatus.EXPECTATION_FAILED);
        }
    }

}




