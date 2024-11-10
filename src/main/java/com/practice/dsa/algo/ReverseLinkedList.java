package com.practice.dsa.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        list.reverseList();
        list.print();

        list.reverseRecursion();
        list.print();

    }
    Node head;
    void add(int val){
        Node newNode = new Node(val);
        if(head==null){
            head=newNode;
        }else {
            Node temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next=newNode;
        }
    }

    void reverseList(){
        Node itr = head;
        Node next;
        Node prev = null;
        while(itr!=null){
            next=itr.next;
            itr.next=prev;
            prev=itr;
            itr=next;
        }
        head=prev;
    }

    void reverseRecursion(){
        head = rev(head);
    }

    Node rev(Node n){
        if(n==null || n.next==null) return n;
        Node node = rev(n.next);
        n.next.next=n;
        n.next=null;
        return node;
    }



    void print(){
        Node temp = head;
        List<Integer> valList = new ArrayList<>();
        while (temp!=null){
            valList.add(temp.val);
            temp = temp.next;
        }
        System.out.println(valList.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
}
