// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    
    // Function to check if a binary tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        // Use a helper function to check symmetry between the left and right subtrees
        return isMirror(root.left, root.right);
    }
    
    // Helper function to check if two trees are mirror images of each other
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both trees are null, they are mirror images
        if (t1 == null && t2 == null) {
            return true;
        }
        
        // If one tree is null and the other is not, they are not mirror images
        if (t1 == null || t2 == null) {
            return false;
        }
        
        // Check if the current nodes are equal and recursively check their children
        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: [1, 2, 2, 3, 4, 4, 3]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        System.out.println(solution.isSymmetric(root1)); // Output: true

        // Test Case 2: [1, 2, 2, null, 3, null, 3]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println(solution.isSymmetric(root2)); // Output: false
    }
}
