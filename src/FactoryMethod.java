/*
 *工厂方法模式
 */

public class FactoryMethod {
    public static void main(String[] args){
        Factory2 factoryA = new FactoryA();
        /* 编译看左边，运行看右边*/
        Product2 productA2 = factoryA.createProduct();
        productA2.info2();

        Factory2 factoryB = new FactoryB();
        Product2 productB2 = factoryB.createProduct();
        productB2.info2();

    }
}

interface Factory2{
    public  Product2 createProduct();
}

class FactoryA implements Factory2{
    @Override
    public Product2  createProduct(){
        return new ProductA2();
    }
}

class FactoryB implements Factory2{
    @Override
    public Product2  createProduct(){
        return new ProductB2();
    }
}



interface Product2{
    public void info2();
}

class ProductA2 implements Product2{
    @Override
    public void info2(){
        System.out.println("产品的信息：A");
    }
}

class ProductB2 implements Product2{
    @Override
    public void info2(){
        System.out.println("产品的信息：B");
    }
}