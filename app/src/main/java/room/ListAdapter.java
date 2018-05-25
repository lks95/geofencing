package room;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adesso.lklein.geofencing.R;

import java.util.List;

import room.addValues.addArbeiter;
import room.addValues.addprojekt;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    class ListHolder extends RecyclerView.ViewHolder{
            private final TextView itemview;

            private ListHolder(View ItemView){
                super(ItemView);
                //xml layout fuer listholder
                itemview = ItemView.findViewById(R.id.textView);
            }

    }

    private LayoutInflater Inflater;
    private List<addArbeiter> arbeiters;
    private List<addprojekt> projekte;

    ListAdapter(Context context){
        Inflater = LayoutInflater.from(context);

    }


    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //recylcerview als erste eingabe
        View itemView = Inflater.inflate(R.layout.recylcerviewroom, parent, false);
        return new ListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHolder holder, int position) {
        if(arbeiters != null && projekte != null){
            addArbeiter aA = arbeiters.get(position);
            addprojekt aP = projekte.get(position);
        } else{
            holder.itemview.setText("Nothing entered");
        }
    }

    void setArbeiters(List<addArbeiter> arbeiterz){
        arbeiters = arbeiterz;
        notifyDataSetChanged();
    }

    void setProjekte(List<addprojekt> projektez){
        projekte = projektez;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(arbeiters != null){
           return arbeiters.size();
        } if(projekte != null){
            return projekte.size();
        } else {
            return 0;
        }
    }


}
