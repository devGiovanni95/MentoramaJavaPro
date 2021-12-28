package br.com.mentorama.vendas.model;

public class SaleTotal {

    public static double saleTotalPriceProduct(Product product, Double discount, Integer quantity) {
        Double productSale1 = product.getPriceWithDiscount(discount) ;
        Integer productSale2 =  product.getQuantityOfProductFromSale(quantity);
        Double result = productSale1 * productSale2;

        return result;
    }


    public static Double saleTotalPrice(Double productOne, Double ProductTwo, Double productTree){
       Double resutFinal = productOne + ProductTwo + productTree;
       return resutFinal;
    }


}
