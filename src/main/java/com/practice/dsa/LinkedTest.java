package com.practice.dsa;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LinkedTest {
    public static void main(String[] args) {
//        Node node1 = new Node(5);
//        Node node2 = new Node(6);
//        node1.next=node2;
//        node1.prev=null;
//        node2.prev=node1;
//        node2.next=null;
//        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
//        doublyLinkedList.head=node1;
//        doublyLinkedList.tail=node2;
//
//        Node node3 = new Node(4);
//        doublyLinkedList.setHead(node3);
//
//        Node node4 = new Node(7);
//        doublyLinkedList.setTail(node4);
//
//        doublyLinkedList.insertBefore(node3,new Node(10));
//        doublyLinkedList.insertAfter(node4, new Node(15));
//        doublyLinkedList.insertAtPosition(1, new Node(100));
//        doublyLinkedList.insertAtPosition(6, new Node(100));
//
//        Node traverse = doublyLinkedList.head;
//        while(traverse!=null){
//            System.out.println(traverse.value);
//            traverse=traverse.next;
//        }
//        System.out.println();
//        doublyLinkedList.removeNodesWithValue(5);
//        doublyLinkedList.removeNodesWithValue(100);
//        doublyLinkedList.removeNodesWithValue(100);
//        doublyLinkedList.remove(new Node(4));
//        System.out.println(doublyLinkedList.containsNodeWithValue(10));
//        System.out.println(doublyLinkedList.containsNodeWithValue(15));
//        System.out.println(doublyLinkedList.containsNodeWithValue(6));
//        System.out.println(doublyLinkedList.containsNodeWithValue(20));
//
//        traverse = doublyLinkedList.head;
//        while(traverse!=null){
//            System.out.println(traverse.value);
//            traverse=traverse.next;
//        }
        LinkedTest linkedTest = new LinkedTest();
        linkedTest.TestCase1();
    }

    private List<Integer> getNodeValuesHeadToTail(LinkedTest.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<>();
        LinkedTest.Node node = linkedList.head;
        while (node != null) {
            values.add(node.value);
            node = node.next;
        }
        return values;
    }

    private List<Integer> getNodeValuesTailToHead(LinkedTest.DoublyLinkedList linkedList) {
        List<Integer> values = new ArrayList<Integer>();
        LinkedTest.Node node = linkedList.tail;
        while (node != null) {
            values.add(node.value);
            node = node.prev;
        }
        return values;
    }

    private void bindNodes(LinkedTest.Node nodeOne, LinkedTest.Node nodeTwo) {
        nodeOne.next = nodeTwo;
        nodeTwo.prev = nodeOne;
    }

    private boolean compare(List<Integer> array1, int[] array2) {
        if (array1.size() != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.size(); i++) {
            if (array1.get(i) != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public void TestCase1() {
        LinkedTest.DoublyLinkedList linkedList = new LinkedTest.DoublyLinkedList();
        LinkedTest.Node one = new LinkedTest.Node(1);
        LinkedTest.Node two = new LinkedTest.Node(2);
        LinkedTest.Node three = new LinkedTest.Node(3);
        LinkedTest.Node three2 = new LinkedTest.Node(3);
        LinkedTest.Node three3 = new LinkedTest.Node(3);
        LinkedTest.Node four = new LinkedTest.Node(4);
        LinkedTest.Node five = new LinkedTest.Node(5);
        LinkedTest.Node six = new LinkedTest.Node(6);
        bindNodes(one, two);
        bindNodes(two, three);
        bindNodes(three, four);
        bindNodes(four, five);
        linkedList.head = one;
        linkedList.tail = five;

        Node traverse = linkedList.head;
        while (traverse != null) {
            System.out.println(traverse.value);
            traverse = traverse.next;
        }
        System.out.println();
        linkedList.setHead(four);

        traverse = linkedList.head;
        while (traverse != null) {
            System.out.println(traverse.value);
            traverse = traverse.next;
        }
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 2, 3, 5}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{5, 3, 2, 1, 4}));

        linkedList.setTail(six);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 2, 3, 5, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{6, 5, 3, 2, 1, 4}));

        linkedList.insertBefore(six, three);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 2, 5, 3, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{6, 3, 5, 2, 1, 4}));

        linkedList.insertAfter(six, three2);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 2, 5, 3, 6, 3}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{3, 6, 3, 5, 2, 1, 4}));

        linkedList.insertAtPosition(1, three3);
        assertTrue(
                compare(getNodeValuesHeadToTail(linkedList), new int[]{3, 4, 1, 2, 5, 3, 6, 3}));
        assertTrue(
                compare(getNodeValuesTailToHead(linkedList), new int[]{3, 6, 3, 5, 2, 1, 4, 3}));

        linkedList.removeNodesWithValue(3);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 2, 5, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{6, 5, 2, 1, 4}));

        linkedList.remove(two);
        assertTrue(compare(getNodeValuesHeadToTail(linkedList), new int[]{4, 1, 5, 6}));
        assertTrue(compare(getNodeValuesTailToHead(linkedList), new int[]{6, 5, 1, 4}));

        assertTrue(linkedList.containsNodeWithValue(5));
    }

    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            // Write your code here.
            node.prev.next = node.next;
            node.next.prev = node.prev;
            head.prev = node;
            node.next = head;
            node.prev = null;
            head = node;
        }

        public void updateHead(Node node) {
            if (head != null) {
                Node old = head;
                old.prev = node;
                node.next = old;
                node.prev = null;
                head = node;
            } else {
                head = node;
                node.prev = null;
                node.next = null;
                tail = head;
            }
        }

        public void setTail(Node node) {
            // Write your code here.
            Node old = tail;
            old.next = node;
            node.prev = old;
            node.next = null;
            tail = node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.

            nodeToInsert.prev.next = nodeToInsert.next;
            nodeToInsert.next.prev = nodeToInsert.prev;
            nodeToInsert.prev = node.prev;
            nodeToInsert.next = node;
            if (node.prev != null) node.prev.next = nodeToInsert;
            node.prev = nodeToInsert;
            if (head == node)
                head = nodeToInsert;
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
            nodeToInsert.next = node.next;
            nodeToInsert.prev = node;
            if (node.next != null) node.next.prev = nodeToInsert;
            node.next = nodeToInsert;
            if (node == tail)
                tail = nodeToInsert;
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
            Node traverse = head;
            int count = 1;
            if (position == 1) {
                updateHead(nodeToInsert);
            } else {
                while (count != position && traverse != null) {
                    count++;
                    traverse = traverse.next;
                }
                if (traverse != null && count == position) {
                    setTail(nodeToInsert);
                } else {
                    nodeToInsert.prev = traverse.prev;
                    nodeToInsert.next = traverse;
                    traverse.prev.next = nodeToInsert;
                    traverse.prev = nodeToInsert;
                }
            }
        }

        public void removeNodesWithValue(int value) {
            // Write your code here.

            if (head == tail && head.value == value) {
                head = null;
                tail = null;
            }
            if (head.value == value) {
                Node node = head;
                node = node.next;
                node.prev = null;
                head = node;
            }

            Node traverse = head;
            while (traverse.next != null) {
                if (traverse.value == value) {
                    traverse.prev.next = traverse.next;
                    traverse.next.prev = traverse.prev;
                }
                traverse = traverse.next;
            }
            if (traverse.next == null && traverse.value == value) {
                traverse = traverse.prev;
                traverse.next.prev = null;
                traverse.next = null;
                tail = traverse;
            }

        }

        public void remove(Node node) {
            // Write your code here.
            if(node.next!=null) node.next.prev = node.prev;
            if(node.prev!=null) node.prev.next = node.next;
            if(node==head) head=node.next;
            if(node==tail) tail = node.prev;
        }

        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            Node traverse = head;
            while (traverse != null) {
                if (traverse.value == value)
                    return true;
                traverse = traverse.next;
            }
            return false;
        }
    }

    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

