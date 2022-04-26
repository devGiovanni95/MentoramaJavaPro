package br.com.mentorama.vendas.model;

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
