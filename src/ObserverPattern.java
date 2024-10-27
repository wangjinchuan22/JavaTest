import java.util.*;
public class ObserverPattern {
    public static void main(String[] args){
        Subject subjectA = new ConcreteSubject("目标A");
        Observer observerA = new ConcreteObserver("张三",subjectA);
        Observer observerB = new ConcreteObserver("李四",subjectA);
        Observer observerC = new ConcreteObserver("王五",subjectA);

        System.out.println("目标A的状态发生了改变");
        subjectA.setstate("已更新");
        System.out.println("===============================");
        subjectA.setstate("停更了");
        //subjectA.Notify();
    }
}


interface Subject{    //目标
    public void Attach(Observer observer); //添加观察者
    public void Detach(Observer observer); //删除观察者
    public void Notify(); // 状态改变后通知所有的观察者
    public void setstate(String state);  //设置状态
    public String getstate();  //获取状态
}

class ConcreteSubject implements Subject{
    private String name;
    private String state;


    public void setstate(String state){
        this.state = state;
        System.out.println(name+ "的状态发生变化，变化后的状态是" + state);

        Notify();
    }

    public String getstate(){
        return state;

    }

    private List<Observer> observerList;


    public ConcreteSubject(String name){
        state = "未更新";
        this.name = name;
        observerList = new ArrayList<Observer>();
    }


    public void Attach(Observer observer){
        observerList.add(observer);
    }


    public void Detach(Observer observer){
        observerList.remove(observer);
    }


    public void Notify(){
        //for (遍历对象类型 对象名:遍历对象)
        for(Observer observer : observerList){
            observer.update();
        }
    }
}



interface Observer{   //观察者接口
    public void update();  //更新观察者的状态
}

class ConcreteObserver implements Observer{
    private String name;
    private String state;


    private Subject subject;

    public ConcreteObserver(String name,Subject subject){
        this.name = name;
        this.subject = subject;
        subject.Attach(this);

        state = subject.getstate();
    }

    @Override
    public void update(){
        System.out.println(name + "收到通知");
        state = subject.getstate();  //让当前观察者的状态 和 改变了状态之后的目标状态保持一致
        System.out.println(name + "改变后的状态为：" + state);
    }
}