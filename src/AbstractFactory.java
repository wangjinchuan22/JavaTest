/*
 * 抽象工厂方法
 */

public class AbstractFactory {
    public static void main(String[] args){
        AbFactory abfactory1 = new AbFactory1();
        AbstractProductA abproductA1 = abfactory1.createProductA();
        abproductA1.info();

        AbstractProductB abproductB1 = abfactory1.createProductB();
        abproductB1.info();

        AbFactory abfactory2 = new AbFactory2();
        AbstractProductA abproductA2 = abfactory2.createProductA();
        abproductA2.info();

        AbstractProductB abproductB2 = abfactory2.createProductB();
        abproductB2.info();
    }
}

interface AbFactory{
    public AbstractProductA createProductA();
    public AbstractProductB createProductB();
}

class AbFactory1 implements AbFactory{
    @Override
    public AbstractProductA createProductA() {
        return new AbProductA1();
    }
    @Override
    public AbstractProductB createProductB(){
        return new AbProductB1();
    }
}

class AbFactory2 implements AbFactory{
    @Override
    public AbstractProductA createProductA() {
        return new AbProductA2();
    }
    @Override
    public AbstractProductB createProductB(){
        return new AbProductB2();
    }
}




interface AbstractProductA{
    public void info();
}

class AbProductA1 implements AbstractProductA{
    @Override
    public void info(){
        System.out.println("产品信息：A1");
    }
}

class AbProductA2 implements AbstractProductA{
    @Override
    public void info(){
        System.out.println("产品信息：A2");
    }
}

interface AbstractProductB{
    public void info();
}

class AbProductB1 implements AbstractProductB{
    @Override
    public void info(){
        System.out.println("产品信息：B1");
    }
}

class AbProductB2 implements AbstractProductB{
    @Override
    public void info(){
        System.out.println("产品信息：B2");
    }
}