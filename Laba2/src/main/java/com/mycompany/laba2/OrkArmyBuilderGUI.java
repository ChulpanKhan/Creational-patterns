
package com.mycompany.laba2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class OrkArmyBuilderGUI extends JFrame{
    private DefaultMutableTreeNode armyRoot;
    private JTree armyTree;
    private JPanel infoPanel;
    private final OrkBuilderFactory builderFactory = new OrkBuilderFactory();
    private final OrkDirector director = new OrkDirector();
    
    public OrkArmyBuilderGUI() {
        setTitle("Сборщик армии Саурона");
    }
}
