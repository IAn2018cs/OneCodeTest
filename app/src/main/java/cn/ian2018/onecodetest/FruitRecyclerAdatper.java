package cn.ian2018.onecodetest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Administrator on 2017/1/23/023.
 */

public class FruitRecyclerAdatper extends RecyclerView.Adapter<FruitRecyclerAdatper.ViewHolder> {

    private List<Fruit> mFruilList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        View fruitView;
        ImageView fruitImage;
        TextView fruitText;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImage = (ImageView) itemView.findViewById(R.id.fruitImage);
            fruitText = (TextView) itemView.findViewById(R.id.fruitText);
        }
    }

    public FruitRecyclerAdatper(List<Fruit> fruitList) {
        mFruilList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        // 设置点击事件
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posotion = holder.getAdapterPosition();
                Fruit fruit = mFruilList.get(posotion);
                Toast.makeText(view.getContext(), "点击的是整个item\n" + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruilList.get(position);
                Toast.makeText(view.getContext(), "点击的是图片\n" + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruilList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitText.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruilList.size();
    }
}
