


package com.FlyUC.GUI.UIComponents;

import javax.swing.*;
import java.awt.*;

public class cButton extends JComponent {

    private static final boolean IS_HIGH_QUALITY = true;

    private int buttonHeight;
    private int buttonWidth;
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
    private int buttonShadow;
    private int  collisionBoxWidth;
    private int collisionBoxHeight;

    /*
        Default class constructor with no params
        No returns
     */

    public cButton(){
        this.setBackground(new Color(0,0,0,0));
        this.setButtonHeight(50);
        this.setButtonWidth(150);
        this.verticalMargin = 10;
        this.horizontalMargin = 10;
        this.fontSize = 20;
        this.buttonFont = new Font("Helvetica", Font.PLAIN, this.fontSize);
        this.caption = "Text";
        this.buttonShadow  = 3;
    }

    /*
        Class constructor with params
        @param caption  Caption is the text displayed on the button
        @returns none
     */

    public cButton(String caption){
        this.setBackground(new Color(0,0,0,0));
        this.setButtonHeight(50);
        this.setButtonWidth(170);
        this.verticalMargin = 10;
        this.horizontalMargin = 10;
        this.fontSize = 20;
        this.buttonFont = new Font("Helvetica", Font.PLAIN, this.fontSize);
        this.caption = caption;
        this.isClicked = false;
        this.isHovering = false;
        this.buttonShadow = 3;
    }
    /*
        Sets the total button width for the button, including margins
        @param x is the number of pixels needed for the total width of the button prior to scaling
        @returns none
     */
    public void setButtonWidth(int x){
        this.buttonWidth = x;
    }

    /*
        Sets the total button width for the button, including margins
        @param x is the number of pixels needed for the total width of the button prior to scaling
        @returns none
     */

    public void setButtonHeight(int y){
        this.buttonHeight = y;
    }
    /*
        Sets the total button width for the button, including margins
        @param x is the number of pixels needed for the total width of the button prior to scaling
        @returns none
     */
    public void setCaption(String text){
        this.caption = text;
    }

    /*
        Sets the total button width for the button, including margins
        @param x is the number of pixels needed for the total width of the button prior to scaling
        @returns none
     */

    public void setHorizontalMargin(int margin){
        this.horizontalMargin = margin;
        //this.setButtonWidth(this.getWidth()+(2*margin));
    }
    /*
        Sets the total button width for the button, including margins
        @param x is the number of pixels needed for the total width of the button prior to scaling
        @returns none
    */
    public void setVerticalMargin(int margin){
        this.verticalMargin = margin;
        //this.setHeight(this.getHeight()+(2*margin));
    }
    /*
        Sets the total button width for the button, including margins
        @param x is the number of pixels needed for the total width of the button prior to scaling
        @returns none
    */
    public void setfontSize(int size) { this.fontSize = size; }

    /*
        Sets the total button width for the button, including margins
        @param x is the number of pixels needed for the total width of the button prior to scaling
        @returns none
     */

    public void setFontColor(Color fontColor){ this.foreGroundColor  = fontColor; }

    /*
        Sets the total button width for the button, including margins
        @param x is the number of pixels needed for the total width of the button prior to scaling
        @returns none
     */

    public void setPrimaryColor(Color backColor) { this.primaryColor = backColor; }

    /*
        Sets the total button width for the button, including margins
        @param x is the number of pixels needed for the total width of the button prior to scaling
        @returns none
     */

    public void setFont(String font){ this.buttonFont = new Font(this.buttonFont.getFontName(), Font.PLAIN, this.fontSize); }
     /*
        Gets the total button height including margins
        @returns buttonHeight
     */

    public int getButtonHeight(){ return this.buttonHeight; }

    /*
        Gets the total button width including margins
        @returns buttonWidth
     */

    public int getButtonWidth(){ return this.buttonWidth; }

    /*
        Updates whether there is a cursor hovering over the mouse or not
        No params.
        @returns none
     */

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
            //Normal State for the button
            int startX = (this.getWidth()/2)-(this.getButtonWidth()/2) + this.getButtonHeight()/2;

            int finalX = this.getButtonWidth()-this.getButtonHeight()-this.horizontalMargin;
            int startY = (((this.getHeight()/2 - this.getButtonHeight()/2) + this.verticalMargin));
            System.out.println(startX);
            System.out.println("Final X:");

            g2.setColor(new Color(this.primaryColor.getRed()-25,this.primaryColor.getGreen()-25,this.primaryColor.getBlue()-25));
            g2.fillOval((int)(this.getWidth()/2)-(this.getButtonWidth()/2) + this.horizontalMargin+this.buttonShadow,startY+this.buttonShadow,this.getButtonHeight(),this.getButtonHeight());
            g2.fillOval((int)((startX + finalX))-(this.getButtonHeight()/2)+this.horizontalMargin+this.buttonShadow,startY + this.buttonShadow,this.getButtonHeight(),this.getButtonHeight());

            g2.fillRect(startX+this.horizontalMargin+this.buttonShadow,startY + this.buttonShadow,finalX,this.getButtonHeight());

            g2.setColor(this.primaryColor);
            g2.fillOval((int)(this.getWidth()/2)-(this.getButtonWidth()/2) + this.horizontalMargin,startY,this.getButtonHeight(),this.getButtonHeight());
            g2.fillOval((int)((startX + finalX))-(this.getButtonHeight()/2)+this.horizontalMargin,startY,this.getButtonHeight(),this.getButtonHeight());

            g2.fillRect(startX+this.horizontalMargin,startY,finalX,this.getButtonHeight());

            g2.setColor(this.foreGroundColor);


            GradientPaint gp = new GradientPaint(0, buttonHeight - getFontMetrics(buttonFont).getAscent(),new Color(230, 107, 58) ,
                    getFontMetrics(buttonFont).stringWidth(this.caption), buttonHeight, new Color(255, 81, 84), true);
            g2.setPaint(gp);
            g2.drawString(this.caption, (this.getWidth() - getFontMetrics(buttonFont).stringWidth(this.caption))/2, (int)(((this.getHeight() + this.fontSize)/2)+this.verticalMargin/1.5));
        }
    }
}
