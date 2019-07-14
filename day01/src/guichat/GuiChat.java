package com.hsc.guichat;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* GUI聊天室
* */
public class GuiChat extends Frame{

    private TextArea sendtext;
    private TextArea viewtext;
    private Button send;
    private Button log;
    private Button clear;
    private Button shake;
    private Button delete;
    private DatagramSocket socket;
    private BufferedWriter bw;
    private TextField tf;
    private File logName;

    // 继承Frame类，直接在main函数内创建对象，获得一个窗口
    public static void main(String[] args) {

        new GuiChat();
    }

    // 我们希望对象创建时，Frame所有内容都加载完成，因此将所有要实现的方法都放在构造函数中
    public GuiChat(){
        init();
        southPanel();
        centerPanel();
        event();
    }

    private class receive extends Thread{
        @Override
        public void run() {
            try {
                // 创建码头，指定端口号8080
                DatagramSocket socket = new DatagramSocket(8080);
                // 创建包裹，指定包裹大小，即运输多少字节数据
                DatagramPacket Packet = new DatagramPacket(new byte[8192],8192);

                // 不间断接收数据
                while(true){
                    // 接收包裹
                    socket.receive(Packet);
                    /* 获取包裹内数据 : 发送者IP 收到的信息长度 字节数据
                        字节流转换为字符串--构造函数String(byte[],off,len)
                     */
                    byte[] data = Packet.getData();
                    int len = Packet.getLength();
                    //判断是否为震动信号 -1
                    if (data[0]==-1 && len==1){
                        shake();
                        continue;
                    }
                    String ip = Packet.getAddress().getHostAddress();
                    // 拼接字符串，显示到viewtext
                    String time = getCurrentTime();
                    String message = new String(data, 0, len);
                    String str = time+" "+ip+"对我说：\r\n"+message+"\r\n\r\n";
                    viewtext.append(str);

                    // 同时将信息存入记录本
                    bw.write(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    private String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        String time = sdf.format(date);
        return time;
    }
    private void event() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 在窗口关闭的时候关闭流，释放资源
                try {
                    socket.close();
                    bw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
            }
        });
        sendtext.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    try {
                        send();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
            }
        });
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    send();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    logFile();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewtext.setText("");
            }
        });
        shake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    send(new byte[] {-1},tf.getText());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLog();
            }
        });
    }

    private void deleteLog() {
        /* 删除聊天记录内容
           可以用输出流的write，其在写出内容之前都会先清空原来txt中的内容
           除非后面加 true 可以续写
         */
        try {
            bw.flush();
            FileWriter fr = new FileWriter(logName);
            fr.write("");
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void shake() {
        // 获取窗口位置坐标
        int x = this.getLocation().x;
        int y = this.getLocation().y;
        // 用改变坐标模拟震动
        try {
            for (int i = 0; i < 3; i++) {
                this.setLocation(x, y + 2);
                Thread.sleep(100);
                this.setLocation(x + 2, y);
                Thread.sleep(100);
                this.setLocation(x, y);
                Thread.sleep(100);
                this.setLocation(x + 2, y + 3);
                Thread.sleep(100);
                this.setLocation(x, y);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void logFile() throws IOException {
        bw.flush();
        FileInputStream fis = new FileInputStream(logName);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  // 在内存中创建缓冲区
        int len;
        byte[] arr = new byte[8192];
        while((len = fis.read(arr)) != -1) {
            baos.write(arr,0,len);
        }
        String str = baos.toString();  //将内存中的所有内容转换为一个字符串
        viewtext.setText(str);
        fis.close();

       /* viewtext.setText("");
        BufferedReader br = new BufferedReader(new FileReader(logName));
        char[] brr = new char[8192];
        int len;
        while ((len=br.read(brr,0,brr.length)) != -1){
            String str = new String(brr, 0, len);
            viewtext.append(str);
        }
        br.close();*/

    }

    private void send(byte[] arr,String ip) throws Exception {
        // 将信息发送出去
        DatagramPacket packet = new DatagramPacket(arr, arr.length, InetAddress.getByName(ip), 8080);
        socket.send(packet);
    }
    private void send() throws Exception {
        /* 获取用户输入在窗口的ip和sendtext的信息
            将信息变为字节流--String的方法getbytes()
         */
        String ip = tf.getText();
        // 如果tf里为空则默认对所有人说话
        ip = ip.trim().length()==0 ? "255.255.255.255":ip;
        String msg = sendtext.getText();
        byte[] arr = msg.getBytes();
        // 调用有参构造函数
        send(arr,ip);
        // 拼接字符串，显示到viewtext
        String time = getCurrentTime();
        String str = time+" "+"我对"+("255.255.255.255".equals(ip)?"所有人":ip)+"说：\r\n"+msg+"\r\n\r\n";
        viewtext.append(str);
        sendtext.setText("");

        // 同时将信息存入记录本
        bw.write(str);
    }

    private void centerPanel(){
        Panel cenpanel = new Panel();
        cenpanel.setLayout(new BorderLayout());

        // 显示和打字两个区域
        sendtext = new TextArea(6,1);
        sendtext.setBackground(Color.white);
        sendtext.setFont(new Font("宋体",Font.PLAIN,15));
        cenpanel.add(sendtext,BorderLayout.SOUTH);

        viewtext = new TextArea();
        viewtext.setEditable(false);
        viewtext.setBackground(Color.white);
        viewtext.setFont(new Font("宋体",Font.PLAIN,15));
        cenpanel.add(viewtext);

        this.add(cenpanel);
    }
    private void southPanel() {
        // 聊天室分为两块Panel  上面显示 打字输出  下面操作等
        Panel soupanel = new Panel();

        // 里面为边界布局BorderLayout（默认）

        // ip输入框---TextField  只能写一行
        tf = new TextField(10);
        tf.setText("127.0.0.1");
        soupanel.add(tf,BorderLayout.SOUTH);
        // 添加发送 删除 等按钮
        send = new Button("send");
        log = new Button("log");
        clear = new Button("clear");
        shake = new Button("shake");
        delete = new Button("delete");
        soupanel.add(send);
        soupanel.add(log);
        soupanel.add(clear);
        soupanel.add(shake);
        soupanel.add(delete);

        // 添加到Frame
        this.add(soupanel,BorderLayout.SOUTH);
    }

    // 窗口过于简单，需要进行一些初始化设置---init()
    private void init(){
        this.setSize(430,600);
        this.setLocation(900,20);
        this.setTitle("GUI聊天室");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\javafile\\wx.jpg"));
        // 开启服务器接收信息
        new receive().start();
        // 指定记录本存储路径
        logName = new File("config.txt");
        this.setVisible(true);
        // 创建客户端
        try {
            socket = new DatagramSocket();
            bw = new BufferedWriter(new FileWriter(logName,true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
