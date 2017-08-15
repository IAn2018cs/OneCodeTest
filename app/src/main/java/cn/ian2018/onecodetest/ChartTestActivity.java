package cn.ian2018.onecodetest;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ChartTestActivity extends BaseActivity {

    private List<Msg> mMsgList = new ArrayList<>();
    private MsgAdatper adatper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_test);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.chart_recycler);
        final EditText editText = (EditText) findViewById(R.id.msg);
        Button button = (Button) findViewById(R.id.send);

        // 初始化一些数据
        initData();

        // 设置recyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adatper = new MsgAdatper(mMsgList);
        recyclerView.setAdapter(adatper);

        // 设置发送按钮的点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = editText.getText().toString().trim();
                if (!content.equals("")) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    mMsgList.add(msg);
                    // 通知数据适配器最后一个条目刷新
                    adatper.notifyItemChanged(mMsgList.size() - 1);     // 这个方法效果有一定的缓冲效果
//                    adatper.notifyDataSetChanged();   // 这个效果太直接 没有视觉上的缓冲效果
                    // 定位到list最后一条数据
                    recyclerView.scrollToPosition(mMsgList.size() - 1);
                    // 将输入框里清空
                    editText.setText("");
                }
            }
        });
    }

    private void initData() {
        Msg msg1 = new Msg("Hello World", Msg.TYPE_RECEIVED);
        mMsgList.add(msg1);

        Msg msg2 = new Msg("你好", Msg.TYPE_SEND);
        mMsgList.add(msg2);

        Msg msg3 = new Msg("My name is ApioGo", Msg.TYPE_RECEIVED);
        mMsgList.add(msg3);
    }
}
