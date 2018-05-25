import javax.swing.*;
import java.awt.*;

public class CentralHub {
    //creating jpanels and jlabels
    private JPanel hubNamePanel, hubButtonPanel, background;
    private JLabel hubNameLabel, hubShadowLabel, hubBackground;

    //setting the names for the buttons and creating the array of buttons that would be added to the panel
    private final String menuNames[] = {"DUNGEONS", "EXIT"};
    private final JButton menuButtons[] = new JButton[menuNames.length];

    //setting fonts
    private final Font titleFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 50);
    private final Font menuFontHover = new Font("Copperplate Gothic Bold", Font.PLAIN, 24);
    private final Font menuFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 14);

    //initializer
    public CentralHub(GameController.CentralHubHandler chHandler) {
        init(chHandler);
    }
    
    //initializing function
    private void init(GameController.CentralHubHandler chHandler) {
        initJPanels();
        initJLabels();
        initJButtons(chHandler);
    }
    
    private void initJPanels() {
        //background panel
        background = new JPanel();
        background.setBounds(0, 0, 800, 600);
        background.setBackground(Color.black);
        
        //title panel
        hubNamePanel = new JPanel(null);
        hubNamePanel.setBounds(80, 100, 800, 100); // setBounds(x,y,width,height);
        hubNamePanel.setBackground(Color.black);
        hubNamePanel.setOpaque(false);
        
        //button panel
        hubButtonPanel = new JPanel();
        hubButtonPanel.setBounds(300, 300, 200, 150);
        hubButtonPanel.setBackground(Color.black);
        hubButtonPanel.setOpaque(false);
        hubButtonPanel.setLayout(new GridLayout(2, 1, 0, 20)); // GridLayout(row, col, colgap, rowgap);
    }
    
    private void initJLabels() {
        //background label
        hubBackground = new JLabel();
        hubBackground.setBounds(0, 0, 800, 600);
        ImageIcon backgroundImg = new ImageIcon(getClass().getClassLoader().getResource("res/background/moutainBackground.png"));
        hubBackground.setIcon(backgroundImg);
        background.add(hubBackground);
        
        //title label
        hubNameLabel = new JLabel("Central Hub");
        hubNameLabel.setForeground(Color.white);
        hubNameLabel.setFont(titleFont);
        hubNameLabel.setBounds(135, 0, 800, 100);
        hubNamePanel.add(hubNameLabel);
        
        //title shadow label
        hubShadowLabel = new JLabel("Central Hub");
        hubShadowLabel.setForeground(Color.black);
        hubShadowLabel.setFont(titleFont);
        hubShadowLabel.setBounds(143, 5, 800, 100);
        hubNamePanel.add(hubShadowLabel);
    }
    
    private void initJButtons(GameController.CentralHubHandler chHandler) {
        //for the buttons
        for (int i = 0; i < menuButtons.length; i++) {
            JButton btn = new JButton(menuNames[i]);
            btn.setActionCommand("hub" + i);
            btn.addActionListener(chHandler);
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setFont(menuFontHover);
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setFont(menuFont);
                }
            });
            //btn.setBorder(null);
            btn.setBackground(Color.lightGray);
            btn.setForeground(Color.white);
            btn.setFont(menuFont);
            btn.setFocusPainted(false);
            btn.setOpaque(false);
            btn.setBorderPainted(false);
            menuButtons[i] = btn;
            hubButtonPanel.add(menuButtons[i]);
        }
    }
    
    //getter functions
    public JPanel getHubNamePanel() { return hubNamePanel; }
    public JPanel getHubButtonPanel() { return hubButtonPanel; }
    public JPanel getHubBackgroundPanel() { return background; }

    public void setVisible(boolean value) {
        hubNamePanel.setVisible(value);
        hubButtonPanel.setVisible(value);
        background.setVisible(value);
    }
}