public class StatePattern {
    public static void main(String[] args){
        Context context = new Context();

        System.out.println(context.getState());

        context.Request(); //购买一个饮料
        context.Request(); //购买一个饮料
        context.Request(); //购买一个饮料
        System.out.println(context.getState());

        context.Request();  //无货 等待补货， 已经补货成功
    }
}


class Context{
    private int count;

    private State state;

    public Context(){
        count = 3;
        state = new StateA();

    }

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    public void Request(){  //购买一个饮料
        state.Handle(this);
    }
}

interface State{
    public void Handle(Context context);
}

class StateA implements State{  //有货

    @Override
    public void Handle(Context context){
        int count  = context.getCount();

        if (count >= 1){
            System.out.println("购买成功");
            context.setCount(count -1);

            if (context.getCount() == 0){
                context.setState(new StateB());
            }
        }else{
            System.out.println("购买失败");
        }
    }
}

class StateB implements State{  //无货

    @Override
    public void Handle(Context context){
        int count = context.getCount();
        if (count == 0) {
            System.out.println("购买失败，等待补货");

            context.setCount(5);
            System.out.println("补货成功，请重新购买");
            context.setState(new StateA());
        }
    }
}