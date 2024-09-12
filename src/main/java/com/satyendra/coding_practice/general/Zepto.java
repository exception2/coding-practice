package general;

public class Zepto {

    public static void main(String[] args) {
        Zepto zepto = new Zepto();
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        Node res = zepto.findLCA(root, 6, 4);
        System.out.println(res != null ? res.val : -1);
    }

    private Node findLCA(Node root, int num1, int num2) {
        if(root == null) return null;
        if(root.val == num1 || root.val == num2) {
            return root;
        }
        Node left_lca = findLCA(root.left, num1, num2);
        Node right_lca = findLCA(root.right, num1, num2);
        if(left_lca != null && right_lca != null) {
            return root;
        }
        return left_lca != null ? left_lca : right_lca;
    }

    static class Node {
        Node left,right;
        int val;
        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
