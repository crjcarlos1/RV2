package droid.demos.com.recyclerviewwithradiobuttons.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import droid.demos.com.recyclerviewwithradiobuttons.R;
import droid.demos.com.recyclerviewwithradiobuttons.models.Month;

public class AdapterMonth extends RecyclerView.Adapter<AdapterMonth.DataObjectHolder> {

    private List<Month> monthList;
    private static SetOnClickListener listener;

    public AdapterMonth(List<Month> monthList) {
        this.monthList = monthList;
    }

    public void changedData(int position) {
        if (monthList.get(position).getSelected()) {
            monthList.get(position).setSelected(false);
        } else {
            monthList.get(position).setSelected(true);
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(SetOnClickListener myClickListener) {
        this.listener = myClickListener;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.txvMonth.setText(monthList.get(position).getTitle());
        holder.rbtnMonth.setChecked(monthList.get(position).getSelected());
    }

    @Override
    public int getItemCount() {
        return monthList.size();
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txvMonth;
        private RadioButton rbtnMonth;

        DataObjectHolder(View itemView) {
            super(itemView);
            txvMonth = (TextView) itemView.findViewById(R.id.txvMonth);
            rbtnMonth = (RadioButton) itemView.findViewById(R.id.rbtnMonth);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition(), v);
        }
    }

    public interface SetOnClickListener {
        void onItemClick(int position, View v);
    }

}
