package com.practice.dsa;

public class TreeTraversal {
    public static void main(String[] args) {
        Node head = new Node();
        Node leftA = new Node();
        Node rightA = new Node();

        head.data = "A";
        leftA.data="B";
        rightA.data = "C";
        head.right=rightA;
        head.left=leftA;

        Node leftAB = new Node();
        Node rightAB = new Node();
        leftA.left=leftAB;
        leftA.right=rightAB;
        Node leftAC = new Node();
        Node rightAC = new Node();
        rightA.left=leftAC;
        rightA.right=rightAC;
        leftAB.data = "D";
        rightAB.data = "E";
        leftAC.data = "F";
        rightAC.data = "G";
    }

    static class Node {
        String data;
        Node left;
        Node right;
    }


}
