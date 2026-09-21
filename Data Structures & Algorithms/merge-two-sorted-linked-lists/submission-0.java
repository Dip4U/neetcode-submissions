class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // A dummy node acts as the start anchor of our merged list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy; // This tail pointer will move forward as we append nodes
        
        // Loop runs as long as BOTH lists have elements remaining
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;  // Connect the smaller node
                list1 = list1.next; // Move list1 pointer forward
            } else {
                tail.next = list2;  // Connect the smaller node
                list2 = list2.next; // Move list2 pointer forward
            }
            tail = tail.next; // Move our tail pointer forward to the new end of the list
        }
        
        // If one list runs out of nodes, append the entire remaining part of the other list
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        
        // The merged list actually starts right after the dummy node
        return dummy.next;
    }
}
