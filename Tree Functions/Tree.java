import static java.lang.Math.*;

public class Tree {
    private TreeNode root;

    public Tree(String value) {
        this.root = new TreeNode(value);
    }

    public Tree(TreeNode root) {
        this.root = root;
    }

    public Tree() {}
 
    public boolean contains(String target) {
        return contains(root, target);
    }

    private boolean contains(TreeNode root, String target) {
        if (root == null) {
            return false;
        } else {
            int comparison = target.compareTo(root.getValue());
        
            if (comparison == 0)
                return true;
            else if (comparison < 0)
                return contains(root.getLeft(), target);
            else
                return contains(root.getRight(), target);
        }
    }

    public TreeNode find(String target) {
        return find(root, target);
    }

    private TreeNode find(TreeNode root, String target) {
        if (root == null) {
            return null;
        } else {
            int comparison = target.compareTo(root.getValue());
        
            if (comparison == 0)
                return root;
            else if (comparison < 0)
                return find(root.getLeft(), target);
            else
                return find(root.getRight(), target);
        }
    }

    private String traversePreorder(TreeNode root) {
        return root == null ? "" : root.getValue() + " " + traversePreorder(root.getLeft()) + " " + traversePreorder(root.getRight());
    }

    public String traversePreorder() {
        return traversePreorder(root).replaceAll("( )+", " ");
    }

    private String traverseInorder(TreeNode root) {
        return root == null ? "" : traversePreorder(root.getLeft()) + " " + root.getValue() + " " + traversePreorder(root.getRight());
    }

    public String traverseInorder() {
        return traverseInorder(root).replaceAll("( )+", " ");
    }

    private String traversePostorder(TreeNode root) {
        return root == null ? "" : traversePreorder(root.getLeft()) + " " + traversePreorder(root.getRight()) + " " + root.getValue();
    }

    public String traversePostorder() {
        return traversePostorder(root).replaceAll("( )+", " ");
    }

    private int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if (root.getLeft() == null && root.getRight() == null)
                return 1;
            else
                return countLeaves(root.getLeft()) + countLeaves(root.getRight());
        }
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    public Tree copy() {
        return new Tree(copy(root));
    }

    private TreeNode copy(TreeNode root) {
        return root == null ? null : new TreeNode(root.getValue(), root.getLeft(), root.getRight());
    }

    private TreeNode add(TreeNode root, String value) {
        if (root == null) {
            return new TreeNode(value);
        } else {
            int comparison = value.compareTo(root.getValue());

            if (comparison < 0)
                return root.setLeft(add(root.getLeft(), value));
            else if (comparison > 0)
                return root.setRight(add(root.getRight(), value));
            else
                return root;
        }
    }

    public void add(String value) {
        root = add(root, value);
    }

    private int getHeight(TreeNode root) {
        return root == null ? 0 : max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getWidth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftWidth = getWidth(root.getLeft());
            int rightWidth = getWidth(root.getRight());
            int longestPath = getHeight(root.getLeft()) + getHeight(root.getRight()) + 1;
            return max(max(leftWidth, rightWidth), longestPath);
        }
    }

    public int getWidth() {
        return getWidth(root);
    }

    public void clear() {
        root = null;
    }

    public boolean isAncestor(String ancestor, String descendant) {
        return contains(find(ancestor), descendant);
    }

    public void fill(String data) {
        for (int i = 0; i < data.length(); i++) {
            add(Character.toString(data.charAt(i)));
        }
    }

    private TreeNode deleteLeaf(TreeNode root, String value) {
        if (root == null) {
            return null;
        } else {
            int comparison = value.compareTo(root.getValue());

            if (comparison < 0) {
                return root.setLeft(deleteLeaf(root.getLeft(), value));
            } else if (comparison > 0) {
                return root.setRight(deleteLeaf(root.getRight(), value));
            } else { // comparison == 0
                return root.isLeaf() ? null : root;
            }
        }
    }

    public void deleteLeaf(String value) {
        root = deleteLeaf(root, value);
    }

    private TreeNode deleteNode(TreeNode root, String value) {
        if (root == null)
            return null;
        
        int comparison = value.compareTo(root.getValue());

        if (comparison < 0) {
            return root.setLeft(deleteNode(root.getLeft(), value));
        } else if (comparison > 0) {
            return root.setRight(deleteNode(root.getRight(), value));
        } else { // comparison == 0
            if (root.isComplete()) {
                TreeNode node = root;
                node = node.getRight();
                while (node.getLeft() != null) {
                    node = node.getLeft();
                }
                root.setValue(node.getValue());

                return root;
            } else {
                return root.getLeft() == null ? root.getLeft() : root.getRight();
            }
        }
    }

    public void deleteNode(String value) {
        root = deleteNode(root, value);
    }
}