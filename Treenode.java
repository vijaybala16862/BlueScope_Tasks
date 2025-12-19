class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
    public static int minPathSum(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        if (root.left == null && root.right == null)
            return root.val;

        int leftSum = minPathSum(root.left);
        int rightSum = minPathSum(root.right);

        return root.val + Math.min(leftSum, rightSum);
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(-1);
        System.out.println(minPathSum(root));  
    }
}