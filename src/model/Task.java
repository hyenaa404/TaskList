
package model;

/**
 *
 * @author nhs
 */
public class Task {
    private String name;
    private boolean completed;
    private int id;

    public Task() {
    }

    public Task(int id, String name, boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    @Override
    public String toString() {
        String mark;
        if(this.isCompleted()){
            mark = "completed";
        }else{
            mark = "not yet";
        }
        System.out.printf("|  %-5d |   %-30s |    %-10s",this.id, this.name, mark);
        return "";
    }
    
    
    
}
