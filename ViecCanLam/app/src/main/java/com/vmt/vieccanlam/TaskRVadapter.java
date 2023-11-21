package com.vmt.vieccanlam;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskRVadapter extends RecyclerView.Adapter<TaskRVadapter.TaskItemViewHolder> {
    List<TASKS> dataSource;

    public TaskRVadapter(List<TASKS> dataSource) {
        this.dataSource = dataSource;
    }

    public final class TaskItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTenVCL;
        TextView tvNgayHetHan;
        public int position;

        public TaskItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvTenVCL = (TextView) itemView.findViewById(R.id.textViewTenVCL);
            tvNgayHetHan = (TextView) itemView.findViewById(R.id.textViewThoiGian);
        }

        @Override
        public void onClick(View v) {
            int vtClicked = getAdapterPosition();
            TASKS taskClicked = dataSource.get(vtClicked);
            Toast.makeText(v.getContext(), "Bạn vừa chọn việc " + taskClicked.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    @Override
    public TaskItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new TaskItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.position = position;
        TASKS task = dataSource.get(position);
        holder.tvTenVCL.setText(task.getName());
        holder.tvNgayHetHan.setText(String.valueOf(task.getDate()));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
