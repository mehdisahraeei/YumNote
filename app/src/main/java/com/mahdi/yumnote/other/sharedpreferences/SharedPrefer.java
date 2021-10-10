package com.mahdi.yumnote.other.sharedpreferences;



import android.content.Context;
import android.content.SharedPreferences;
import com.mahdi.yumnote.R;



public class SharedPrefer {


    private SharedPreferences sharedPreferences;
    private Context context;





    public SharedPrefer(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_key), context.MODE_PRIVATE);
    }





    public boolean isUserLogin() {
        return sharedPreferences.getBoolean(context.getString(R.string.isNameOfUser), false);
    }




    public void UpdateUser(boolean status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getString(R.string.isNameOfUser), status);
        editor.apply();
    }


    public void UserContents(String user , String pass) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.User_Shared),user);
        editor.putString(context.getString(R.string.Pass_Shared),pass);
        editor.apply();
    }


    public String ValueUser() {
        return sharedPreferences.getString(context.getString(R.string.User_Shared),"user");
    }


    public String ValuePass() {
        return sharedPreferences.getString(context.getString(R.string.Pass_Shared),"pass");
    }





}
