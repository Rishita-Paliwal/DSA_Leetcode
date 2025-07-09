import java.util.Random;

class Skiplist {

    private static final int MAX_LEVEL = 16;  // Maximum levels for the skiplist
    private static final double P = 0.5;      // Probability for random level generation

    // Node class
    private static class Node {
        int val;
        Node[] forward;

        Node(int val, int level) {
            this.val = val;
            this.forward = new Node[level];
        }
    }

    private Node head;     // Head of the skiplist
    private int level;     // Current max level
    private Random random; // Random generator

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL); // Dummy head node with MAX_LEVEL forward pointers
        level = 1;
        random = new Random();
    }

    public boolean search(int target) {
        Node curr = head;
        // Start from top level and move down
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    public void add(int num) {
        Node curr = head;
        Node[] update = new Node[MAX_LEVEL];

        // Find the insertion points at each level
        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        int lvl = randomLevel();
        if (lvl > level) {
            for (int i = level; i < lvl; i++) {
                update[i] = head;
            }
            level = lvl;
        }

        Node newNode = new Node(num, lvl);
        for (int i = 0; i < lvl; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) {
        Node curr = head;
        Node[] update = new Node[MAX_LEVEL];

        for (int i = level - 1; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        curr = curr.forward[0];
        if (curr == null || curr.val != num) {
            return false;
        }

        for (int i = 0; i < level; i++) {
            if (update[i].forward[i] != curr) break;
            update[i].forward[i] = curr.forward[i];
        }

        // Reduce level if needed
        while (level > 1 && head.forward[level - 1] == null) {
            level--;
        }

        return true;
    }

    private int randomLevel() {
        int lvl = 1;
        while (random.nextDouble() < P && lvl < MAX_LEVEL) {
            lvl++;
        }
        return lvl;
    }
}



/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */