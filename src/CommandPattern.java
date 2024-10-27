public class CommandPattern {
    public static void main(String[] args){
        Tv tv = new Tv();    //接收者 对象  电视机
        Command oncommand = new Oncommand(tv);   //命令对象  开机命令
        Command offcommand = new Offcommand(tv);   // 命令对象  关机命令

        Invoker invoker = new Invoker();    //请求者
        invoker.setcommand(oncommand);      //给请求者设置开机命令
        invoker.call();          //请求者  请求命令

        System.out.println("===========================");

        invoker.setcommand(offcommand);
        invoker.call();

    }
}

class Invoker{       //请求者
    private Command command;
    public void setcommand(Command command){ //设置请求者 的 请求命令
        this.command = command;

    }
    public void call(){
        command.Execute();
    }
}


interface Command{
    public void Execute();
}

class Oncommand implements Command{
    private Tv tv;
    public Oncommand(Tv tv){
        this.tv = tv;
    }

    @Override
    public void Execute(){
        tv.On();
    }
}

class Offcommand implements Command{
    private Tv tv;
    public Offcommand(Tv tv){
        this.tv = tv;
    }

    @Override
    public void Execute(){
        tv.Off();
    }
}


class Tv{
    public void On(){
        System.out.println("电视开机");
    }
    public void Off(){
        System.out.println("电视关机");
    }
}