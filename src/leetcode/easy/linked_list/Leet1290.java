package leetcode.easy.linked_list;

public class Leet1290 {
    public static void main(String[] args) {


    }

    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();

        for (ListNode current = head; current != null; current = current.next) {
            sb.append(current.val);
        }

        return Integer.parseInt(sb.toString(), '2');
    }
}
