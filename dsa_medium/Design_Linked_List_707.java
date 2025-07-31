class MyLinkedList {

    private class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head; // Sentinel head
    private Node tail; // Sentinel tail
    private int size;

    public MyLinkedList() {
        head = new Node(0); // dummy head
        tail = new Node(0); // dummy tail
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node curr = head.next; // start after dummy head
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        // Find prev and next nodes
        Node prevNode = head;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }
        Node nextNode = prevNode.next;

        Node newNode = new Node(val);
        newNode.prev = prevNode;
        newNode.next = nextNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node prevNode = head;
        for (int i = 0; i < index; i++) {
            prevNode = prevNode.next;
        }
        Node toDelete = prevNode.next;
        Node nextNode = toDelete.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */