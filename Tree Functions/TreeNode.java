public class TreeNode {
    TreeNode left, right;
    Object value;

    public TreeNode(TreeNode left, TreeNode right, Object value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Object getValue() { return value; }
    public void setValue(Object value) { this.value = value; }

    public TreeNode getRight() { return right; }
    public TreeNode getLeft() { return left; }
}