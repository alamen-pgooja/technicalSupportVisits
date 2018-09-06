package exampol.com.task3th.Views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import exampol.com.task3th.Models.SITEVISITLISTItem;
import exampol.com.task3th.R;

public class VisitesAdapter extends RecyclerView.Adapter<VisitesAdapter.myViewHolder> {

    List<SITEVISITLISTItem> sitevisitlistItems;
    Context context;
    final String TAG="VisitesAdapter";

    public VisitesAdapter(List<SITEVISITLISTItem> sitevisitlistItems, Context context) {
        this.sitevisitlistItems = sitevisitlistItems;
        this.context = context;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.visit_row, parent, false);

        Log.d(TAG, "onCreateViewHolder");
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        holder.des.setText(sitevisitlistItems.get(position).getVisitDescription());
        holder.date.setText(sitevisitlistItems.get(position).getVisitDate());
        holder.phone.setText(sitevisitlistItems.get(position).getContactNo());
        holder.ContactNo.setText(sitevisitlistItems.get(position).getContactNo());
        holder.MerchantID.setText(sitevisitlistItems.get(position).getMerchantID());
        holder.TicketNo.setText(sitevisitlistItems.get(position).getTicketNo());
        holder.contaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MapsActivity.class);
                intent.putExtra("longitude",sitevisitlistItems.get(position).getLocation().getLongitude());
                intent.putExtra("latitude",sitevisitlistItems.get(position).getLocation().getLatitude());
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return sitevisitlistItems.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView des,date,phone,ContactNo,MerchantID,TicketNo;
        CardView contaner;
        public myViewHolder(View itemView) {
            super(itemView);
            contaner=itemView.findViewById(R.id.contaner);
            des=itemView.findViewById(R.id.des);
            date=itemView.findViewById(R.id.date);
            phone=itemView.findViewById(R.id.phone);
            ContactNo=itemView.findViewById(R.id.ContactNo);
            MerchantID=itemView.findViewById(R.id.MerchantID);
            TicketNo=itemView.findViewById(R.id.TicketNo);

        }
    }
}
