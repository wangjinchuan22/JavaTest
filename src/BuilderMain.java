import java.util.*;

public class BuilderMain {
    public static void main(String[] args){
        Director director = new Director();

        Builder builder1 = new Builder1();
        director.Construct(builder1);
        ProductT productT1 = builder1.getResult();
        productT1.show();

        Builder builder2 = new Builder2();
        director.Construct(builder2);
        ProductT productT2 = builder2.getResult();
        productT2.show();
    }
}


class Director{
    public void Construct(Builder builder){
        builder.BuilderPart();

    }
}


abstract class Builder{
    public abstract void BuilderPart();
    public abstract  ProductT getResult();
}

class Builder1 extends Builder{
    ProductT productT = new ProductT();

    @Override
    public void BuilderPart(){
        productT.Add("A1");
        productT.Add("B1");
        productT.Add("C1");
    }

    @Override
    public ProductT getResult(){
        return productT;
    }
}


class Builder2 extends Builder{
    ProductT productT = new ProductT();

    @Override
    public  void BuilderPart(){
        productT.Add("A2");
        productT.Add("B2");
        productT.Add("C2");
    }

    @Override
    public ProductT getResult(){
        return productT;
    }
}




class ProductT{
    List<String> parts = new ArrayList<String>();

    public void Add(String part){
        parts.add(part);
    }
    public void show(){
        System.out.println("产品的组成：");
        for (String s : parts)
            System.out.println(s + " ");
        System.out.println("\n");
    }
}

