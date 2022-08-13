import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Roofus {
    static String LINESEP = "****************************************";

    private List<Task> tasks = new ArrayList<>();

    void greet() {
        System.out.println(LINESEP);
        System.out.println("Hello I'm Roofus\n" + "What can I do for you?");
        System.out.println(LINESEP);
    }

    void addTask(Task task) {
        tasks.add(task);
        String reply = String.format("%s\nGot it. I've added this task:\n%s\n" +
                "Now you have %d tasks in the list.\n%s", LINESEP, task.toString(),
                tasks.size(), LINESEP);
        System.out.println(reply);
    }

    void signOff() {
        System.out.println(String.format("%s\nBye. Hope to see you again soon!\n%s",
                LINESEP, LINESEP));
    }

    void list() {
        System.out.println(LINESEP);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            int index = i + 1;
            System.out.println(index + "." + tasks.get(i).toString());
        }
        System.out.println(LINESEP);
    }

    void mark(int index) {
        tasks.get(index-1).mark();
    }

    void unMark(int index) {
        tasks.get(index-1).unmark();
    }

    public static void main(String[] args) {
        Roofus roofus = new Roofus();
        roofus.greet();
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            Scanner sc2 = new Scanner(input);
            String command = sc2.next().toUpperCase();
            switch (command) {
                case "BYE":
                    roofus.signOff();
                    isRunning = false;
                    break;
                case "LIST":
                    roofus.list();
                    break;
                case "MARK":
                    int index = Integer.parseInt(sc2.next());
                    roofus.mark(index);
                    break;
                case "UNMARK":
                    int index2 = Integer.parseInt(sc2.next());
                    roofus.unMark(index2);
                    break;
                case "TODO":
                    roofus.addTask(new ToDo(sc2.nextLine()));
                    break;
                case "DEADLINE":
                    String details = sc2.nextLine();
                    String[] separate = details.split("/by", 2);
                    roofus.addTask(new Deadline(separate[0], separate[1]));
                    break;
                case "EVENT":
                    String details2 = sc2.nextLine();
                    String[] separate2 = details2.split("/at", 2);
                    roofus.addTask(new Event(separate2[0], separate2[1]));
                    break;
            }
            if (!isRunning) {
                break;
            }
        }
    }
}
