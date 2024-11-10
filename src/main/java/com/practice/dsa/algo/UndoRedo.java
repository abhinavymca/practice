package com.practice.dsa.algo;

import java.util.List;
import java.util.Stack;

public class UndoRedo {
    List<String> undo = new Stack<>();
    List<String> redo = new Stack<>();

    void write(String letter){
        undo.add(letter);
        redo.clear();
    }

    void undo(){
        if(!undo.isEmpty()){
            redo.add(undo.remove(undo.size()-1));
        }
    }

    void redo(){
        if(!redo.isEmpty()){
            String lastRemoved = redo.remove(redo.size()-1);
            undo.add(lastRemoved);

        }
    }

    public static void main(String[] args) {
        UndoRedo undoRedo = new UndoRedo();
        undoRedo.write("A");
        undoRedo.write("B");
        undoRedo.write("C");
        undoRedo.write("D");
        undoRedo.undo.forEach(System.out::print);
        System.out.println();
        undoRedo.undo();
        undoRedo.undo.forEach(System.out::print);
        System.out.println();
        undoRedo.undo();
        undoRedo.undo.forEach(System.out::print);
        System.out.println();
        undoRedo.undo();
        undoRedo.undo.forEach(System.out::print);
        System.out.println();
        undoRedo.write("E");
        undoRedo.undo.forEach(System.out::print);
        System.out.println();
        undoRedo.undo();
        undoRedo.undo.forEach(System.out::print);
        System.out.println();
        undoRedo.redo.forEach(System.out::print);
        System.out.println();
        undoRedo.undo();
        undoRedo.undo.forEach(System.out::print);
        System.out.println();
        undoRedo.undo();
        undoRedo.undo.forEach(System.out::print);
        System.out.println();
        undoRedo.undo();
        undoRedo.undo.forEach(System.out::print);
        System.out.println();

        UndoRedo undoRedo1 = new UndoRedo();

        undoRedo1.performAction("Type A");
        undoRedo1.performAction("Type B");
        undoRedo1.performAction("Type C");

        undoRedo1.undoS(); // Undo last action (Type C)
        undoRedo1.undoS(); // Undo previous action (Type B)
        undoRedo1.redoS(); // Redo action (Type B)
        undoRedo1.performAction("Type D"); // Perform a new action (Type D)

        undoRedo1.showHistory();

    }


    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public UndoRedo() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    // Perform a new action and add it to the undo stack
    public void performAction(String action) {
        undoStack.push(action);
        redoStack.clear(); // Clear redo stack since we're making a new action
        System.out.println("Performed action: " + action);
    }

    // Undo the last action
    public void undoS() {
        if (!undoStack.isEmpty()) {
            String lastAction = undoStack.pop();
            redoStack.push(lastAction);
            System.out.println("Undo action: " + lastAction);
        } else {
            System.out.println("No actions to undo.");
        }
    }

    // Redo the last undone action
    public void redoS() {
        if (!redoStack.isEmpty()) {
            String lastUndoneAction = redoStack.pop();
            undoStack.push(lastUndoneAction);
            System.out.println("Redo action: " + lastUndoneAction);
        } else {
            System.out.println("No actions to redo.");
        }
    }

    // Utility to display the current state of stacks
    public void showHistory() {
        System.out.println("Undo Stack: " + undoStack);
        System.out.println("Redo Stack: " + redoStack);
    }

}
