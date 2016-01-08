package pattern.observer;

public class MyTopicSubscriber implements IObserver {
    
    private String name;
    private ISubject topic;
     
    public MyTopicSubscriber(String nm){
        this.name=nm;
    }
    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
        System.out.println(name+":: Consuming message::"+msg);
    }
 
    @Override
    public void setSubject(ISubject sub) {
        this.topic=sub;
    }
 
}