package co.jp.practise.domian.design.u58;

/**
 * 1.定义抽象类，规定算法骨架
 */
public abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    //模板，定义为final，避免被子类重写。
    public final void play() {

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
