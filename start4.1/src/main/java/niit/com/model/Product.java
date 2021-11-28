package niit.com.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document
public class Product implements Serializable {
    @Id
    int productCode;
    String productName;
    ProductDescription productDescription;

    public Product()
    {

    }

    public Product(int productCode, String productName, ProductDescription productDescription) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public Product(String productName, ProductDescription productDescription) {
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }
}
