public class pairSum {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表
        ListNode last = slow.next;
        while (last.next != null) {
            ListNode cur = last.next;
            last.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
        }

        int ans = 0;
        ListNode x = head;
        ListNode y = slow.next;
        while (y != null) {
            ans = Math.max(ans, x.val + y.val);
            x = x.next;
            y = y.next;
        }
        return ans;
    }
}

class ListNode {
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
