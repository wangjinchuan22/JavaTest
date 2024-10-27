public class FlyWeightPattern {
    public static void main(String[] args){
        PieceFactory factory = new PieceFactory();

        Piece whitepiece1 = factory.getPiece(0);
        whitepiece1.draw(10,10);
        System.out.println(whitepiece1);

        Piece whitepiece2 = factory.getPiece(0);
        whitepiece2.draw(20,20);
        System.out.println(whitepiece1);

        Piece whitepiece3 = factory.getPiece(0);
        whitepiece3.draw(30,30);
        System.out.println(whitepiece1);

        Piece whitepiece4 = factory.getPiece(0);
        whitepiece4.draw(40,40);
        System.out.println(whitepiece1);


    }
}

class PieceFactory{
    private Piece[] pieces = {new WhitePiece(),new BlackPiece()};

    public Piece getPiece(int key){
        if (key == 0) return pieces[0];
        else return pieces[1];
    }
}


abstract class Piece{
    protected String color;

    public abstract void draw(int x,int y);
}

class WhitePiece extends Piece{
    public WhitePiece(){
        this.color = "white";
    }

    @Override
    public void draw(int x, int y){
        System.out.println("draw a color:" + color+"piece x:"+x+"y:"+y);
    }
}

class BlackPiece extends Piece {
    public BlackPiece() {
        this.color = "black";
    }
    @Override
    public void draw(int x, int y){
        System.out.println("draw a color:" + color+"piece x:"+x+"y:"+y);

    }
}
