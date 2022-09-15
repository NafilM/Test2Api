package dxg.word.test2api.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dxg.word.test2api.R;
import dxg.word.test2api.model.Test2ApiResponse;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {


    private List<Test2ApiResponse> dataList;
    private Context mContext;
    MyClickListener myClickListener;


    public RecyclerAdapter(List<Test2ApiResponse> dataList, Context mContext, MyClickListener myClickListener) {
        this.dataList = dataList;
        this.mContext = mContext;
        this.myClickListener = myClickListener;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_recycler_item, parent, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.domain.setText(dataList.get(position).getDomains().get(0));
        holder.alphacode.setText(dataList.get(position).getAlphaTwoCode());
        holder.country.setText(dataList.get(position).getCountry());
        holder.name.setText(dataList.get(position).getName());
        holder.stateProvince.setText(dataList.get(position).getStateProvince());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myClickListener.onClicked(dataList.get(position).getWebPages().get(0));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView domain,alphacode,country,name,stateProvince;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            domain = itemView.findViewById(R.id.domain);
            alphacode = itemView.findViewById(R.id.alpha);
            country = itemView.findViewById(R.id.country);
            name = itemView.findViewById(R.id.name);
            stateProvince = itemView.findViewById(R.id.province);

        }
    }

    public interface MyClickListener {

        void onClicked(String link);

    }
}
