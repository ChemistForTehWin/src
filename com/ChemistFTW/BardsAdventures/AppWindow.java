package com.ChemistFTW.BardsAdventures;

import javax.swing.*;

public class AppWindow extends JFrame {
        public AppWindow(){
            super("Bard's Adventures v.0"); // !Window header, should export from version stamp (set in init())!
            setBounds(50,50,1024,768); //    !CHANGE THIS TO EXPORT FROM INIT VALUES!
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
}

