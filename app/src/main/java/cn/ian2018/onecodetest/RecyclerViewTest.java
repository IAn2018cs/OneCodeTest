package cn.ian2018.onecodetest;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewTest extends BaseActivity {

    private List<Fruit> fruitList;
    private List<Fruit> recyclerFruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_test);

        // 初始化数据
        initData();
        initFruit();

        // ListView 练习
        ListView listView = (ListView) findViewById(R.id.listveiw);
        FruitListAdapter listAdapter = new FruitListAdapter(this, R.layout.list_item, fruitList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(RecyclerViewTest.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        // RecyclerView 练习
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // 垂直布局
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(linearLayoutManager);

        // 瀑布流
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager
                (3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        FruitRecyclerAdatper recyclerAdatper = new FruitRecyclerAdatper(recyclerFruitList);
        recyclerView.setAdapter(recyclerAdatper);
    }

    private void initData() {
        fruitList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            fruitList.add(apple);

            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            fruitList.add(banana);

            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            fruitList.add(orange);

            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            fruitList.add(watermelon);

            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            fruitList.add(pear);

            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            fruitList.add(grape);

            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            fruitList.add(pineapple);

            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            fruitList.add(strawberry);

            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            fruitList.add(cherry);

            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }

    private void initFruit() {
        recyclerFruitList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple_pic);
            recyclerFruitList.add(apple);

            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.drawable.banana_pic);
            recyclerFruitList.add(banana);

            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.drawable.orange_pic);
            recyclerFruitList.add(orange);

            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon_pic);
            recyclerFruitList.add(watermelon);

            Fruit pear = new Fruit(getRandomLengthName("Pear"), R.drawable.pear_pic);
            recyclerFruitList.add(pear);

            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.drawable.grape_pic);
            recyclerFruitList.add(grape);

            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple_pic);
            recyclerFruitList.add(pineapple);

            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry_pic);
            recyclerFruitList.add(strawberry);

            Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.drawable.cherry_pic);
            recyclerFruitList.add(cherry);

            Fruit mango = new Fruit(getRandomLengthName("Mango"), R.drawable.mango_pic);
            recyclerFruitList.add(mango);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }


}
