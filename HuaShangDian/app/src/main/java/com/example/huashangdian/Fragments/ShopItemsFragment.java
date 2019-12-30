package com.example.huashangdian.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.huashangdian.MainPageClass;
import com.example.huashangdian.Models.Flower;
import com.example.huashangdian.R;
import com.example.huashangdian.Util.BigDecimalUtil;


public class ShopItemsFragment extends Fragment {

    //    widgets
    private ImageView mImageView, addCart, removeCart;
    private TextView mTitle, mPrice, mDescription;

    //    empty text views to delete elements from the cart
    private TextView mtitle, mtrice, mdescription;

    //    vars
    private Flower mFlower;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager_item, container, false);

        mImageView = view.findViewById(R.id.image);
        mTitle = view.findViewById(R.id.title);
        mPrice = view.findViewById(R.id.price);
        mDescription = view.findViewById(R.id.description);

        addCart = view.findViewById(R.id.addCart);
//        removeCart = view.findViewById(R.id.removeCart);

        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainPageClass mainPageClass = (MainPageClass) getActivity();
                mainPageClass.f1(mTitle,mPrice,mDescription);

            }
        });

//        removeCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                MainPageClass mainPageClass = (MainPageClass) getActivity();
////                mainPageClass.f1("r32r3r2","23r23r2r","2r3r23r");
//                System.out.println(mTitle.getText());
//                System.out.println(mPrice.getText());
//                System.out.println(mDescription.getText());
//                mainPageClass.f2(mTitle,mPrice,mDescription);
//            }
//        });

        return view;
    }

    public static ShopItemsFragment getInstance(Flower flower) {
        ShopItemsFragment fragment = new ShopItemsFragment();

        if (flower != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("flower", flower);
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFlower = getArguments().getParcelable("flower");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mImageView = view.findViewById(R.id.image);
        mTitle = view.findViewById(R.id.title);
        mPrice = view.findViewById(R.id.price);
        mDescription = view.findViewById(R.id.description);

        initial();
    }

    private void initial() {
        if (mFlower != null) {
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.ic_missing);

            Glide.with(getActivity())
                    .setDefaultRequestOptions(options)
                    .load(mFlower.getImage())
                    .into(mImageView);

            mTitle.setText(mFlower.getName());
            mPrice.setText(BigDecimalUtil.getvalue(mFlower.getPrice()));
            mDescription.setText(mFlower.getDescription());
        }
    }


}
