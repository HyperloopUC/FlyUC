


package com.FlyUC.GUI.UIComponents;

import javax.swing.*;
import java.awt.*;

public class cButton extends JComponent {

    private static final boolean IS_HIGH_QUALITY = true;

    private int height;
    private int width;
    private int horizontalMargin;
    private int verticalMargin;
    private int numberOfRoundedCorners;
    private int fontSize;
    private boolean isHovering;
    private boolean isClicked;
    private String caption;
    private Color primaryColor;
    private Color foreGroundColor;
    private Font buttonFont;

    public cButton(){
        this.setBackground(new Color(0,0,0,0));
        this.setHeight(50);
        this.setWidth(150);
        this.verticalMargin = 10;
        this.horizontalMargin = 10;
        this.fontSize = 20;
        this.buttonFont = new Font("Helvetica", Font.PLAIN, this.fontSize);
        this.caption = "Text";
    }

    public cButton(String caption){
        this.setBackground(new Color(0,0,0,0));
        this.setHeight(50);
        this.setWidth(250);
        this.verticalMargin = 10;
        this.horizontalMargin = 10;
        this.fontSize = 20;
        this.buttonFont = new Font("Helvetica", Font.PLAIN, this.fontSize);
        this.caption = caption;
    }

    public void setWidth(int x){
        this.width = x;
    }

    public void setHeight(int y){
        this.height = y;
    }

    public void setCaption(String text){
        this.caption = text;
    }

    public void setHorizontalMargin(int margin){
        this.horizontalMargin = margin;
    }

    public void setVerticalMargin(int margin){
        this.verticalMargin = margin;
    }

    public void setfontSize(int size) { this.fontSize = size; }

    public void setFontColor(Color fontColor){ this.foreGroundColor  = fontColor; }

    public void setPrimaryColor(Color backColor) { this.primaryColor = backColor; }

    public void setFont(String font){ this.buttonFont = new Font(this.buttonFont.getFontName(), Font.PLAIN, this.fontSize); }

    public void setIsHovering(){
        if(this.isHovering){
            this.isHovering = false;
        }else{
            this.isHovering = true;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.primaryColor);
        g2.setFont(this.buttonFont);
        if (IS_HIGH_QUALITY) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED);
            g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        if(isHovering){
            if(isClicked) {
                //Clicked
            }else{
                //Hovering, but not clicked
            }
        }else{
            //Not hovering, normal state
            int startX = (this.getParent().getWidth()/2);
          //FIXME: Button does not center   g2.fillRect((this.getParent().getWidth()/2)+(this.height/2)-this.getWidth(),verticalMargin,(this.width-(this.getHeight()/2)-horizontalMargin),this.height-verticalMargin);
        }
        g2.setColor(this.foreGroundColor);
        g2.drawString(this.caption, (this.getWidth() - getFontMetrics(buttonFont).stringWidth(this.caption))/2, ((this.getHeight() - this.fontSize)/2)-verticalMargin);
    }
}
