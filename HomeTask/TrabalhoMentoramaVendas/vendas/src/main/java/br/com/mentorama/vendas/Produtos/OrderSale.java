package br.com.mentorama.vendas.Produtos;

public class OrderSale {

    private static Product product;
    private static Integer quantityOrder;
    private static Double discount;

    public OrderSale(Product product, Integer quantityOrder, Double discount) {
        this.product = product;
        this.quantityOrder = quantityOrder;
        this.discount = discount;
    }

    public static double getQuantityTotalOrder(){
        return product.getQuantityOfProductFromSale(quantityOrder);
    }

//    public static double getTotalPriceSale(){
//        return product.getPriceWithDiscount(discount) * getQuantityTotalOrder();
//    }

  public static double getTotalPriceSale(){
        return product.getPriceWithDiscount(discount) * quantityOrder;
    }


    public static double getTotalPriceSale(Product product) {
        return 0;
    }
}
