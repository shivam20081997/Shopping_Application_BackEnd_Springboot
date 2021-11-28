package niit.com.model;

public class ProductDescription {
    int stock;
    int price;
    String productType;

    public ProductDescription()
    {

    }

    public ProductDescription(int stock, int price, String productType) {
        this.stock = stock;
        this.price = price;
        this.productType = productType;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
