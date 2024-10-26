public class BridgePattern {
    public static void main(String[] args){
        ProductBP productBP1 = new ProductBP1();
        Color red = new Red();

        productBP1.setName("小米su7");
        productBP1.setColor(red);
        productBP1.Operation();


        ProductBP productBP2 = new ProductBP1();
        Color blue = new Blue();

        productBP2.setName("小米15");
        productBP2.setColor(blue);
        productBP2.Operation();
    }
}

abstract class ProductBP{
    private String name;
    protected  Color color;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void Operation();
}


class ProductBP1 extends ProductBP{
    @Override
    public void Operation(){
        color.OperationImp(this.getName());
    }
}






interface Color{
    public void OperationImp(String name);

}


class Red implements Color{
    @Override
    public void OperationImp(String name){
        System.out.println(name+":红色");
    }
}

class Blue implements Color{
    @Override
    public void OperationImp(String name){
        System.out.println(name+":蓝色");
    }
}
