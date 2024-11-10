package com.practice.dsa;

import java.util.PriorityQueue;

public class MergeKSortedLinkedList {
    public static void main(String[] args) {
        // [[1,4,5],[1,3,4],[2,6]]
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
        for (ListNode curr : lists) {
            if (curr != null)
                queue.add(curr);
        }

        while (!queue.isEmpty()) {
            node.next = queue.poll();
            node = node.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return head.next;
    }

    public ListNode mergeKListNotOptimised(ListNode[] lists){
         if(lists==null || lists.length==0) return null;
         ListNode result = lists[0];
         for(int i=1;i<lists.length;i++){
             result = mergeLists(result, lists[i]);
         }
         return result;
    }
    public ListNode mergeLists(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode itr1=l1, itr2=l2;
        ListNode head=null, itr=null;
        while(itr1!=null && itr2!=null){
            ListNode node = new ListNode();
            if(itr1.val<itr2.val){
                node.val = itr1.val;
                itr1=itr1.next;
            } else {
                node.val = itr2.val;
                itr2=itr2.next;
            }
            if(itr==null){
                itr=node;
                head=node;
            } else{
                itr.next=node;
                itr=node;
            }
        }
        if(itr1!=null){
            itr.next=itr1;
        } else {
            itr.next=itr2;
        }
        return head;
    }

    public class ListNode {
        int head;
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
