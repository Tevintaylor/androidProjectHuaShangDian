package com.example.huashangdian.DataBasePack;

import android.provider.BaseColumns;

public class FlowersContract {

    private FlowersContract(){

    }

    public static final class FlowersEntry implements BaseColumns {
        public static final String TABLE_NAME = "flowerList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
