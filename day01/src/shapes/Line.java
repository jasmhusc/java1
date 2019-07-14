package com.hsc.shapes;

import java.awt.*;

public class Line extends Shape{
    private int x1,y1,x2,y2;
    private Point a,b;
    public Line(int x1,int y1,int x2,int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public Line(Point a,Point b){
        this.a = a;
        this.b = b;
        this.x1 = a.x;
        this.y1 = a.y;
        this.x2 = b.x;
        this.y2 = b.y;
    }
    @Override
    public void draw(Graphics g) {
        g.drawLine(x1,y1,x2,y2);
    }
}
