/*
 * 简单工厂模式2024
 */

public class simpleFactory {
    public static  void main(String[] args){
        Product productA = Factory.creatproduct("A");
        productA.info();
        Product productB = Factory.creatproduct("B");
        productB.info();
    }
}

class Factory{

    public static Product creatproduct(String type){
        Product product = null;
        switch (type){
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
                break;
            default:
                System.out.println("没有"+type+"类型的产品");
                break;
        }
        return product;
    }
}

abstract class Product {
    public abstract void info();
}

class ProductA extends Product{

    @Override
    public void info(){
        System.out.println("产品信息：A");
    }
}

class ProductB extends Product{

    @Override
    public void info(){
        System.out.println("产品信息：B");

    }}