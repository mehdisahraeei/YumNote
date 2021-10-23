package com.mahdi.yumnote.other.recyclerview.adapters;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.mahdi.yumnote.R;
import com.mahdi.yumnote.model.recyclerview.PosterModel;
import java.util.List;



public class CustomAdabter extends RecyclerView.Adapter<CustomAdabter.customView> {


    private static ClickListener clickListener;
    private Context context;
    private List<PosterModel> list;




    public CustomAdabter(Context context, List<PosterModel> list) {
        this.context = context;
        this.list = list;
    }




    @NonNull
    @Override
    public customView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.body_recycler, parent, false);
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



    public class customView extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        
        ImageView PhotoMain,layout;


        public customView(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            PhotoMain = itemView.findViewById(R.id.image_recycler);
            layout = itemView.findViewById(R.id.transpar1);

        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }

    }


    public void setOnItemClickListener(ClickListener clickListener) {
        CustomAdabter.clickListener = clickListener;
    }



    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }



}
