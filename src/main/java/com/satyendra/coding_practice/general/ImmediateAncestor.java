package general;

public class ImmediateAncestor {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(9);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.left = new Node(3);
        root.right.right = new Node(7);
        root.left.left.left = new Node(4);
        root.left.left.right = new Node(6);
        System.out.println(findImmediateAncestor(root, 4).val);
        System.out.println(findImmediateAncestor(root, 2).val);
        System.out.println(findImmediateAncestor(root, 9).val);
    }

    private static Node findImmediateAncestor(Node root, int val) {
        if(root == null) {
            return null;
        }
        if(root.left.val == val || root.right.val == val) {
            return root;
        }
        findImmediateAncestor(root.left, val);
        findImmediateAncestor(root.right, val);
        return null;
    }

    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }
}
