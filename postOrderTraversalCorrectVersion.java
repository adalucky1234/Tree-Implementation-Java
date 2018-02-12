/**
for this version, we implement post Order Traversal of tree using one stack, simply just recursively push current root node, 
then push its right subtree, then recursively push its left subtree.
*/



public class postOrderTraversalCorrectVersion {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        //ArrayList<Integer> list = s.StackList(root);
        solution.postOrderTraversal(root);
        while (!solution.s.isEmpty()) {
            TreeNode t = solution.s.pop();
            solution.list.add(t.val);
        }
        for (int i = 0 ; i < solution.list.size(); i++) System.out.print(solution.list.get(i) + " ");
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {
    Stack<TreeNode> s = new Stack<>();
    ArrayList<Integer> list = new ArrayList<>();

    public void postOrderTraversal(TreeNode root) {
        if(root == null) return;
        s.push(root);
        if (root.right != null) {
            postOrderTraversal(root.right);
        }
        if (root.left != null) {
            postOrderTraversal(root.left);
        }
    }
}
