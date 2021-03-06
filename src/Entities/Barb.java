package Entities;

import javax.swing.*;
import java.util.ArrayList;

public class Barb extends Entity {
    private static final String name = "barbarian1";
    private static final int maxHealth = 45;
    private static final int lightAttack = 8;
    private static final int heavyAttack = 16; 
    private static final int speed = 7;
    private static final int numOfAttacks = 2;

    public Barb() {
        super(name, maxHealth, lightAttack, heavyAttack, speed, numOfAttacks, new JLabel(new ImageIcon(Barb.class.getClassLoader().getResource("res/entity/characters/" + name + ".png"))));
    }
}
