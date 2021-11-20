package com.learnandroid.utspemogramanmobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    private ArrayList<TransactionModel> dataList;

    public TransactionAdapter(ArrayList<TransactionModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_transaction, viewGroup, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder transactionViewHolder, int i) {
        transactionViewHolder.tvCategory.setText(dataList.get(i).getCategory());
        transactionViewHolder.tvTitle.setText(dataList.get(i).getTitle());
        transactionViewHolder.tvAmount.setText(Integer.toString(dataList.get(i).getAmount()));
        transactionViewHolder.tvDate.setText(new SimpleDateFormat("dd/MM/yyy").format(dataList.get(i).getDate()));
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCategory, tvTitle, tvAmount, tvDate;
        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_category);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvAmount = (TextView) itemView.findViewById(R.id.tv_amount);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
        }
    }
}
