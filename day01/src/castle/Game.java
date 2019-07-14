package castle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private Room currentRoom;
    private HashMap<String, Handler> handlers = new HashMap<String, Handler>();

    // 构造函数 进行命令和城堡的初始化设置
    public Game(){
        handlers.put("help",new HandlerHelp(this));
        handlers.put("bye",new HandlerBye(this));
        handlers.put("go",new HandlerGo(this));
        createRooms();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.showWelcom();
        game.play();
        System.out.println("感谢您的光临，再见！");
    }

    // 创建城堡房间结构
    public void createRooms(){
        Room outside = new Room("城堡外");
        Room bedroom = new Room("卧室");
        Room study = new Room("书房");
        Room lobby = new Room("大堂");
        Room pub = new Room("小酒吧");

        //	初始化房间的出口
        outside.setExit("east", lobby);
        outside.setExit("south", study);
        outside.setExit("west", pub);
        bedroom.setExit("west", study);
        bedroom.setExit("north", lobby);
        lobby.setExit("west", outside);
        lobby.setExit("south", bedroom);
        pub.setExit("east", outside);
        study.setExit("north", outside);
        study.setExit("east", bedroom);
        //	从城堡门外开始
        currentRoom = outside;
    }
    // 游戏进入欢迎页面信息
    public void showWelcom(){
        System.out.println("");
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println("");
        System.out.println("");
        showPromt();
    }

    public void showPromt(){
        // 输出每次所在的房间名称提示信息，以及可以选择的出口（方向)
        System.out.println("你现在在"+currentRoom);
        System.out.println("出口有：");
        System.out.println(currentRoom.getExits());
    }

    // 到达另一个房间后，需要对当前所在房间数据更新
    public Room goRoom(String word){
        Room nextroom = currentRoom.getExitRoom(word);
        if(nextroom != null)
            currentRoom = nextroom;
        else
            System.out.println("Sorry,那里没有门！");
        showPromt();
        return currentRoom;
    }
    // 游戏进行程序
    public void play(){
        Scanner sc = new Scanner(System.in);
        while(true){
            // 接收用户输入命令，并去除空格
            String[] words;
            String value = "";
            words = sc.nextLine().split(" ");
            value = words[0];
            Handler handler = handlers.get(value);
            if(words.length > 1){
                value = words[1];
            }
            if(handler != null){
                if(handler.isBye()){
                    break;
                }
                handler.doCmd(value);
            }
        }
    }
}
