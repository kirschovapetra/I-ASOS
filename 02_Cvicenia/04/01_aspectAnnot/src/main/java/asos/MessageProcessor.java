package asos;

public class MessageProcessor {

    private MessageServiceIfc service;
    private MessageConsumerIfc consumer;

    public MessageProcessor(MessageServiceIfc service, MessageConsumerIfc consumer) {
        this.service = service;
        this.consumer = consumer;
    }

    public MessageServiceIfc getService() {
        return service;
    }

    public void setService(MessageServiceIfc service) {
        this.service = service;
    }

    public MessageConsumerIfc getConsumer() {
        return consumer;
    }

    public void setConsumer(MessageConsumerIfc consumer) {
        this.consumer = consumer;
    }
    
    

    public void processMessage() {
        String msg = service.getMessage();
        consumer.putMessage(msg);
    }
}
