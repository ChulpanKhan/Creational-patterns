
package com.mycompany.laba2.GUI;

import com.mycompany.laba2.Ork;
import com.mycompany.laba2.OrkBuilder;
import com.mycompany.laba2.OrkBuilderFactory;
import com.mycompany.laba2.OrkDirector;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class OrkArmyBuilderGUI extends JFrame{
    
    private static final Color PARCHMENT = new Color(248, 240, 227);
    private static final Color DARK_BROWN = new Color(61, 43, 31);
    private static final Color BLOOD_RED = new Color(139, 0, 0);
    private static final Color ANCIENT_GOLD = new Color(212, 175, 55);
    
    private Font palatino;
    private Font palatinoBold;
    private Font palatinoLarge;
    
    private DefaultMutableTreeNode armyRoot;
    private JTree armyTree;
    private JPanel infoPanel;
    private final OrkBuilderFactory builderFactory = new OrkBuilderFactory();
    private final OrkDirector director = new OrkDirector();
    
    public OrkArmyBuilderGUI() {
        setupFonts();
        setupMainWindow();
        initUIComponents();
    }
    
    private void setupFonts() {
        palatino = createFont("Palatino Linotype", Font.PLAIN, 16);
        palatinoBold = palatino.deriveFont(Font.BOLD, 16);
        palatinoLarge = palatino.deriveFont(Font.BOLD, 24);
    }
    
    private Font createFont(String preferredName, int style, int size) {
        Font font = new Font(preferredName, style, size);
        if (!font.getFamily().equals(preferredName)) {
            font = new Font("Serif", style, size); // если чтото пошло не так со шрифтом
        }
        return font;
    }
    
    private void setupMainWindow() {
        setTitle("Сбор Армии");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(PARCHMENT);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);
    }
    
    private void initUIComponents() {
        //Панель армии (левая часть)
        JPanel armyPanel = new JPanel(new BorderLayout());
        armyPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 5));
        armyPanel.setBackground(PARCHMENT);
        
        JLabel armyTitle = new JLabel("Армия Мордора", SwingConstants.CENTER);
        armyTitle.setFont(palatinoLarge);
        armyTitle.setForeground(DARK_BROWN);
        armyTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, ANCIENT_GOLD));
        
        armyRoot = new DefaultMutableTreeNode("Войска Саурона");
        armyTree = new JTree(armyRoot);
        styleTree(armyTree);
        
        armyPanel.add(armyTitle, BorderLayout.NORTH);
        armyPanel.add(new JScrollPane(armyTree), BorderLayout.CENTER);
        
        //Панель информации (центральная часть)
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));
        infoPanel.setBackground(PARCHMENT);
        
        //Панель управления (нижняя часть)
        JPanel controlPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        controlPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(2, 0, 0, 0, ANCIENT_GOLD),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        controlPanel.setBackground(DARK_BROWN);
        
        // Компоненты управления
        JComboBox<String> tribeCombo = createStyledComboBox(new String[]{"Мордор", "Дол Гулдур", "Мглистые Горы"});
        JComboBox<String> roleCombo = createStyledComboBox(new String[]{"Базовый", "Командир", "Разведчик"});
        JButton createButton = createStyledButton("Призвать Орка");
        
        createButton.addActionListener(e -> {
            String tribe = (String) tribeCombo.getSelectedItem();
            String role = (String) roleCombo.getSelectedItem();
            
            OrkBuilder builder = builderFactory.createOrkBuilder(tribe);
            Ork ork = createOrkByRole(builder, role);
            
            if (ork != null) {
                addOrkToTree(ork);
            }
        });
        
        controlPanel.add(tribeCombo);
        controlPanel.add(roleCombo);
        controlPanel.add(createButton);
        
        // Добавление компонентов в главное окно
        add(armyPanel, BorderLayout.WEST);
        add(new JScrollPane(infoPanel), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        
        WelcomeMessageGUI.showWelcomeMessage(infoPanel, palatino, DARK_BROWN);
        // Обработчик выбора в дереве
        armyTree.addTreeSelectionListener(e -> updateInfoPanel());
    }
    private void styleTree(JTree tree) {
        tree.setFont(palatino);
        tree.setBackground(PARCHMENT);
        tree.setRowHeight(25);
        
        // Кастомный рендерер для узлов дерева
        tree.setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, 
                    boolean expanded, boolean leaf, int row, boolean hasFocus) {
                super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
                setFont(palatino);
                setBackgroundNonSelectionColor(PARCHMENT);
                setBackgroundSelectionColor(ANCIENT_GOLD);
                setTextSelectionColor(DARK_BROWN);
                setTextNonSelectionColor(DARK_BROWN);
                return this;
            }
        });
    }
    
    private JComboBox<String> createStyledComboBox(String[] items) {
        JComboBox<String> combo = new JComboBox<>(items);
        combo.setFont(palatino);
        combo.setBackground(PARCHMENT);
        combo.setForeground(DARK_BROWN);
        combo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ANCIENT_GOLD, 1),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return combo;
    }
    
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(palatinoBold);
        button.setBackground(ANCIENT_GOLD);
        button.setForeground(DARK_BROWN);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createRaisedBevelBorder(),
            BorderFactory.createEmptyBorder(8, 20, 8, 20)
        ));
        button.setFocusPainted(false);
        
        // Эффект при наведении
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(BLOOD_RED);
                button.setForeground(Color.WHITE);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(ANCIENT_GOLD);
                button.setForeground(DARK_BROWN);
            }
        });
        
        return button;
    }
    
    private Ork createOrkByRole(OrkBuilder builder, String role) {
        switch (role) {
            case "Базовый": return director.createBasicOrk(builder);
            case "Командир": return director.createLeaderOrk(builder);
            case "Разведчик": return director.createScoutOrk(builder);
            default: return null;
        }
    }
    
    private void addOrkToTree(Ork ork) {
        DefaultMutableTreeNode tribeNode = findOrCreateTribeNode(ork.getTribe());
        tribeNode.add(new DefaultMutableTreeNode(ork));
        ((DefaultTreeModel) armyTree.getModel()).reload();
        expandAllTreeNodes();
    }
    
    private DefaultMutableTreeNode findOrCreateTribeNode(String tribeName) {
        for (int i = 0; i < armyRoot.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) armyRoot.getChildAt(i);
            if (node.getUserObject().toString().equals(tribeName)) {
                return node;
            }
        }
        
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(tribeName);
        armyRoot.add(newNode);
        return newNode;
    }
    
    private void expandAllTreeNodes() {
        for (int i = 0; i < armyTree.getRowCount(); i++) {
            armyTree.expandRow(i);
        }
    }
    
    private void updateInfoPanel() {
        infoPanel.removeAll();
        
        TreePath selectedPath = armyTree.getSelectionPath();
        if (selectedPath == null) {
            // Больше не показываем welcomeMessage при снятии выбора
            infoPanel.revalidate();
            infoPanel.repaint();
            return;
        }
        
        Object selected = ((DefaultMutableTreeNode) selectedPath.getLastPathComponent()).getUserObject();
        
        if (selected instanceof Ork ork) {
            createOrkInfoCard(ork);
        }         
        infoPanel.revalidate();
        infoPanel.repaint();
    
    }
    
    private void createOrkInfoCard(Ork ork) {
        // Основная карточка
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(ANCIENT_GOLD, 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.setBackground(PARCHMENT);
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Заголовок с именем
        JLabel nameLabel = new JLabel(ork.getName());
        nameLabel.setFont(palatinoLarge);
        nameLabel.setForeground(BLOOD_RED);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Подзаголовок с племенем и ролью
        JLabel tribeRoleLabel = new JLabel(ork.getTribe() + " • " + ork.getRole());
        tribeRoleLabel.setFont(palatinoBold);
        tribeRoleLabel.setForeground(DARK_BROWN);
        tribeRoleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Разделитель
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setForeground(ANCIENT_GOLD);
        separator.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Панель характеристик
        JPanel statsPanel = createStatsPanel(ork);
        
        // Панель снаряжения
        JPanel equipmentPanel = createEquipmentPanel(ork);
        
        // Сборка карточки
        card.add(nameLabel);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(tribeRoleLabel);
        card.add(Box.createRigidArea(new Dimension(0, 15)));
        card.add(separator);
        card.add(Box.createRigidArea(new Dimension(0, 20)));
        card.add(statsPanel);
        card.add(Box.createRigidArea(new Dimension(0, 20)));
        card.add(equipmentPanel);
        
        infoPanel.add(card);
    }
    
    private JPanel createStatsPanel(Ork ork) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(DARK_BROWN, 1),
            "Характеристики",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            palatinoBold,
            DARK_BROWN
        ));
        panel.setBackground(PARCHMENT);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        panel.add(createStatBar("Сила", ork.getStrength(), ANCIENT_GOLD));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(createStatBar("Ловкость", ork.getAgility(), ANCIENT_GOLD));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(createStatBar("Интеллект", ork.getIntelligence(), ANCIENT_GOLD));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(createStatBar("Здоровье", ork.getHealth(), ANCIENT_GOLD));
        
        return panel;
    }
    
    private JPanel createStatBar(String label, int value, Color color) {
        JPanel panel = new JPanel(new BorderLayout(10, 0));
        panel.setBackground(PARCHMENT);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel nameLabel = new JLabel(label);
        nameLabel.setFont(palatino);
        nameLabel.setForeground(DARK_BROWN);
        nameLabel.setPreferredSize(new Dimension(100, 20));
        
        JProgressBar bar = new JProgressBar(0, label.equals("Здоровье") ? 200 : 100);
        bar.setValue(value);
        bar.setStringPainted(true);
        bar.setForeground(color);
        bar.setBackground(new Color(220, 220, 220));
        bar.setString(String.valueOf(value));
        bar.setFont(palatino);
        bar.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        
        panel.add(nameLabel, BorderLayout.WEST);
        panel.add(bar, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createEquipmentPanel(Ork ork) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(DARK_BROWN, 1),
            "Снаряжение",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            palatinoBold,
            DARK_BROWN
        ));
        panel.setBackground(PARCHMENT);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        panel.add(createEquipmentItem("Оружие", ork.getWeapon().getDescription()));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(createEquipmentItem("Броня", ork.getArmor().getDescription()));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(createEquipmentItem("Знамя", ork.getBanner().getDescription()));

        
        return panel;
    }
    
    private JPanel createEquipmentItem(String name, String description) {
        JPanel panel = new JPanel(new BorderLayout(10, 0));
        panel.setBackground(PARCHMENT);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel nameLabel = new JLabel(name + ":");
        nameLabel.setFont(palatinoBold);
        nameLabel.setForeground(DARK_BROWN);
        
        JLabel descLabel = new JLabel(description);
        descLabel.setFont(palatino);
        descLabel.setForeground(DARK_BROWN);
        
        panel.add(nameLabel, BorderLayout.WEST);
        panel.add(descLabel, BorderLayout.CENTER);
        
        return panel;
    }
    

    
    
}
