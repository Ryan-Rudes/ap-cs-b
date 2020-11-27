public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private String value;

    public TreeNode(String value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode(String value) {
        this.value = value;
    }

    public String getValue() { return value; }
    public String setValue(String value) {
        this.value = value;
        return this;
    }

    public TreeNode getRight() { return right; }
    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }

    public TreeNode getLeft() { return left; }
    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public boolean isLeaf() { return left == null && right == null; }
    public boolean isComplete() { return left != null && right != null; }
    public int children() { return (left == null ? 0 : 1) + (right == null ? 0 : 1); }
}