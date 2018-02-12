/* This algorithm is to implement postOrder traversal of a tree using one stack. 
First, push root into stack, mark it as curcode;

Then, check if cur has right child, if does, then push its right child, mark cur as parent node, update cur node's right 
child to cur node, continue this loop until cur doesn't have a right child;

Then go back to parent node, if parent exits and parent has left child, then recursively call the algorithm, pass parent's 
left child as parameter.

Finally, the stack is built up.

The example tree is as following: the expected printed results is 7 8 4 5 3 1 
     1
    / \
   2   3
      / \
     4   5
    / \
   7   8

*/        
         
public class postOrderTraversal {

    public static void main(String[] args) {
        // write your code here
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        ArrayList<Integer> list = s.StackList(root);
        for (int i = 0 ; i < list.size(); i++) System.out.print(list.get(i) + " ");
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
    public void postOrder(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        TreeNode parent = null; // for the footprint of cur, mark each of its step as parent node, in order to conveniently get 
        s.push(cur);            // back whenever cur reaches null.
        while (cur.right != null) {
            s.push(cur.right);
            parent = cur;
            cur = cur.right;
        }
       // add parent != null, otherwise it throws nullpoint exception
        if (parent != null && parent.left != null) {
            postOrder(parent.left);
        }
    }
    public ArrayList<Integer> StackList(TreeNode root) {
        postOrder(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            list.add(node.val);
        }
        return list;
    }
}
