package com.FlyUC.GUI.UIComponents;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class cImageView extends JComponent {
    private static final boolean IS_HIGH_QUALITY = true;
    private int height;
    private int width;
    private int horizontalMargin;
    private int verticalMargin;
    BufferedImage myImage;
    String imagePath;

    public cImageView(String imageName){
        imageFromFileName(imageName);
      //  this.height = this.myImage.getHeight();
       // this.width = this.myImage.getWidth();
        this.horizontalMargin = 0;
        this.verticalMargin = 0;
        this.myImage = this.myImage;
        this.imagePath = "";

    }

    public void imageFromFileName(String imageName){
        this.imagePath =  imageName; //"src/com/FlyUC/Images/" +
        try{
            this.myImage = ImageIO.read(new File(this.imagePath));
            this.width = this.myImage.getWidth();
            this.height = this.myImage.getHeight();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void imageFromFilePath(String path){
        this.imagePath = path;
        try{
            this.myImage = ImageIO.read(new File(this.imagePath));
            this.width = this.myImage.getWidth();
            this.height = this.myImage.getHeight();
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        if(IS_HIGH_QUALITY){
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        g2.drawImage(this.myImage,this.horizontalMargin,this.verticalMargin,null);
    }
}
