package com.mahdi.yumnote.other.bottomsheet.etc;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.other.bottomsheet.Utils.BottomSheet;
import com.mahdi.yumnote.other.bottomsheet.Utils.OnMenuItemClickListener;



public class sheetShow {


    private Context context;


    public sheetShow(Context context) {
        this.context = context;
    }



    public void GithubShow() {
        final BottomSheet bottomSheet = BottomSheet
                .Builder
                .newBuilder((Activity) context)
                .setItem(new BottomSheet.MenuItem("Website", R.drawable.www, "https://github.com"))
                .setItem(new BottomSheet.MenuItem("App Store", R.drawable.appstore, "https://apps.apple.com/us/app/github/id1477376905"))
                .setItem(new BottomSheet.MenuItem("Google play", R.drawable.googleplay, "https://play.google.com/store/apps/details?id=com.github.android&hl=en&gl=US"))
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



    public void GitLabShow() {
        final BottomSheet bottomSheet = BottomSheet
                .Builder
                .newBuilder((Activity) context)
                .setItem(new BottomSheet.MenuItem("Website", R.drawable.www, "https://about.gitlab.com"))
                .setItem(new BottomSheet.MenuItem("App Store", R.drawable.appstore, "https://apps.apple.com/us/app/gitlab-control/id654747119"))
                .setItem(new BottomSheet.MenuItem("Google play", R.drawable.googleplay, "https://play.google.com/store/apps/details?id=com.commit451.gitlab&hl=en&gl=US"))
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




    public void BitbucketShow() {
        final BottomSheet bottomSheet = BottomSheet
                .Builder
                .newBuilder((Activity) context)
                .setItem(new BottomSheet.MenuItem("Website", R.drawable.www, "https://bitbucket.org/product"))
                .setItem(new BottomSheet.MenuItem("App Store", R.drawable.appstore, "https://apps.apple.com/us/app/gitapp-for-bitbucket/id1499512663"))
                .setItem(new BottomSheet.MenuItem("Google play", R.drawable.googleplay, "https://play.google.com/store/apps/details?id=in.co.aashish.bit_git&hl=en&gl=US"))
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



    public void MoreShow() {
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
