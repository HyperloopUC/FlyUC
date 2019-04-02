package com.FlyUC.GUI.UIComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class GradientPane extends JComponent {
    private double height;
    private double width;
    Color startColor;
    Color endColor;

    public GradientPane(Color color1, Color color2 ){
        this.height = 50; //this.getRootPane().getHeight();
        this.width = 50;//this.getRootPane().getWidth();
        this.startColor = color1;
        this.endColor = color2;
        this.setBackground(Color.black);
    }

    public void setWidth(double x){
        this.width = x;
    }

    public void setHeight(double y){
        this.height = y;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

        float[] dist = {0.1f,0.9f};
        Color[] colors = {this.startColor,this.endColor};
        Point2D origin = new Point(20,20);
        Point2D focus = new Point(this.getWidth()/3,this.getHeight()/3);

        RadialGradientPaint backGroundGradient = new RadialGradientPaint(origin,(float)(3*Math.sqrt(this.width*this.width + this.height*this.height)/4),
                focus,dist,colors,MultipleGradientPaint.CycleMethod.NO_CYCLE);
        g2.setColor(Color.black);
        g2.fillRect(0,0,(int)this.width,(int)this.height);
        g2.setPaint(backGroundGradient);
        //FIXME: Change dimensions for non-background panels
        g2.fillRoundRect(0, 0, (int)this.getRootPane().getWidth(), (int)this.getRootPane().getHeight(),40,40);
    }
}
