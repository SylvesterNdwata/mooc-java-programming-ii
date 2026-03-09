
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ndwat
 */
public class UserInterface {
    private TodoList todolist;
    private Scanner scanner;

    public UserInterface(TodoList todolist, Scanner scanner) {
        this.todolist = todolist;
        this.scanner = scanner;
    }
    
    public void start() {
        while (true) {
            System.out.println("Command: ");
            String input = this.scanner.nextLine();
            
            if (input.equalsIgnoreCase("stop")) {
                break;
            }
            
            if (input.equalsIgnoreCase("add")) {
                System.out.println("To add: ");
                String toBeAdded = this.scanner.nextLine();
                
                this.todolist.add(toBeAdded);
            }
            
            if (input.equalsIgnoreCase("list")) {
                this.todolist.print();
            }
            
            if (input.equalsIgnoreCase("remove")) {
                System.out.println("Which one is removed?: ");
                String command = this.scanner.nextLine();
                
                int toBeRemoved = Integer.valueOf(command);
                
                this.todolist.remove(toBeRemoved);
            }
        }
    }
}
