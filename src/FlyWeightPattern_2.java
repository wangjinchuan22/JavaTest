import java.util.*;

public class FlyWeightPattern_2 {
    public static void main(String[] args){
        ShapeFactory factory = new ShapeFactory();
        Random random = new Random();
        String[] colors = {"red","blue","green","white","black"};
        for (int i = 1; i <= 100; i++){
            int x = random.nextInt(colors.length); // {0 - 4}
            Shape shape = factory.getShape(colors[x]);
            System.out.println("第"+i+"个圆");
            shape.draw(random.nextInt(2022),random.nextInt(528));
        }

    }
}


class ShapeFactory{
    private Map<String,Shape> map = new  HashMap<String,Shape>();
    public Shape getShape(String key){
        //if (map.containsKey(key)){
        //    return map.get(key);
        //}else{
        //    Shape shape = new Circle(key);
        //    map.put(key,shape);
        //    //return shape;
        //    return map.get(key);
        //}
        if (!map.containsKey(key)){          //不存在的情况，再去创建
            map.put(key,new Circle(key));
            System.out.println("creat color:"+key+"circle");
        }
        return map.get(key);
    }
}

abstract class Shape{
    protected String color;

    public abstract void draw(int x,int y);
}

class Circle extends Shape{
    public Circle(String color){
        this.color = color;
    }

    @Override
    public void draw(int x,int y){
        System.out.println("draw a color "+ color + "circle x:"+x+"y:"+y );

    }
}