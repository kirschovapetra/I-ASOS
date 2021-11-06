package asos;


public class MessageConsumerMock implements MessageConsumerIfc {

    @Override
    public void putMessage(String msg) {
        System.out.println(msg);
    }
}
