package com.mahdi.yumnote.other.recyclerview.adapters;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.model.recyclerview.PosterModel;
import java.util.List;



public class CustomAdabter extends RecyclerView.Adapter<CustomAdabter.customView> {

    private Context context;
    private List<PosterModel> list;




    public CustomAdabter(Context context, List<PosterModel> list) {
        this.context = context;
        this.list = list;
    }




    @NonNull
    @Override
    public customView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.body_recyclerview, parent, false);
        return new customView(view);
    }



    @Override
    public void onBindViewHolder(@NonNull customView holder, int position) {

        PosterModel model = list.get(position);
        Glide.with(context)
                .load(model.getPhotojson())
                .into(holder.PhotoMain);

    }



    @Override
    public int getItemCount() {
        return list.size();
    }




    public class customView extends RecyclerView.ViewHolder {

        RelativeLayout layout;
        ImageView PhotoMain;

        public customView(@NonNull View itemView) {
            super(itemView);

            PhotoMain = itemView.findViewById(R.id.image_recycler);
            layout = itemView.findViewById(R.id.layout_recycler);
        }
    }



}
