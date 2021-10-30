package com.mahdi.yumnote.ui.main.fragments.clicks.note;



import android.content.Context;
import com.mahdi.yumnote.other.bottomsheet.etc.sheetShow;



public class NoteClicks {


    private Context context;



    public NoteClicks(Context context) {
        this.context = context;
    }



    public void GithubClick()
    {
        new sheetShow(context).GithubShow();
    }



    public void GitlabClick()
    {
        new sheetShow(context).GitLabShow();
    }



    public void BitbucketClick()
    {
        new sheetShow(context).BitbucketShow();
    }




    public void MoreItemClick()
    {
        new sheetShow(context).MoreShow();
    }


}
