package com.example.huashangdian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.huashangdian.Fragments.ShopItemsFragment;
import com.example.huashangdian.Models.Flower;
import com.example.huashangdian.Models.Flowers;
import com.example.huashangdian.NewItemsPackage.MyPagerAdapter;
import com.example.huashangdian.views.CartView;
import com.example.huashangdian.views.SearchView;
import com.example.huashangdian.views.InfoView;
import com.example.huashangdian.views.NewItemsView;
import com.example.huashangdian.views.ProfileView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainPageClass extends AppCompatActivity {

    // widgets
    private ViewPager mMyViewPager;
    private TabLayout mTabLayout;
    private String st;

//    variabl to store data from shop fragment
    private ImageView image;
    private TextView flowerDes;
    private TextView flowerPrice;
    private TextView flowerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_pages_class);
        mTabLayout = findViewById(R.id.tab_layout);
        mMyViewPager = findViewById(R.id.view_pager);


        st = getIntent().getExtras().getString("username");

//        the banner at the top of the page
        TextView welcome = (TextView) findViewById(R.id.welcome);
        welcome.setText("🌺🌺🌺🌺 欢迎到花商店" + st + "!!! 🌺🌺🌺🌺 ");
        welcome.setSelected(true);

//      code to take stuff from fragment and pass it to the actitvity
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction t = manager.beginTransaction();
        ShopItemsFragment ShopItem = new ShopItemsFragment();
        t.commit();


//      Nav Bar at the bottom of the page items
        ImageView profile = findViewById(R.id.profile_butt);
        ImageView info = findViewById(R.id.info);
        ImageView chat = findViewById(R.id.blog);
        ImageView cart = findViewById(R.id.cart);
        ImageView newItem = findViewById(R.id.new_butt);

        init();

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "ProfileView", Toast.LENGTH_LONG).show();
                OpenProfile();

            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Information", Toast.LENGTH_LONG).show();
                OpenInfoView();
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
                OpenChatView();
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Cart", Toast.LENGTH_LONG).show();
                OpenCartview();
            }
        });

        newItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "New Items", Toast.LENGTH_LONG).show();
                OpenNewItemView();
            }
        });
    }

    public void saveData(){

    }

    public void f1(TextView flowerN, TextView flowerP, TextView flowerD){
        flowerDes = (TextView) findViewById(R.id.description);
        flowerPrice= (TextView) findViewById(R.id.price);
        flowerName = (TextView) findViewById(R.id.title);

        Toast.makeText(getApplicationContext(), "Item added to chart", Toast.LENGTH_LONG).show();

        flowerDes.setText(flowerD.getText());
        flowerPrice.setText(flowerP.getText());
        flowerName.setText(flowerN.getText());
    }


    public void OpenProfile() {
        Intent intent = new Intent(this, ProfileView.class);
        intent.putExtra("username", st);
        startActivity(intent);
//        finish();
    }

    public void OpenInfoView() {
        Intent intent = new Intent(this, InfoView.class);
        intent.putExtra("username", st);
        startActivity(intent);
    }

    public void OpenChatView() {
        Intent intent = new Intent(this, SearchView.class);
        intent.putExtra("username", st);
        startActivity(intent);
    }

    public void OpenCartview() {
        Intent intent = new Intent(this, CartView.class);
        TextView des = (TextView) findViewById(R.id.description);
        TextView price = (TextView) findViewById(R.id.price);
        TextView title = (TextView) findViewById(R.id.title);

        if(flowerDes==null || flowerPrice==null || flowerName==null ){
            intent.putExtra("username", st);
            startActivity(intent);
        }else{
            intent.putExtra("des", flowerDes.getText());
            intent.putExtra("price", flowerPrice.getText());
            intent.putExtra("name", flowerName.getText());

            intent.putExtra("username", st);
            startActivity(intent);
        }

    }

    public void OpenNewItemView() {
        Intent intent = new Intent(this, NewItemsView.class);
        intent.putExtra("username", st);
        startActivity(intent);
//        finish();
    }

    private void init() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        Flower[] flowers = Flowers.getFlowers();
        for (Flower flower : flowers) {
            ShopItemsFragment fragment = ShopItemsFragment.getInstance(flower);
            fragments.add(fragment);

        }
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        mMyViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mMyViewPager, true);
    }


}

