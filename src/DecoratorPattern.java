public class DecoratorPattern {
    public static void main(String[] args){
        Person zhangsan = new Student("张三");
        zhangsan.Operation();


        System.out.println("使用装饰器之后");
        //父类名 对象名 = new 子类名
        //Decorator decoratorA = new DecortorA(zhangsan);
        //Person decoratorA = new DecortorA(zhangsan);

        zhangsan = new DecortorA(zhangsan);
        zhangsan = new DecortorB(zhangsan);
        zhangsan.Operation();

        //对象链
        Person lisi = new DecortorB(new DecortorA(new Student("李四")));
        lisi.Operation();
    }
}


abstract class Person{
    protected String name;

    public abstract void Operation();
}

class Student extends Person{
    public Student(String name){
        this.name = name;
    }

    @Override
    public void Operation(){
        System.out.println(name + "的职责：学习");
    }
}


abstract class Decorator extends Person{
    protected Person person;
}

class DecortorA extends Decorator{
    public DecortorA(Person person){
        this.person = person;
    }
    @Override
    public void Operation(){
        person.Operation();   //执行原本的职责
        System.out.println("写作业");
    }
}

class DecortorB extends Decorator{
    public DecortorB(Person person){
        this.person = person;
    }
    @Override
    public void Operation(){
        person.Operation();   //执行原本的职责
        System.out.println("考试");
    }
}