package roofus.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void addToDoTest() {
        Task toDoTask = new ToDo("Say hello");
        assertEquals("[T][ ] Say hello", toDoTask.toString());
    }
    
    @Test 
    public void setDoneTest() {
        Task toDoTask = new ToDo("Say hello");
        toDoTask.setDone();
        assertEquals("[T][X] Say hello", toDoTask.toString());
        toDoTask.setDone();
        assertEquals("[T][X] Say hello", toDoTask.toString());
    }
    
    @Test
    public void markToDoTest() {
        Task toDoTask = new ToDo("Say hello");
        toDoTask.mark();
        assertEquals("[T][X] Say hello", toDoTask.toString());
    }

    @Test
    public void unmarkToDoTest() {
        Task toDoTask = new ToDo("Say hello");
        toDoTask.mark();
        toDoTask.unmark();
        assertEquals("[T][ ] Say hello", toDoTask.toString());
    }
    
    @Test
    public void writeToDoTest() {
        Task toDoTask = new ToDo("Say hello");
        assertEquals("T | 0 | Say hello", toDoTask.writeString());
        toDoTask.mark();
        assertEquals("T | 1 | Say hello", toDoTask.writeString());
    }
}