import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.*;

public class VisitorPattern {
    public static void main(String[] args){
        PersonStructure structure = new PersonStructure();


        Visitor1 visitor1 = new Visitor1();
        System.out.println("访问者1的访问记录");
        structure.Accept(visitor1);
        System.out.println("学生的年龄总和："+visitor1.getStudentAgeSum());
        System.out.println("老师的年龄总和："+visitor1.getTeacheAgeSum());
        System.out.println("=====================");
        Visitor2 visitor2 = new Visitor2();
        System.out.println("访问者2的访问记录");
        structure.Accept(visitor2);
        System.out.println("学生的最大分数："+visitor2.getMaxScore());
        System.out.println("老师的最大工龄"+visitor2.getMaxworkyear());
    }
}


interface Visitor{

    public void visitstudent(Student2 student2);  //访问学生
    public void visitteacher(Teacher2 teacher2);  //访问老师
}


class Visitor1 implements Visitor{  //分别统计学生老师的年龄总和
    private int StudentAgeSum = 0;
    private int TeacheAgeSum = 0;

    public int getStudentAgeSum(){
        return StudentAgeSum;
    }

    public int getTeacheAgeSum(){
        return TeacheAgeSum;
    }
    @Override
    public void visitstudent(Student2 student2){
        System.out.println("访问者2访问学生："+student2.getName()+"年龄"+student2.getAge());
        StudentAgeSum += student2.getAge();
    }

    @Override
    public void visitteacher(Teacher2 teacher2){
        System.out.println("访问者2访问老师："+teacher2.getName()+"年龄"+ teacher2.getAge());
        TeacheAgeSum += teacher2.getAge();
    }
}

class Visitor2 implements Visitor{ //统计学生的最高成绩，老师的额最高工龄
    private int MaxScore = -1;
    private int Maxworkyear = -1;

    public int getMaxScore(){
        return MaxScore;
    }

    public int getMaxworkyear(){
        return Maxworkyear;
    }


    @Override
    public void visitstudent(Student2 student2){
        System.out.println("访问者2访问学生："+student2.getName()+"分数"+student2.getscore());
        MaxScore = Math.max(MaxScore,student2.getscore());
    }
    @Override
    public void visitteacher(Teacher2 teacher2){
        System.out.println("访问者2访问老师："+teacher2.getName()+"工龄"+teacher2.getWorkyear());
        Maxworkyear = Math.max(Maxworkyear, teacher2.getAge());
    }
}


class PersonStructure{
    private List<Person2> person2List = new ArrayList<Person2>();
    public PersonStructure(){
        person2List.add(new Student2("zhangsan",20,80));
        person2List.add(new Student2("lisi",22,88));
        person2List.add(new Student2("wangwu",24,99));

        person2List.add(new Teacher2("王",30,6));
        person2List.add(new Teacher2("刘",31,7));
        person2List.add(new Teacher2("李",32,8));
    }
    public void Accept(Visitor visitor){
        // for (遍历对象类型 对象名：遍历对象)
        for(Person2 person2:person2List){
            person2.Accept(visitor);
        }
    }
}



abstract class Person2{

    private String name;
    private int age;
    public Person2(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }




    public abstract void Accept(Visitor visitor);
}

class Student2 extends Person2{
    private int score;

    public Student2(String name,int age,int score){
        super(name,age);
        this.score = score;
    }
    public int getscore(){
        return score;
    }
    @Override
    public void Accept(Visitor visitor){
        visitor.visitstudent(this);
    }
}

class Teacher2 extends Person2{
    private int workyear;
    public Teacher2(String name,int age,int workyear){
        super(name,age);
        this.workyear = workyear;
    }

    public int getWorkyear(){
        return workyear;
    }
    @Override
    public void Accept(Visitor visitor){
        visitor.visitteacher(this);
    }
}