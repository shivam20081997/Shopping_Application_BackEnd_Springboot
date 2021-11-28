package niit.com.repository;

import niit.com.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,Integer>{
        @Query("{'productdescription.stock':{$in : [?0]}}")
        List<Product> findProductsInStock();
    }


