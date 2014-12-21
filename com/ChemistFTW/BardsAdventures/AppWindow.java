package com.ChemistFTW.BardsAdventures;

import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame {
    public AppWindow() {
        super("Bard's Adventures v.0"); // !Window header, should export from version stamp (set in init())!
        setBounds(50, 50, 1024, 768); //    !CHANGE THIS TO EXPORT FROM INIT VALUES!
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(getToolkit().getImage(getClass().getResource("img/bardimage.jpg")));
        setBackground(Color.black);
        setForeground(Color.black);
    }
}

