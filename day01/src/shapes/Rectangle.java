package com.hsc.shapes;

import java.awt.*;

public class Rectangle extends Shape{
    private int x,y,width,height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(x,y,width,height);
    }
}
