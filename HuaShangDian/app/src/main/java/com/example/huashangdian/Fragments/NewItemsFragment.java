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
import com.example.huashangdian.Models.NewFlower;
import com.example.huashangdian.R;


public class NewItemsFragment extends Fragment {

    //    widgets
    private ImageView mNewImageView;
    private TextView mNewTitle,mNewDescription;

    //    vars
    private NewFlower mNewFlower;

    public static NewItemsFragment getInstance(NewFlower newflower){
        NewItemsFragment fragment = new NewItemsFragment();

        if(newflower != null){
            Bundle bundle = new Bundle();
            bundle.putParcelable("newflower",newflower);
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mNewFlower = getArguments().getParcelable("newflower");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_item_fragment_view,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mNewImageView = view.findViewById(R.id.Newimage);
        mNewTitle = view.findViewById(R.id.Newtitle);
        mNewDescription = view.findViewById(R.id.Newdescription);

        initial();
    }

    private void initial(){
        if(mNewFlower != null){
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.ic_missing);

            Glide.with(getActivity())
                    .setDefaultRequestOptions(options)
                    .load(mNewFlower.getImage())
                    .into(mNewImageView);

            mNewTitle.setText(mNewFlower.getName());
            mNewDescription.setText(mNewFlower.getDescription());
        }
    }


}
