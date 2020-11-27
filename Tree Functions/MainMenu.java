import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class MainMenu implements ActionListener {
  Tree tree;
  Reader reader = new Reader();

  public MainMenu() {
    this.tree = new Tree();

    // Setup
    JFrame f = new JFrame("Tree Functions");
    f.setSize(600, 200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuBar menu = new JMenuBar();

    ActionListener select = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
    
        switch (command) {
          case "Preorder":
            System.out.println("(2): " + tree.traversePreorder());
            break;
          case "Inorder":
            System.out.println("(3): " + tree.traverseInorder());
            break;
          case "Postorder":
            System.out.println("(4): " + tree.traversePostorder());
            break;
          case "Nodes":
            System.out.println("(5): " + tree.countNodes());
            break;
          case "Leaves":
            System.out.println("(6): " + tree.countLeaves());
            break;
          case "Height":
            System.out.println("(7): " + tree.getHeight());
            break;
          case "Width":
            System.out.println("(8): " + tree.getWidth());
            break;
          case "Clear":
            tree.clear();
            System.out.println("(9): Cleared tree");
            break;
          default:
            break;
        }
      }
    };

    // Fill
    JMenu fill = new JMenu("Fill");
    JTextField filepathField = new JTextField(20);
    ActionListener filepathEnter = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        String filepath = filepathField.getText();
        String data = reader.read(filepath);
        tree.fill(data);
        System.out.println("(1): " + data);
      }
    };
    filepathField.addActionListener(filepathEnter);
    fill.add(filepathField);

    // Traversals
    JMenu traversals = new JMenu("Traversals");
    JMenuItem preorder = new JMenuItem("Preorder");
    JMenuItem inorder = new JMenuItem("Inorder");
    JMenuItem postorder = new JMenuItem("Postorder");
    preorder.addActionListener(select);
    inorder.addActionListener(select);
    postorder.addActionListener(select);
    traversals.add(preorder);
    traversals.add(inorder);
    traversals.add(postorder);

    // Count
    JMenu count = new JMenu("Count");
    JMenuItem countNodes = new JMenuItem("Nodes");
    JMenuItem countLeaves = new JMenuItem("Leaves");
    countNodes.addActionListener(select);
    countLeaves.addActionListener(select);
    count.add(countNodes);
    count.add(countLeaves);

    // Size
    JMenu size = new JMenu("Size");
    JMenuItem height = new JMenuItem("Height");
    JMenuItem width = new JMenuItem("Width");
    height.addActionListener(select);
    width.addActionListener(select);
    size.add(height);
    size.add(width);

    // Edit
    JMenu edit = new JMenu("Edit");
    JMenu addNode = new JMenu("Add");
    JTextField addNodeField = new JTextField(10);
    ActionListener addNodeEnter = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        String value = addNodeField.getText();
        System.out.println(String.format("Adding a node with the value %s", value));
        tree.add(value);
      }
    };
    addNodeField.addActionListener(addNodeEnter);
    addNode.add(addNodeField);
    JMenu delete = new JMenu("Delete");
    JMenu deleteLeaf = new JMenu("Leaf");
    JTextField deleteLeafField = new JTextField(10);
    ActionListener deleteLeafEnter = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        String value = deleteLeafField.getText();
        tree.deleteLeaf(value);
        System.out.println("(11): Delete leaf node with value " + value);
      }
    };
    deleteLeafField.addActionListener(deleteLeafEnter);
    deleteLeaf.add(deleteLeafField);
    JMenu deleteNode = new JMenu("Node");
    JTextField deleteNodeField = new JTextField(10);
    ActionListener deleteNodeEnter = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        String value = deleteNodeField.getText();
        tree.deleteNode(value);
        System.out.println("(12): Delete node with value " + value);
      }
    };
    deleteNodeField.addActionListener(deleteNodeEnter);
    deleteNode.add(deleteNodeField);
    delete.add(deleteLeaf);
    delete.add(deleteNode);
    JMenuItem clear = new JMenuItem("Clear");
    clear.addActionListener(select);
    edit.add(addNode);
    edit.add(delete);
    edit.add(clear);

    // Relatives
    JMenu relate = new JMenu("Relate");
    JPopupMenu isAncestor = relate.getPopupMenu();
    isAncestor.setLayout(new GridLayout(1, 3));
    JTextField ancestorTextField = new JTextField();
    JTextField descendantTextField = new JTextField();
    JTextField text = new JTextField();
    text.setText("is ancestor of");
    text.setEditable(false);
    isAncestor.add(ancestorTextField);
    isAncestor.add(text);
    isAncestor.add(descendantTextField);
    ActionListener computeAncestry = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        String ancestor = ancestorTextField.getText();
        String descendant = descendantTextField.getText();
        boolean yes = tree.isAncestor(ancestor, descendant);
        System.out.println("(10): " + String.format("%s, %s is%s an ancestor of %s", yes ? "Yes" : "No", ancestor, yes ? "" : " not", descendant));
      }
    };
    ancestorTextField.addActionListener(computeAncestry);
    descendantTextField.addActionListener(computeAncestry);

    JMenuItem quit = new JMenuItem("Quit");
    quit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.out.println("(-1): Quit");
        System.exit(0);
      }
    });

    menu.add(fill);
    menu.add(traversals);
    menu.add(count);
    menu.add(size);
    menu.add(edit);
    menu.add(relate);
    menu.add(quit);

    f.setJMenuBar(menu);
    f.setVisible(true);
  }

  public static void main(String[] args) {
    new MainMenu();
  }
}
