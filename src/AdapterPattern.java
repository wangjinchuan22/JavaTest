public class AdapterPattern {
    public static void main(String[] args){
        USB usb = new Adapter();
        usb.Request();
    }
}



class USB{
    public void Request(){
        System.out.println("USB接口");
    }
}


class Adapter extends USB{
    private TypeC typeC = new TypeC();

    @Override
    public void Request(){
        typeC.SpecificRequest();
    }
}


class TypeC {
    public void SpecificRequest(){
        System.out.println("TypeC-数据线");
    }
}

