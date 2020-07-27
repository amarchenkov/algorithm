package root;

/**
 * The lowest common ancestor between two nodes n1 and n2 is defined as
 * the lowest node in T that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).
 * The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root.
 */
public class LeastCommonAncestor {

    /**
     * The idea is to traverse the tree starting from root.
     * If any of the given keys (value1 and value2) matches with root, then root is LCA (assuming that both keys are present).
     * If root doesn’t match with any of the keys, we recur for left and right subtree.
     * The node which has one key present in its left subtree and the other key present in right subtree is the LCA.
     * If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.
     *
     * @param root   Current element
     * @param value1 First value
     * @param value2 Second value
     * @return Node which is LCA for value1 and value2
     */
    static Node lca(Node root, int value1, int value2) {
        if (root == null) {
            return null;
        }

        if (root.data == value1 || root.data == value2) {
            return root;
        }

        Node leftLca = lca(root.left, value1, value2);
        Node rightLca = lca(root.right, value1, value2);

        if (leftLca != null && rightLca != null) {
            return root;
        }

        return (leftLca != null) ? leftLca : rightLca;
    }

    public static void main(String[] args) {
        var root = new Node(4);
        var l1 = new Node(2);
        var r1 = new Node(7);
        var l2 = new Node(1);
        var r2 = new Node(3);
        var l21 = new Node(6);

        root.left = l1;
        root.right = r1;

        r1.left = l21;

        l1.left = l2;
        l1.right = r2;

        System.out.println("LCA - " + lca(root, 1, 7).data);
    }

}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}
