package castle;

public class Handler {

    // 由于执行命令极可能需要对Game中的某写数据进行处理，或需要用到那些数据，因此要得到该Game对象
    protected Game game;
    public Handler(Game game){
        this.game = game;
    }
    // 提供执行命令的函数，且子类都要继承
    public void doCmd(String cmd){

    }
    // 给出结束判断函数，并默认为false
    public boolean isBye(){
        return false;
    }
}
