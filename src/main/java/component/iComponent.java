package component;


enum CompState{
    RUNNING,
    ASLEEP
}


public interface iComponent {

    void start();
    void end();
    String getState();
    String getName();
    int getId();
    void setId(int id);


}
