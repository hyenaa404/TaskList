package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author nhs
 */
public class TaskList extends MyList<Task> {

    public TaskList() {
        super();
    }
    
    
    
    public Task searchById(int id){
        Node<Task> p = head;
        Task item;
        while (p!= null){
            item = p.getData();
            if(item.getId() == id){
                return item;
            }
            p = p.getNext();
        }
        return null;
    }
    
    
    public void markCompleted(Task it){
        it.setCompleted(!it.isCompleted());
    }
    
    public void printRandomOrder() {
        List<Task> taskList = new ArrayList<>();
        Node<Task> current = head;
        while (current != null) {
            taskList.add(current.getData());
            current = current.getNext();
        }

        Collections.shuffle(taskList, new Random());

        System.out.println("Random order of tasks:");
        for (Task task : taskList) {
            System.out.println(task.toString());
        }
    }
    
    @Override
    public void displayList() {
        System.out.printf("|  %-5s |   %-30s |    %-10s\n\n","ID", "Todo List", "Mark");
        super.displayList();
    }

    
}
