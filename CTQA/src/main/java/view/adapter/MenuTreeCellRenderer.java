package view.adapter;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class MenuTreeCellRenderer implements TreeCellRenderer {

    JLabel lable = new JLabel(" ");
    JPanel renderer = new JPanel();
    DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
    Color backgroundSelectionColor;
    Color backgroundNonSelectionColor;

    public MenuTreeCellRenderer() {
        renderer.add(lable);
        renderer.setBackground(new Color(1f, 0f, 0f, .0f));
        renderer.setForeground(new Color(1f, 0f, 0f, .0f));

        //renderer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        backgroundSelectionColor = defaultRenderer.getBackgroundSelectionColor();
        backgroundNonSelectionColor = defaultRenderer.getBackgroundNonSelectionColor();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if ((value != null) && (value instanceof DefaultMutableTreeNode)) {
            Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
            if (userObject instanceof String) {
                lable.setText(userObject.toString() + "");
                if (selected) {
                    //renderer.setBackground(backgroundSelectionColor);
                    lable.setForeground(Color.decode("#3399FF"));
                    lable.setFont(new Font("TimesRoman", Font.BOLD, 14));
                } else {
                    //renderer.setBackground(backgroundNonSelectionColor);
                    lable.setForeground(Color.BLACK);
                    lable.setFont(new Font("TimesRoman", Font.PLAIN, 14));
                }
                renderer.setEnabled(tree.isEnabled());
            }
        }

        return renderer;

    }

}
