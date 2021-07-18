package br.com.mentorama.vendas.Produtos;

public class OrderSale {

    private Product product;
    private Integer quantityOrder;
    private Double discount;

    public OrderSale(Product product, Integer quantityOrder, Double discount) {
        this.product = product;
        this.quantityOrder = quantityOrder;
        this.discount = discount;
    }

    public double getQuantityTotalOrder(){
        return product.getQuantityOfProductFromSale(quantityOrder);
    }

    public double getTotalPriceSale(){
        return product.getPriceWithDiscount(discount) * getQuantityTotalOrder();
    }


}
