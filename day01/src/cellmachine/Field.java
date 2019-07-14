package com.hsc.cellmachine;

import java.util.ArrayList;
/*
* Field是存放细胞的区域：
*       它可以通过构造函数指定存储空间的大小：width和height----传给数组
*       它内部创建一个细胞二维数组(Cell[][]),用于存储每个细胞,且只管细胞的存放(place),获取(get),清除(clear)。
* */
public class Field {
    private int width;
    private int height;
    private Cell[][] field;

    public Field(int width,int height){
        this.width = width;
        this.height = height;
        this.field = new Cell[width][height];
    }

    public int getWidth(){return width;}
    public int getHeight(){return height;}

    public Cell get(int row, int col){
        return field[row][col];
    }

    public Cell place(int row, int col, Cell op){
        Cell ret = field[row][col];
        field[row][col] = op;
        return ret;
    }

    public Cell[] getNeighbour(int row, int col){
        ArrayList<Cell> list =  new ArrayList<Cell>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int r = row+i;
                int c = col+j;
                if(r>-1 && r<height && c>-1 && c<width && !(c == col && r == row))
                    list.add(field[r][c]);
            }
        }
        return list.toArray(new Cell[list.size()]);
    }
    public void clear() {
        for ( int i=0; i<height; i++ ) {
            for ( int j=0; j<width; j++ ) {
                field[i][j] = null;
            }
        }
    }
}
