package asos;

public class Observer {
    private Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
    }

    public Observer(){}
    
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    public void update() {System.out.println("New subject state: "+subject.getState());} 
    
}
