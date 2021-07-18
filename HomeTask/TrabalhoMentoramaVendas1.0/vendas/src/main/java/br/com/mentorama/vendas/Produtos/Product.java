package br.com.mentorama.vendas.Produtos;

public class Product {

    private Integer id;
    private String productName;
    private Integer quantityInStock;
    private Double price;
    private Double discountMaxPercentage;

    public Product(Integer id, String productName, Integer quantityInStock, Double price, Double discountMaxPercentage) {
        this.id = id;
        this.productName = productName;
        this.quantityInStock = quantityInStock;
        this.price = price;
        this.discountMaxPercentage = discountMaxPercentage;
    }


    /*preço com desconto*/
    public Double getPriceWithDiscount(final Double discount){
        if (discount > discountMaxPercentage){
            return price * (1 - discountMaxPercentage);
        }else {
            return price * (1 - discount);
        }
    }
/*quantidade em estoque*/
    public Integer getQuantityOfProductFromSale(final Integer quantitySale){
        if (quantitySale > quantityInStock){
            System.out.println("Ordered quantity unavailable. Available quantity " + quantityInStock);
            return quantityInStock;
        }else {
            return quantitySale;
        }
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", price=" + price +
                ", discountMaxPercentage=" + discountMaxPercentage +
                '}';
    }
}
