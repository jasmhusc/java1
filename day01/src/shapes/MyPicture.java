package com.hsc.shapes;

public class MyPicture {
    public static void main(String[] args) {
        Picture pic = new Picture(800,500);
        // 太阳
        Circle c1 = new Circle(700,80,25);
        // 房子
        Rectangle r1 = new Rectangle(540, 300, 140, 80);
        Rectangle r2 = new Rectangle(630, 320, 35, 60);
        Triangle t1 = new Triangle(540, 300, 680, 300, 610, 230);
        Circle c2 = new Circle(580,340,12);
        // 马路
        Line l1 = new Line(0,400,800,400);
        // 树
        pic.add(new Rectangle(432,380,6,20));
        pic.add(new Triangle(400,380,470,380,435,340));
        pic.add(new Triangle(400,340,470,340,435,300));
        pic.add(new Triangle(400,300,470,300,435,260));
        // 火箭
        pic.add(new Rectangle(70,40,36,80));
        pic.add(new Rectangle(80,50,16,16));
        pic.add(new Rectangle(84,80,8,40));
        pic.add(new Triangle(70,40,106,40,88,18));
        pic.add(new Triangle(70,120,70,90,50,120));
        pic.add(new Triangle(106,120,106,90,126,120));
        pic.add(new Circle(76,128,4));
        pic.add(new Circle(88,128,4));
        pic.add(new Circle(100,128,4));
        pic.add(new Triangle(72,136,80,136,76,180));
        pic.add(new Triangle(84,136,92,136,88,180));
        pic.add(new Triangle(96,136,104,136,100,180));
        pic.add(c1);
        pic.add(r1);
        pic.add(r2);
        pic.add(t1);
        pic.add(l1);
        pic.add(c2);

        pic.draw();
    }
}
