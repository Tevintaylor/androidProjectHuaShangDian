package com.example.huashangdian.views;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huashangdian.DataBasePack.FlowerDBHelper;
import com.example.huashangdian.DataBasePack.FlowersContract;
import com.example.huashangdian.Dialog.CheckOutDialog;
import com.example.huashangdian.Models.CartItemsClass;
import com.example.huashangdian.NewItemsPackage.FlowerAdapter;
import com.example.huashangdian.R;

import java.util.ArrayList;

public class CartView extends AppCompatActivity implements CheckOutDialog.CheckOutDatabaseListener {

    ArrayList<CartItemsClass> CartDataArrayList = new ArrayList<CartItemsClass>();

    private SQLiteDatabase sqLiteDatabase;

//  vriables to store string variables
    String st;
    String des;
    String price;
    String name;

    private LinearLayout cartActivity;
    private LinearLayout newLayout;

    private Button checkOut;


    TextView cartLabel;

    private RecyclerView mRecyclerView;
    private FlowerAdapter flowerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_view);

//        import button wiget
        checkOut = findViewById(R.id.checkOut);

//      Import database helper
        FlowerDBHelper flowerDBHelper = new FlowerDBHelper(this);
        sqLiteDatabase = flowerDBHelper.getWritableDatabase();

//      databse handler
        mRecyclerView = findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        flowerAdapter = new FlowerAdapter(this,getAllItems());

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(flowerAdapter);

        new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(
                        0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT){
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                removeItem((long)viewHolder.itemView.getTag());
            }
        }).attachToRecyclerView(mRecyclerView);

//      importing items from the main view fragment to add to cart
        des = getIntent().getExtras().getString("des");
        price = getIntent().getExtras().getString("price");
        name = getIntent().getExtras().getString("name");

//      Adding Items to the Database
        addItems(name, price, des);


//      importing the viewss needed for recycler view
        mRecyclerView = findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        cartActivity = findViewById(R.id.cartAct);


//      deceleration of text view for no item in cart
        TextView txt = new TextView(this);

//      code to get the information projects passed into the cart when button is pressed
        if (des == null || price == null || name == null) {
            txt.setGravity(1);
            txt.setTextSize(20);
            txt.setPadding(100, 20, 100, 0);
            System.out.print("*******************************************************************");
        }

        st = getIntent().getExtras().getString("username");
        cartLabel = findViewById(R.id.cartLabel);
        cartLabel.setText(st + "'s Cart");

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOut();
            }
        });

    }

    public void removeItem (long id){
        sqLiteDatabase.delete(FlowersContract.FlowersEntry.TABLE_NAME,
                FlowersContract.FlowersEntry._ID + "="+ id, null);
        flowerAdapter.swapCursor(getAllItems());

        String message="Item number " + id + " removed from chart";
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private void addItems(String name,String price,String des){

        if (name=="" || price=="" || des=="" ){
            return;
        }

               ContentValues contentValues = new ContentValues();
        contentValues.put(FlowersContract.FlowersEntry.COLUMN_NAME,name);
        contentValues.put(FlowersContract.FlowersEntry.COLUMN_PRICE,price);
        contentValues.put(FlowersContract.FlowersEntry.COLUMN_DESCRIPTION,des);

        sqLiteDatabase.insert(FlowersContract.FlowersEntry.TABLE_NAME,null,contentValues);

        flowerAdapter.swapCursor(getAllItems());

    }

    private Cursor getAllItems(){
        return sqLiteDatabase.query(
                FlowersContract.FlowersEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                FlowersContract.FlowersEntry.COLUMN_TIMESTAMP + " DESC"
        );
    }

    public void checkOut(){
        Toast.makeText(getApplicationContext(), "Checkout Pressed", Toast.LENGTH_LONG).show();
            CheckOutDialog exampleDialog = new CheckOutDialog();
            exampleDialog.show(getSupportFragmentManager(),"Dialog");
        }

    @Override
    public void Removeitem() {
        sqLiteDatabase.execSQL("delete from "+ FlowersContract.FlowersEntry.TABLE_NAME);

    }

    @Override
    public String returnTotal() {
        int count= (int) DatabaseUtils.longForQuery(sqLiteDatabase, "SELECT COUNT(*) FROM "+FlowersContract.FlowersEntry.TABLE_NAME, null);

        return String.valueOf(st+" you have " +count+ " item(s) in your cart");
    }

    @Override
    public String returnTotalCost() {
        float count= (int) DatabaseUtils.longForQuery(sqLiteDatabase, "SELECT "+"sum(" +FlowersContract.FlowersEntry.COLUMN_PRICE+ ") "+" FROM "+FlowersContract.FlowersEntry.TABLE_NAME, null);

        return String.valueOf(count);
    }

}
