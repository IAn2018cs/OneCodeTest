package cn.ian2018.onecodetest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/1/23/023.
 */

public class FruitListAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitListAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruitImage);
            viewHolder.fruitText = (TextView) view.findViewById(R.id.fruitText);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.fruitText.setText(fruit.getName());
        viewHolder.fruitImage.setImageResource(fruit.getImageId());

        return view;
    }

    static class ViewHolder {
        ImageView fruitImage;
        TextView fruitText;
    }
}
