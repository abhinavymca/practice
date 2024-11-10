package com.practice.dsa.algo;

public class BST {

    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

    public BST insert(int value) {
        // Write your code here.
        // Do not edit the return statement of this method.
        BST bst = new BST(value);
        insert(value, this, bst);
        return this;
    }

    public boolean contains(int value) {
        // Write your code here.
        BST currentNode = this;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            } else if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return false;
    }

    public BST remove(int value) {
        // Write your code here.
        // Do not edit the return statement of this method.
        remove(value, null);
        return this;
    }

    void remove(int value, BST parentNode) {
        BST currentNode = this;
        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                parentNode = currentNode;
                currentNode = currentNode.right;
            } else {
                if (currentNode.left != null && currentNode.right != null) {
                    currentNode.value = currentNode.right.findSmallestInRight();
                    currentNode.right.remove(currentNode.value, currentNode);
                } else if (parentNode == null) {
                    if (currentNode.left != null) {
                        currentNode.value = currentNode.left.value;
                        currentNode.right = currentNode.left.right;
                        currentNode.left = currentNode.left.left;
                    } else if (currentNode.right != null) {
                        currentNode.value = currentNode.right.value;
                        currentNode.left = currentNode.right.left;
                        currentNode.right = currentNode.right.right;
                    }
                } else if (parentNode.left == currentNode) {
                    parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                } else if (parentNode.right == currentNode) {
                    parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                }
                break;
            }
        }
    }

    int findSmallestInRight() {
        if (this.left != null) return this.left.findSmallestInRight();
        else return this.value;
    }


    void insert(int value, BST tree, BST bst) {
        if (value < tree.value) {
            if (tree.left != null) insert(value, tree.left, bst);
            else {
                System.out.println("parent:" + tree.value + " left:" + value);
                tree.left = bst;
                return;
            }
        } else {
            if (tree.right != null) insert(value, tree.right, bst);
            else {
                System.out.println("parent:" + tree.value + " right:" + value);
                tree.right = bst;
                return;
            }
        }
    }


}

