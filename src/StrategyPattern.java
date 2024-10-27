public class StrategyPattern {
    public static void main(String[] args){
        Strategy add  = new AddStrategy();
        Strategy sub = new SubStrategy();
        Strategy mul = new MultiplyStrategy();
        OperationContext context = new OperationContext(add);
        context.Operation(2022,528);

        context = new OperationContext(sub);  //不需要重新定义对象
        context.Operation(2022,528);

    }}



class OperationContext{
    private Strategy strategy;

    public OperationContext(Strategy strategy){
        this.strategy =strategy;
    }

    public void Operation(int a ,int b){
        strategy.TwoNumberOperation(a,b);
    }
}

interface Strategy{
    public void TwoNumberOperation(int a,int b);
}

class AddStrategy implements Strategy{
    @Override
    public void TwoNumberOperation(int a,int b){
        System.out.println(a + b);
    }
}

class SubStrategy implements Strategy{
    @Override
    public void TwoNumberOperation(int a,int b){
        System.out.println(a - b);
    }
}

class MultiplyStrategy implements Strategy{
    @Override
    public void TwoNumberOperation(int a,int b){
        System.out.println(a * b);
    }
}