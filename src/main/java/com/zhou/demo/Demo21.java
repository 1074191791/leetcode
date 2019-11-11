package com.zhou.demo;

import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhous
 * @create 2019-10-28 10:12
 */
public class Demo21 {

    @Test
    public void test() {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode listNode = mergeTwoLists(l11, l21);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        //测试成功
       /* List list = toArrayList(l11);
        Iterator iterator = list.iterator();
        ListNode listNode = toListNode(list);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }*/

        /*ListNode node1 = new ListNode(0);
        ListNode node2 = null;
        ListNode listNode = mergeTwoLists(node1, node2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }*/
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List list1 = null;
        List list2 = null;
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null) {
            //只对l2排序
            List list = toArrayList(l2);
            Collections.sort(list);
            return toListNode(list);
        } else {
            list1 = toArrayList(l1);
        }
        if(l2 == null) {
            //只对l1排序
            List list = toArrayList(l1);
            Collections.sort(list);
            return toListNode(list);
        } else {
            list2 = toArrayList(l2);
        }

        Iterator iterator = list1.iterator();
        while (iterator.hasNext()) {
            list2.add(iterator.next());
        }
        Collections.sort(list2);
        return toListNode(list2);
    }

    public List toArrayList(ListNode listNode) {
        List list = new LinkedList();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    public ListNode toListNode(List list2) {
        //做一个头
        ListNode head = new ListNode((Integer) list2.get(0));
        ListNode prep;
        ListNode last = null;

        prep = head;
        for(int i = 1; i < list2.size(); ++i) {
            int o = (Integer)list2.get(i);
            last = new ListNode(o);
            prep.next = last;
            prep = last;
        }
        if(last != null) {
            last.next = null;
        }
        return head;
    }


    /**
     * 内部类，list节点
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int x) {
            val = x;
        }
    }
}
