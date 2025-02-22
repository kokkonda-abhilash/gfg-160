package com.abhilash.codinginterview.linkedlist;

import java.util.Stack;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = new ReverseLinkedList().reverseLinkedList(head);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }

    /* 
     * Brute force
     */
    public Node reverseLinkedList(Node head) {
        Node temp = head;

        Stack<Integer> s = new Stack<>();
        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (!s.isEmpty()) {
            temp.data = s.pop();
            temp = temp.next;
        }
        return head;
    }

    /* 
     * Optimal approach - Recursive
     */
    public Node reverLinkedListRecursively(Node head) {
        /* 
         * Base Case: If node is null or is the only node, then return the node
         */
        if (head == null || head.next == null) return head;

        return head;        

    }

    /* 
     * Optimal approach: reverse in place
     * Use previous and front
     */
    public Node reverseLinkedListInPlace(Node head) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            /* 
             * Save the reference to the next node that 'temp' is pointing to in a variable called 'front'.
             * This helps retain the link to the subsequent node before altering the 'next' pointer.
             */
            Node front = temp.next;
            /* 
             * Reverse the direction of the ‘next’ pointer of the current node (pointed to by ‘temp’) to point to the ‘prev’ node.
             * This effectively reversed the direction of the linked list, making the current node point to the previous node
             */
            temp.next = prev;
            /* 
             * Move the ‘prev’ pointer to the current node. This sets up the ‘prev’ pointer for the next iteration of the loop.
             */
            prev = temp;
            /* 
             * Move the ‘temp’ pointer to the ‘front’ node. This advances the traversal to the next node in the original order.
             */
            temp = front;
        }
        return prev;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}