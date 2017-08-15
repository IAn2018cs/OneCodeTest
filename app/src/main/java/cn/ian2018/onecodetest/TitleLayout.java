package cn.ian2018.onecodetest;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/23/023.
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(final Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.title, this);
//        LayoutInflater.from(context).inflate(R.layout.title, this);
        Button back = (Button) findViewById(R.id.title_back);
        Button edit = (Button) findViewById(R.id.title_edit);

        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // 获取到当前activity 并销毁
                ((Activity) getContext()).finish();
            }
        });

        edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "你点击了编辑按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
