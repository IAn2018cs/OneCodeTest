package cn.ian2018.onecodetest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/1/24/024.
 */

public class MsgAdatper extends RecyclerView.Adapter<MsgAdatper.ViewHolder> {

    private List<Msg> mMsgList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout liftLayout;
        private LinearLayout rightLayout;
        private TextView liftMsg;
        private TextView rightMsg;

        public ViewHolder(View itemView) {
            super(itemView);
            liftLayout = (LinearLayout) itemView.findViewById(R.id.left_layout);
            rightLayout = (LinearLayout) itemView.findViewById(R.id.right_layout);
            liftMsg = (TextView) itemView.findViewById(R.id.left_msg);
            rightMsg = (TextView) itemView.findViewById(R.id.right_msg);
        }
    }

    public MsgAdatper (List<Msg> msgList) {
        mMsgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = mMsgList.get(position);
        // 如果是收到消息 就显示左边的布局 隐藏右边的布局
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            holder.liftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);

            holder.liftMsg.setText(msg.getContent());
        }
        // 如果是发送消息 就显示右边的布局 隐藏左边的布局
        if (msg.getType() == Msg.TYPE_SEND) {
            holder.liftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);

            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }
}
