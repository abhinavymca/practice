package com.practice.dsa;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.insertKeyValuePair("a",1);
        System.out.println(lruCache.getValueFromKey("a"));
        lruCache.insertKeyValuePair("a", 9001);
    }

    static class Node{
        String key;
        Node next;
        Node prev;
    }
    static class LRUCache {
        int maxSize;
        private final Map<String, Integer> cache = new HashMap<>();
        private final DoubleLinkedList cacheList = new DoubleLinkedList();
        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
            System.out.println("max size:"+maxSize);
        }

        public void print(){
            Node temp = cacheList.head;
            System.out.println("===print=start===");
            while(temp!=null){
                System.out.println("key:"+temp.key);
                temp=temp.next;
            }
            System.out.println("===print===end===");
        }

        public void insertKeyValuePair(String key, int value) {
            // Write your code here.
            if(cache.containsKey(key)){
                Node node = cacheList.remove(key);
                cacheList.addFirst(node);
                cache.put(key, value);
            } else {
                if(cache.size()==maxSize){
                    cache.remove(cacheList.tail.key);
                    cacheList.removeLast();
                }
                Node node = new Node();
                node.key = key;
                node.next=null;
                node.prev=null;
                cacheList.addFirst(node);
                cache.put(key, value);
            }
            print();
        }

        public LRUResult getValueFromKey(String key) {
            System.out.println("===getValueFromKey start===: "+key);
            // Write your code here.
            if(cache.containsKey(key)){
                Node node = cacheList.remove(key);
                if(node!=null){
                    cacheList.addFirst(node);
                    return new LRUResult(true, cache.get(key));
                }
            }
            System.out.println("===getValueFromKey: not found, end===");

            return null;
        }

        public String getMostRecentKey() {
            // Write your code here.
            System.out.println("===getMostRecentKey start===");
            print();
            System.out.println("===getMostRecentKey end===");
            return cacheList.head.key;
        }
    }

    static class DoubleLinkedList{
        Node head;
        Node tail;

        public void addFirst(Node node){
            if(head==null){
                head=node;
                tail=node;
            }else{
                node.next = head;
                head.prev = node;
                head = node;
            }
        }

        public Node remove(String key){
            Node itr = head;
            while(itr!=null){
                if(itr.key.equals(key))
                    break;
                itr = itr.next;
            }

            if(itr!=null){
                if(itr==head){
                    head=itr.next;
                }
                if(tail==itr)
                    tail=itr.prev;
                if(itr.next!=null) itr.next.prev=itr.prev;
                if(itr.prev!=null) itr.prev.next=itr.next;
                itr.next=null;
                itr.prev=null;
                return itr;
            }
            return null;
        }

        public void removeLast(){
            if(head==tail){
                head=null;
                tail=null;
            } else {
                tail = tail.prev;
                tail.next.prev=null;
                tail.next=null;
            }
        }

    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }
}
