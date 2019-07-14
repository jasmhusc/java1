package com.hsc.cellmachine;

import java.awt.*;
/*
* Cell是细胞：
*   它只管自己的死活：alive--true(0.5) or false(0.5)
*       死亡--dead()  重生--reborn()
*       获取生存状态--isAlive()
*   它还可以根据自己生存状态，将自己显示出来：
*       draw()
*  */
public class Cell {

    private boolean alive = Math.random()<0.5 ? true:false;

    public void die(){alive = false;}
    public void reborn(){alive = true;}
    public boolean isAlive(){
        return alive;
    }
    public void draw(Graphics g,int x,int y,int size){
        g.drawRect(x,y,size,size);
        if (alive)
            g.fillRect(x,y,size,size);
    }
}
