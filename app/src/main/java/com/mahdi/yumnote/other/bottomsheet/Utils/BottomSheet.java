package com.mahdi.yumnote.other.bottomsheet.Utils;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mahdi.yumnote.R;
import java.util.ArrayList;
import java.util.List;


public class BottomSheet extends Dialog {


    private static final String TAG = "BottomSheet";
    private static final int MAX_ITEM_COUNT = 8;
    private View container;
    private Activity context;
    private List<MenuItem> items;
    private OnMenuItemClickListener listener;



    public BottomSheet(Activity context, List<MenuItem> items){
        super(context);

        this.context = context;
        this.items = items;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        configSheet();

        createItem(items);
    }



    public void setOnMenuItemClickListener(OnMenuItemClickListener listener){
        this.listener = listener;
    }



    private void createItem(List<MenuItem> items) {
        LinearLayout itemContainer = (LinearLayout)container.findViewById(R.id.menu_item_container);

        if(items == null){
            Log.e(TAG, "items cannot be null!");
            return;
        }
        if(items.size() > MAX_ITEM_COUNT){
            Log.e(TAG, "item's count cannot be more than 8!");
            return;
        }

        int rowCount = items.size() / 5 + 1;

        for(int i = 0;i < rowCount;i++){
            final LinearLayout row = new LinearLayout(context);
            itemContainer.addView(row,i);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) row.getLayoutParams();
            params.width = LinearLayout.LayoutParams.MATCH_PARENT;
            params.height = new DensityUtils().dip2px(context,110);
            row.setLayoutParams(params);
            row.setOrientation(LinearLayout.HORIZONTAL);

            int index = 0;

            for(int j= 0 ;j < items.size();j++){
                if(j / MAX_ITEM_COUNT == i){
                    final MenuItem item = items.get(j);
                    RelativeLayout rl = new RelativeLayout(context);
                    row.addView(rl,index++);
                    LinearLayout.LayoutParams rlParams = (LinearLayout.LayoutParams) rl.getLayoutParams();
                    rlParams.width = 0;
                    rlParams.height = LinearLayout.LayoutParams.MATCH_PARENT;
                    rlParams.weight = 4;
                    rl.setLayoutParams(rlParams);
                    rl.setClickable(true);
                    rl.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(listener != null){
                                listener.onItemClick(item);
                            }
                        }
                    });

                    ImageView icon = new ImageView(context);
                    rl.addView(icon);
                    RelativeLayout.LayoutParams iconParam = (RelativeLayout.LayoutParams) icon.getLayoutParams();
                    iconParam.width = new DensityUtils().dip2px(context,45);
                    iconParam.height = new DensityUtils().dip2px(context,45);
                    iconParam.topMargin = new DensityUtils().dip2px(context,16);
                    iconParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    icon.setLayoutParams(iconParam);
                    icon.setId(index);
                    icon.setImageResource(item.icon);

                    TextView desc = new TextView(context);
                    rl.addView(desc);
                    RelativeLayout.LayoutParams descParam = (RelativeLayout.LayoutParams) desc.getLayoutParams();
                    descParam.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
                    descParam.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
                    descParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    descParam.addRule(RelativeLayout.BELOW,icon.getId());
                    descParam.topMargin = new DensityUtils().dip2px(context,12);
                    desc.setLayoutParams(descParam);
                    desc.setTextSize(15);
                    desc.setText(item.name);
                }
            }
        }
    }



    private void configSheet() {
        setContentView(R.layout.layout_bottom_sheet);

        container = findViewById(R.id.menu_main_container);

        Window window = getWindow();
        WindowManager m = window.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = window.getAttributes();
        p.width = d.getWidth();
        window.setAttributes(p);
        window.setGravity(Gravity.BOTTOM);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setWindowAnimations(R.style.bottomSheetAnim);

        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet.this.dismiss();
            }
        });

    }




    public static class Builder{

        private List<MenuItem> items;
        private Activity context;

        public Builder(Activity context) {
            this.context = context;
        }

        public static Builder newBuilder(Activity context){
            return new Builder(context);
        }

        public BottomSheet build(){
            return new BottomSheet(context,items);
        }

        public Builder setItem(MenuItem item){
            if(items == null){
                items = new ArrayList<>();
            }
            items.add(item);

            return this;
        }
    }




    public static class MenuItem{
        public String name;
        public int icon;
        public String tag;

        public MenuItem(String name,int icon){
            this(name,icon,name);
        }

        public MenuItem(String name,int icon,String tag){
            this.name = name;
            this.icon = icon;
            this.tag = tag;
        }
    }



}