package asos;

public class Subject {
    private Observer observer;
    private String state;
    
    public Subject(Observer observer) {
        this.observer = observer;
    }

    public Subject() {
    }
    
    public Observer getObserver() {
        return observer;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        if (observer != null) observer.update();
    }
    
    

    
}
