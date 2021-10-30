package com.mahdi.yumnote.other.bottomsheet.etc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.mahdi.yumnote.R;
import com.mahdi.yumnote.other.bottomsheet.Utils.BottomSheet;
import com.mahdi.yumnote.other.bottomsheet.Utils.OnMenuItemClickListener;

public class MoreShow {

    public void show(Context context) {
        final BottomSheet bottomSheet = BottomSheet
                .Builder
                .newBuilder((Activity) context)
                .setItem(new BottomSheet.MenuItem("SourceForge", R.drawable.sourceforge, "https://sourceforge.net"))
                .setItem(new BottomSheet.MenuItem("GitKraken", R.drawable.gitkraken, "https://gitkraken.com"))
                .setItem(new BottomSheet.MenuItem("Beanstalk", R.drawable.beanstalk, "https://beanstalkapp.com"))
                .setItem(new BottomSheet.MenuItem("RhodeCode", R.drawable.rhodecode, "https://rhodecode.com"))

                .build();
        bottomSheet.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onItemClick(BottomSheet.MenuItem item) {
                bottomSheet.dismiss();
                context.startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(item.tag)));

            }
        });

        bottomSheet.show();
    }

}
