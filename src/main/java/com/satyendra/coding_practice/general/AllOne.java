package general;

import java.util.HashMap;
import java.util.Map;


class AllOne {
    // +hello , +hello , max , min, +ruby , max , min , -hello , max , min
    private Node startDeque;
    private Node endDeque;
    Map<String, Node> map;

    public AllOne() {
        map = new HashMap<>();
        startDeque = endDeque = null;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.count++;
            map.put(key, node);
            if (node.prev == null) {
                return;
            }
            Node current = node;
            while (current.prev != null && node.count > current.prev.count) {
                current = current.prev;
            }
            // swap x <-> y <-> z
            if (!node.key.equals(current.key)) {
                String tempKey = node.key;
                int tempCount = node.count;
                node.key = current.key;
                node.count = current.count;
                current.key = tempKey;
                current.count = tempCount;
                map.put(node.key, node);
                map.put(current.key, current);
            }
        } else {
            Node node = new Node(key, 1);
            map.put(key, node);
            if (startDeque == null && endDeque == null) {
                startDeque = endDeque = node;
            } else {
                endDeque.next = node;
                node.prev = endDeque;
                endDeque = node;
            }
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        if (node.count == 1) {
            if (node.next == null && node.prev == null) {
                startDeque = endDeque = null;
            } else if (node.next == null) {
                Node prev = node.prev;
                endDeque = prev;
                prev.next = null;
            } else if (node.prev == null) {
                Node next = node.next;
                startDeque = next;
                next.prev = null;
            } else {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
            }
            map.remove(key);
        } else {
            node.count--;
            if (node.next == null) {
                return;
            }
            Node current = node;
            while (current.next != null && node.count < current.next.count) {
                current = current.next;
            }
            // swap x <-> y <-> z
            if (!node.key.equals(current.key)) {
                String tempKey = node.key;
                int tempCount = node.count;
                node.key = current.key;
                node.count = current.count;
                current.key = tempKey;
                current.count = tempCount;
                map.put(node.key, node);
                map.put(current.key, current);
            }
        }
    }

    public String getMaxKey() {
        return startDeque == null ? "" : startDeque.key;
    }

    public String getMinKey() {
        return endDeque == null ? "" : endDeque.key;
    }

    public void printMap() {
        System.out.println("Map:");
        for (Map.Entry<String, Node> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().count);
        }
    }

    static class Node {
        String key;
        int count;
        Node prev, next;

        Node(String key, int count) {
            this.key = key;
            this.count = count;
            prev = next = null;
        }
    }

    public static void main(String[] args) {
        AllOne obj = new AllOne();
        obj.inc("hello");
        obj.inc("hello");
        obj.printMap();
        System.out.println("Max key : " + obj.getMaxKey());
        System.out.println("Min key : " + obj.getMinKey());
        obj.inc("ruby");
        obj.printMap();
        System.out.println("Max key : " + obj.getMaxKey());
        System.out.println("Min key : " + obj.getMinKey());
        obj.inc("satyendra");
        obj.inc("satyendra");
        obj.inc("satyendra");
        obj.dec("hello");
        obj.dec("hello");
        obj.printMap();
        System.out.println("Max key : " + obj.getMaxKey());
        System.out.println("Min key : " + obj.getMinKey());
        obj.dec("ruby");
        obj.printMap();
        System.out.println("Max key : " + obj.getMaxKey());
        System.out.println("Min key : " + obj.getMinKey());
    }
}
