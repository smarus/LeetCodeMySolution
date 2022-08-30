package educative.k.merge;

import leetcode.easy.linked_list.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedList {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);


        ListNode l3 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode resultHead = MergeKSortedList.mergeKsortedList(new ListNode[]{l1, l2, l3});
        System.out.println("Result list");
        while (resultHead != null) {
            System.out.println(resultHead.val);
            resultHead = resultHead.next;
        }
    }


    public static ListNode mergeKsortedList(ListNode[] list) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);

        for (ListNode root : list)
            if (root != null)
                minHeap.offer(root);

        ListNode resultHead = null;
        ListNode resultTail = null;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (resultHead == null)
                resultHead = resultTail = node;
            else {
                resultTail.next = node;
                resultTail = resultTail.next;
            }

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return resultHead;
    }
}
