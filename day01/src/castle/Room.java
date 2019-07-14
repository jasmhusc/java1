package castle;

import java.util.HashMap;

public class Room {

    /* 对于一个房间来说，它有几个出口，出口是另一个房间
        如果用属性来表示，东南西北，将来甚至还有上下
        属性很多，也不利于扩展；
       所以使用hashmap来存取，出口名---房间
     */
    private HashMap<String, Room> exits = new HashMap<String, Room>();
    private String name;

    // 构造函数（为了让房间有名字，我们只定义有参构造）
    public Room(String name){
        this.name = name;
    }

    // 获取当前房间名字接口
    public String getName(){
        return name;
    }
    // 为房间设置出口的方法接口
    public void setExit(String exit, Room room){
        exits.put(exit,room);
    }

    // 需要提供当前房间的出口信息的接口
    public String getExits(){
        StringBuilder sbu = new StringBuilder();
        for(String exit:exits.keySet()){
            sbu.append(exit);
            sbu.append(" ");
        }
        return sbu.toString();
    }

    public Room getExitRoom(String exit){
        return exits.get(exit);
    }

    @Override
    public String toString() {
        return name;
    }
}
