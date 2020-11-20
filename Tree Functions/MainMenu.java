import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenu implements ActionListener {
  public MainMenu() {
    // Create the frame
    JFrame f = new JFrame("Tree Functions");
    f.setSize(600, 200);

    // Create the menu bar
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuBar menu = new JMenuBar();

    // Create the menu items
    JMenu fill = new JMenu("Fill");

    JMenu traversal = new JMenu("Traversal");
    JMenuItem preorder = new JMenuItem("Preorder");
    JMenuItem inorder = new JMenuItem("Inorder");
    JMenuItem postorder = new JMenuItem("Postorder");
    traversal.add(preorder);
    traversal.add(inorder);
    traversal.add(postorder);

    JMenu count = new JMenu("Count Nodes");
    JMenuItem count_nodes = new JMenuItem("Nodes");
    JMenuItem count_leaves = new JMenuItem("Leaves");
    count.add(count_nodes);
    count.add(count_leaves);

    JMenu size = new JMenu("Size");
    JMenuItem height = new JMenuItem("Height");
    JMenuItem width = new JMenuItem("Width");
    size.add(height);
    size.add(width);

    JMenu clear = new JMenu("Clear");
    JMenu is_descendant = new JMenu("Is Descendant");

    JMenu delete = new JMenu("Delete");
    JMenuItem delete_leaves = new JMenuItem("Count");
    JMenuItem delete_node = new JMenuItem("Node");
    delete.add(delete_leaves);
    delete.add(delete_node);

    JMenu quit = new JMenu("Quit");

    // Add items to menu
    menu.add(fill);
    menu.add(traversal);
    menu.add(count);
    menu.add(size);
    menu.add(clear);
    menu.add(is_descendant);
    menu.add(delete);
    menu.add(quit);

    // Make the view visible
    f.setJMenuBar(menu);
    f.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae) {
    String comStr = ae.getActionCommand();
    System.out.println(comStr + " Selected");
  }

  public static void main(String args[]) {
    new MainMenu();
  }
}
