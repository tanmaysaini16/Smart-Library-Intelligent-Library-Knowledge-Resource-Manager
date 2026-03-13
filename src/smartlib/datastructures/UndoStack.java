package smartlib.datastructures;

import java.util.Stack;

public class UndoStack {

    private Stack<String> stack = new Stack<>();

    public void push(String action) {
        stack.push(action);
    }

    public String undo() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return "No actions to undo.";
    }
}