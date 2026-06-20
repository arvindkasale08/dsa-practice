package com.arvind.revision.hashing;

public class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] cells;
    private int hash;

    public MyHashMap() {
        cells = new Node[1000];
        hash = 1000;
    }

    public void put(int key, int value) {
        int mod = key % hash;
        Node existing = cells[mod];
        Node node = new Node(key, value);
        if (existing == null) {
            cells[mod] = node;
        } else {
            Node chainNode = findNode(existing, key);
            if (chainNode == null) {
                existing.prev = node;
                node.next = existing;
                cells[mod] = node;
            } else {
                chainNode.val = node.val;
            }
        }
    }

    public int get(int key) {
        int mod = key % hash;
        Node existing = cells[mod];
        if (existing == null) {
            return -1;
        } else {
            Node chainNode = findNode(existing, key);
            if (chainNode == null) {
                return -1;
            } else {
                return chainNode.val;
            }
        }
    }

    public void remove(int key) {
        int mod = key % hash;
        Node existing = cells[mod];
        if (existing == null) {
            return;
        } else {
            Node chainNode = findNode(existing, key);
            if (chainNode == null) {
                return;
            } else {
                Node prev = chainNode.prev;
                Node next = chainNode.next;
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                }
                if (prev == null) {
                    cells[mod] = next;
                }
            }
        }
    }

    private Node findNode(Node node, int key) {
        Node curr = node;
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }
        return curr;
    }

    public static void main(String[] args) {
        MyHashMap solution = new MyHashMap();

        solution.put(1, 10);
        solution.put(2, 20);
        System.out.println(solution.get(1));       // 10
        System.out.println(solution.get(2));       // 20
        System.out.println(solution.get(3));       // -1

        solution.put(2, 200);
        System.out.println(solution.get(2));       // 200

        solution.put(1001, 30);
        solution.put(2001, 40);
        System.out.println(solution.get(1001));    // 30
        System.out.println(solution.get(2001));    // 40

        solution.remove(1001);
        System.out.println(solution.get(1001));    // -1
        System.out.println(solution.get(1));       // 10
        System.out.println(solution.get(2001));    // 40

        solution.remove(2001);
        System.out.println(solution.get(2001));    // -1
        System.out.println(solution.get(1));       // 10

        solution.remove(1);
        System.out.println(solution.get(1));       // -1

        solution.remove(999);
        System.out.println(solution.get(999));     // -1
    }
}
