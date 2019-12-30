package com.example.huashangdian.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.huashangdian.R;

public class CheckOutDialog extends AppCompatDialogFragment {
    private TextView itemAmount;
    private TextView totalCost;

    private CheckOutDatabaseListener checkOutDatabaseListener;

    private SQLiteDatabase sqLiteDatabase;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder((getActivity()));

        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.check_out_popup, null);

        builder.setView(view)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        checkOutDatabaseListener.Removeitem();
                    }
                });

        itemAmount = view.findViewById(R.id.itemAmount);
        totalCost = view.findViewById(R.id.totalCost);

        itemAmount.setText(checkOutDatabaseListener.returnTotal());
        totalCost.setText("Your total check out cost is "+checkOutDatabaseListener.returnTotalCost());

        return builder.create();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            checkOutDatabaseListener = (CheckOutDatabaseListener) context;
        } catch (ClassCastException e) {
           throw new ClassCastException(context.toString()+"must implent CheckOutListener");
        }
    }

    public interface CheckOutDatabaseListener{
        void Removeitem();
        String returnTotal();
        String returnTotalCost();
    }

}
