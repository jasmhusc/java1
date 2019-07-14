package com.hsc.shapes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Picture extends JFrame{
    private static final long serialVersionUID = 1L;
    private int width,height;
    private ArrayList<Shape> shapeList = new ArrayList<>();

    public Picture(int width, int height){
        this.width = width;
        this.height = height;
        add(new ShapePanel());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private class ShapePanel extends JPanel{
        private static final long serialVersionUID = 1L;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Shape s : shapeList) {
                s.draw(g);
            }
        }
    }
    public void add(Shape shape){
        shapeList.add(shape);
    }
    public void draw(){
        double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double h = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        setLocation((int)(w-width)/2,(int)(h-height)/2);
        setSize(width,height);
        setVisible(true);
    }
}
