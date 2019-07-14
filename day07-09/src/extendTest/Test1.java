package extendTest;

public class Test1 {
    public static void main(String[] args) {

        new Son();
    }
}
class Father{

    public Father(){
        System.out.println("f--无参");
    }
    public Father(int num){
        System.out.println("f--有参");
    }
}
class Son extends Father{

    public Son(){
        super();
//        this(1);
        System.out.println("s--无参");
    }
    public Son(int num){
        super(num);
        System.out.println("s--有参");
    }
}