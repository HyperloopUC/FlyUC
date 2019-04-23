package com.FlyUC.GUI;

import com.FlyUC.GUI.UIComponents.GradientPane;
import com.FlyUC.GUI.UIComponents.cButton;
import com.FlyUC.GUI.UIComponents.cImageView;
import com.FlyUC.GUI.UIComponents.cSpacer;

import javax.swing.*;
import java.awt.*;

public class splashScreen extends JFrame {
    Container container;
    cButton btnContinue;
    cImageView flyUcLogo;
    cImageView frontViewCraft;
    GradientPane backgroundGradient;
    public splashScreen(){

        backgroundGradient = new GradientPane(new Color(235, 95, 85),new Color(255, 95, 105));
        container = getContentPane();
        Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
        backgroundGradient.setHeight(screenResolution.getHeight());
        backgroundGradient.setWidth(screenResolution.getWidth());
        GradientPane layoutManager = backgroundGradient;
        setSize(screenResolution);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setState(Frame.MAXIMIZED_BOTH);
        //setUndecorated(true);
        setVisible(true);
        //layoutManager.setLayout();
        layoutManager.setLayout(new GridBagLayout());
        btnContinue = new cButton("Continue");
        GridBagConstraints c = new GridBagConstraints();
        flyUcLogo = new cImageView("flyuc.png");
        frontViewCraft = new cImageView("perspectiveview.png");
        btnContinue = new cButton("Continue");
        btnContinue.setFontColor(new Color(255, 27, 58));
        btnContinue.setPrimaryColor(new Color(240, 240, 240));

        layoutManager.setBackground(Color.black);

        c.gridx = 0;
        c.gridy = 0;
        c.weightx  = 1;

        c.weighty = .4;
        c.fill = GridBagConstraints.BOTH;
       // c.ipady = 50;

        layoutManager.add(flyUcLogo,c);
        //layoutManager.add(flyUcLogo);
        c.gridy = 1;
        c.weighty = .35;
        layoutManager.add(frontViewCraft,c);
        c.weighty = .1;
        c.weightx = 1;
        c.gridy = 2;
        layoutManager.add(btnContinue,c);
        c.weighty = .05;
        c.gridy = 3;
        layoutManager.add(new cSpacer(),c);

        container.add(layoutManager);
    }
}
