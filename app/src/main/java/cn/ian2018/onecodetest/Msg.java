package cn.ian2018.onecodetest;

/**
 * Created by Administrator on 2017/1/24/024.
 */

public class Msg {
    private String content;
    private int type;
    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SEND = 1;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
