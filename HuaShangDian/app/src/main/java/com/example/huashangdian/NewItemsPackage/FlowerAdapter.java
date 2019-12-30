package com.example.huashangdian.NewItemsPackage;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huashangdian.DataBasePack.FlowersContract;
import com.example.huashangdian.R;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder> {

    private Context mContext;
    private Cursor mCursor;

    public FlowerAdapter(Context context, Cursor cursor){
        mContext = context;
        mCursor = cursor;
    }


    public class FlowerViewHolder extends RecyclerView.ViewHolder{
        public TextView nameFlower;
        public TextView price;
        public TextView description;

        public ImageView removeCart2;

        public FlowerViewHolder(@NonNull View itemView) {
            super(itemView);

            nameFlower = itemView.findViewById(R.id.flowerName);
            price = itemView.findViewById(R.id.flowerPrice);
            description = itemView.findViewById(R.id.flowerDes);

        }
    }

    @NonNull
    @Override
    public FlowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.cart_items,parent,false);
        return new FlowerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)){
            return;
        }

        String name = mCursor.getString(mCursor.getColumnIndex(FlowersContract.FlowersEntry.COLUMN_NAME));
        String price = mCursor.getString(mCursor.getColumnIndex(FlowersContract.FlowersEntry.COLUMN_PRICE));
        String des = mCursor.getString(mCursor.getColumnIndex(FlowersContract.FlowersEntry.COLUMN_DESCRIPTION));
        long id = mCursor.getLong(mCursor.getColumnIndex(FlowersContract.FlowersEntry._ID));

        holder.nameFlower.setText(name);
        holder.price.setText(price);
        holder.description.setText(des);
        holder.itemView.setTag(id);

    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor){
        if (mCursor != null){
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null){
            notifyDataSetChanged();
        }

        }
    }

