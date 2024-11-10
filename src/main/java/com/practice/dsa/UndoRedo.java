package com.practice.dsa;

import java.util.ArrayList;
import java.util.List;

public class UndoRedo {
    public static void main(String[] args) {
        String[] operation = new String[]{"x", "y", "UNDO", "z", "REDO", "UNDO","REDO"};
        List<String> stack = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < operation.length; i++) {
            if (operation[i].equalsIgnoreCase("Undo")) {
                if (!result.isEmpty())
                    stack.add(result.remove(result.size() - 1));
            } else if (operation[i].equalsIgnoreCase("Redo")) {
                if (!stack.isEmpty())
                    result.add(stack.remove(stack.size() - 1));
            } else {
                result.add(operation[i]);
            }
        }
        System.out.println(result);
    }


}
