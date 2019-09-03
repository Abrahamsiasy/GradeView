package com.arkham.gradeview.gradeview;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arkham.gradeview.R;

import java.util.List;



public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.GradeViewHolder> {
    private Context mCtx;
    private List<Grade> gradeList;

    public GradeAdapter(Context mCtx, List<Grade> gradeList) {
        this.mCtx = mCtx;
        this.gradeList = gradeList;

    }

    @NonNull
    @Override
    public GradeAdapter.GradeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.grade_list, null);
        return new GradeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GradeAdapter.GradeViewHolder holder, int position) {
        Grade grade = gradeList.get(position);
        holder.textViewSubject.setText(grade.getSubject());
        holder.textViewGrade.setText(grade.getGrade());
        holder.textViewEcts.setText(String.valueOf(grade.getEcts()) + " ECTS");
        holder.textViewChours.setText(String.valueOf(grade.getChours()) + "  CH");
        holder.textViewType.setText(String.valueOf(grade.getType()));

    }

    @Override
    public int getItemCount() {
        return gradeList.size();
    }

    public class GradeViewHolder extends RecyclerView.ViewHolder{
        TextView textViewSubject, textViewGrade, textViewEcts, textViewChours;
        TextView textViewType;
        public GradeViewHolder(@NonNull View gradeView) {
            super(gradeView);

            textViewSubject = itemView.findViewById(R.id.textViewSubject);
            textViewGrade = itemView.findViewById(R.id.textViewGrade);
            textViewEcts = itemView.findViewById(R.id.textViewEcts);
            textViewChours = itemView.findViewById(R.id.textViewChours);
            textViewType = itemView.findViewById(R.id.textViewType);
        }
    }
}

