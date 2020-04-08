package com.zhou.demo;

import org.junit.Test;


/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author zhous
 * @create 2019-09-19 9:18
 */
public class Demo2 {

    @Test
    public void test() {
        //初始化参数
        /*ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;*/


        ListNode l11 = new ListNode(0);
        ListNode l12 = new ListNode(8);
        ListNode l13 = new ListNode(6);
        l11.next = l12;
        l12.next = l13;
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(7);
        ListNode l23 = new ListNode(8);
        l21.next = l22;
        l22.next = l23;

        /*ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);*/

       /* ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(9);
        l11.next = l12;
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        l21.next = l22;*/

         /*[0,8,6,5,6,8,3,5,7]
        [6,7,8,0,8,5,8,9,7]*/

        //执行大数相加
        ListNode listNode = addTwoNumbers(l11, l21);
        sout(listNode);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode last = head;
        int flag = 0;
        while (l1 != null || l2 != null || flag != 0) {
            ListNode next = new ListNode(0);
            next.val = (((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val)) + flag) % 10;
            if ((((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val)) + flag) / 10 > 0) {
                //有进位
                flag = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + flag) / 10;
            } else {
                flag = 0;
            }
            last.next = next;
            last = next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head.next;
    }

    private int getSize(ListNode listNode) {
        ListNode tmp = new ListNode(0);
        tmp.next = listNode;
        int count = 0;
        while (tmp.next != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }


    /**
     * 输出方法
     *
     * @param listNode
     */
    private void sout(ListNode listNode) {
        //输出结果
        System.out.println("-----------------");
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("-----------------");
    }
}
