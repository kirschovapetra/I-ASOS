package asos;

public class Processor implements IReceiver {

    @Override
    public void put(String m) {
        System.out.println("" + m);
    }
   
}
