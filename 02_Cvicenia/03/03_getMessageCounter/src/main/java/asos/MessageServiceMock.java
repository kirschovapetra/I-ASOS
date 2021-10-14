package asos;


public class MessageServiceMock implements MessageServiceIfc {

    @Override
    public String getMessage() {
        return "Tu je mock!";
    }
}
