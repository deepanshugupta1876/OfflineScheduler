package deepanshu.example.com.offlinescheduler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import deepanshu.example.com.offlinescheduler.R;
import deepanshu.example.com.offlinescheduler.model.ScheduleData;

public class SchedulerAdapter extends RecyclerView.Adapter<SchedulerAdapter.SchedulerViewHolder> {
    private List<ScheduleData> dataList = new ArrayList<>();

    public SchedulerAdapter(List<ScheduleData> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public SchedulerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedulers,parent, false);
        return new SchedulerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SchedulerViewHolder holder, int position) {
        ScheduleData item = dataList.get(position);
        holder.title.setText(item.getTitle());
        holder.time.setText(getTimeFromTimeStamp(item.getTime()));
    }

    private String getTimeFromTimeStamp(Date time){
        SimpleDateFormat sf = new SimpleDateFormat("hh:mm aa", Locale.getDefault());
        return sf.format(time);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class SchedulerViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView time;

        SchedulerViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.schedule_title);
            time = itemView.findViewById(R.id.schedule_time);
        }
    }

    public void updateList(List<ScheduleData> list){
        dataList.clear();
        dataList.addAll(list);
        notifyDataSetChanged();
    }
}
