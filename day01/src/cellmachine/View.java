package com.hsc.cellmachine;

import javax.swing.*;
import java.awt.*;

/*
* View是对Field的显示，表现
*      用Jpanel来显示
*   它指定某个细胞的大小----GRID_SIZE
*   1.重写paint方法，每次view被画出来时，就调用该方法，遍历所传进来的需要被画的。
*       field的所有元素（细胞），并人细胞将自己显示出来。
*   2.重写getPreferredSize方法，使Panel大小随 field 大小而改变。
*  */
public class View extends JPanel{
    private static final long serialVersionUID = 1L;
    private static final int GRID_SIZE = 16;
    private Field field;

    public View(Field field) {
        this.field = field;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int row = 0; row < field.getHeight(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Cell cell = field.get(row,col);
                if (cell != null)
                    cell.draw(g,col*GRID_SIZE,row*GRID_SIZE,GRID_SIZE);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(field.getWidth()*GRID_SIZE+1,field.getHeight()*GRID_SIZE+1);
    }

}
