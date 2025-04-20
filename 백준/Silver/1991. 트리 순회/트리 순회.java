import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node {
    char value;
    Node left;
    Node right;

    Node(char value) {
        this.value = value;
    }
}

public class Main {
    static Map<Character, Node> tree = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // 개행문자 처리

        for (int i = 0; i < n; i++) {
            char root = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);

            if (!tree.containsKey(root)) {
                tree.put(root, new Node(root));
            }
            Node current = tree.get(root);

            if (left != '.') {
                current.left = new Node(left);
                tree.put(left, current.left);
            }

            if (right != '.') {
                current.right = new Node(right);
                tree.put(right, current.right);
            }
        }

        // 전위 순회
        preorder(tree.get('A'));
        System.out.println();

        // 중위 순회
        inorder(tree.get('A'));
        System.out.println();

        // 후위 순회
        postorder(tree.get('A'));
        System.out.println();

        sc.close();
    }

    // 전위 순회
    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}
