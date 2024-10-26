import javax.swing.*;

public class PrototypeMain {
    public static void main(String[] args){
        ProductP productP1 = new ProductP(2022,5.28);
        System.out.println(productP1.getId() + " " + productP1.getprice());

        ProductP productP2 = (ProductP) productP1.Clone();
        System.out.println(productP2.getId()+ " "+ productP2.getprice());
    }
}

interface Prototype{
    public Object  Clone();
}

class  ProductP implements Prototype{
    private int id;
    private double price;

    public ProductP(){}

    public ProductP(int id ,double price){
        this.id = id;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public double getprice(){
        return price;
    }
    @Override
    public Object Clone(){
        ProductP object = new ProductP();
        object.id = this.id;
        object.price = this.price;
        return object;
    }

}