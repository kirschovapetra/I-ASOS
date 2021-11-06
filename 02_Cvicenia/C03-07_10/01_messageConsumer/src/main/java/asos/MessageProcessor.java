package asos;

public class MessageProcessor {

    private MessageServiceIfc service;
    private MessageConsumerIfc consumer;

    public MessageProcessor(MessageServiceIfc service, MessageConsumerIfc consumer) {
        this.service = service;
        this.consumer = consumer;
    }

    public void processMessage() {
        String msg = service.getMessage();
        consumer.putMessage(msg);
    }
}
