
package controller;

import model.TaskList;
import model.Task;
import util.InputUtils;

/**
 *
 * @author nhsuong
 */
public class Controller {
    
    public static void main(String[] args) {
        TaskList task = new TaskList();
        int choice;
        while (true) {
            choice = Menu.chooseInputOption();
            switch (choice) {
                case 1 -> {
                    addTask(task);
                }
                case 2 -> {
                    changeMark(task);
                }
                case 3 -> {
                    removeTask(task);
                }
                case 4 -> {
                    task.printRandomOrder();
                }
                case 5 -> {
                    clearTaskList(task);
                }
                case 6 ->
                    System.exit(0);
            }
        }
    }
    
    public static Task inputTask(TaskList task){
        System.out.println("Enter task: ");
        String name = InputUtils.inputName();
        boolean completed = false;
        int id;
        if (task.isEmpty()){
            id = 1;
        }else{
            id = task.getTail().getData().getId() + 1;
        }
        Task it = new Task(id, name, completed);
        return it;
    }
    
    public static void changeMark(TaskList task){
        task.displayList();
        System.out.println("Enter id to change completed mark: ");
        int id = InputUtils.inputInt();
        Task it = task.searchById(id);
        if( it != null){
            task.markCompleted(it);
            System.out.println("Marked successfully!");
            task.displayList();
        }else{
            System.err.println("ID not found!");
        }
    }
    
    public static void removeTask(TaskList task){
        task.displayList();
        System.out.println("Enter id to remove item: ");
        int id = InputUtils.inputInt();
        Task it = task.searchById(id);
        if( it!= null){
            task.removeList(it);
            System.out.println("Removed successfully!");
            task.displayList();
        }else{
            System.err.println("ID not found!");
        }
    }
    
    public static void addTask(TaskList task){
        task.add(inputTask(task));
        System.out.println("Added successfully!");
        task.displayList();
    }
    
    public static void clearTaskList(TaskList task){
        task.displayList();
        System.out.println("Do you sure to clear task list? Data will lost forever.\nPress 1 (YES) or 0 (NO)");
        int choice = InputUtils.inputOption(0, 1);
        if (choice == 1){
            task.clear();
            System.out.println("Cleared task list!");
        }
    }
    
}
