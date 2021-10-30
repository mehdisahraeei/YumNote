package com.mahdi.yumnote.ui.main.fragments.clicks.note;



import android.content.Context;
import com.mahdi.yumnote.other.bottomsheet.etc.MoreShow;



public class NoteClicks {


    private Context context;



    public NoteClicks(Context context) {
        this.context = context;
    }



    public void GithubClick()
    { }


    public void GitlabClick()
    {

    }



    public void BitbucketClick()
    {

    }




    public void MoreItemClick()
    {
        new MoreShow().show(context);
    }


}
