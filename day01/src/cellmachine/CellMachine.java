package com.hsc.cellmachine;

import javax.swing.*;
import java.awt.*;

/*
* 细胞自动机：
*   一个细胞活着的邻居数量 <2(太寂寞) 或 >3(太拥挤)，则死亡;
*   如果正好有 3 个邻居活着，则新生;
*   其他情况保持不变
*   */
public class CellMachine {
    public static void main(String[] args) {

        Field field = getField(30,30);
        View view = new View(field);
        JFrame frame = getFrame(view);
        start(field, frame, 1000);
    }

    private static JFrame getFrame(View view) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("细胞机器");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\javafile\\cellmachine.jpg"));
        frame.setResizable(false);
        frame.add(view);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    private static Field getField(int width, int height) {
        // 创建一个指定大小的细胞存放区：field
        Field field = new Field(width, height);
        // 向field内放入细胞
        for (int row = 0; row < field.getHeight(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                field.place(row,col,new Cell());
            }
        }
        return field;
    }

    private static void start(Field field, JFrame frame, int steps) {
        for (int i = 0; i < steps; i++) {
            step(field);
            // 重画整张
            frame.repaint();
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void step(Field field) {
        /* 判断 field 中所有细胞的周边环境，修改其生存状态
            每运行一步需要对数据 Field 进行更新
         */
        for (int row = 0; row < field.getHeight(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Cell cell = field.get(row, col);
                // 获得该细胞周围或者的邻居数量
                Cell[] neighbour = field.getNeighbour(row, col);
                int numOfLive = 0;
                for (Cell c : neighbour) {
                    if (c.isAlive())
                        numOfLive++;
                }
                // 更改该细胞生存状态
                if (cell.isAlive()){
                    if (numOfLive<2 || numOfLive>3)
                        cell.die();
                }else if (numOfLive==3){
                    cell.reborn();
                }
            }
        }
    }
}
