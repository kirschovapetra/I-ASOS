package asos;

public class Filter implements IReceiver {
    // len v testovacej verzii
//    public Filter() {
//    }

    private IReceiver nextReceiver;
    private String pattern;

    public Filter(String pattern) {
        this.pattern = pattern;
    }

    public void setNextReceiver(IReceiver nextReceiver) {
        this.nextReceiver = nextReceiver;
    }

    @Override
    public void put(String msg) {
        if (nextReceiver==null)
            return;
        if (pattern==null || !msg.contains(pattern))
           nextReceiver.put(msg);
    }

}
