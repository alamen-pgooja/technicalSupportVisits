package exampol.com.task3th.Views;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import exampol.com.task3th.Models.SITEVISITLISTItem;
import exampol.com.task3th.Models.Visit;
import exampol.com.task3th.NetWorkApis.ApiClient;
import exampol.com.task3th.NetWorkApis.NetWorkApi;
import exampol.com.task3th.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    final String TAG = "MainActivityTag";
    List<SITEVISITLISTItem> visitList;
    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.visitesRecyclerView);
        mSwipeRefreshLayout= findViewById(R.id.mSwipeRefreshLayout);
        getAllVisits(1);
    }
//




    private void getAllVisits(int visitId) {
        mSwipeRefreshLayout.setRefreshing(true);
        NetWorkApi netWorkApi = ApiClient.getClient(ApiClient.BASE_URL).create(NetWorkApi.class);
        Call<Visit> callVisits = netWorkApi.getVisitsById(1);
        callVisits.enqueue(new Callback<Visit>() {
            @Override
            public void onResponse(Call<Visit> call, Response<Visit> response) {
                Log.v(TAG, response.body().toString());
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(new VisitesAdapter(response.body().getSITEVISITLIST(),MainActivity.this));
                mDaoSession.getUserDao().inset(response.body());
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFailure(Call<Visit> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
                Log.v(TAG, t.getLocalizedMessage());
                final Dialog mDialog=new Dialog(MainActivity.this);
                mDialog.setContentView(R.layout.custom_dialog);
                TextView filerText;
                Button filerButton;
                filerButton=mDialog.findViewById(R.id.filerButton);
                filerText=mDialog.findViewById(R.id.filerText);
                filerText.setText(filerText.getText().toString()+"\n"+t.getMessage());
                filerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                    }
                });
                /*
                * https://github.com/greenrobot/greenDAO/issues/369
                *
                * */
                mDialog.show();
            }
        });
        mSwipeRefreshLayout.setRefreshing(false);
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        getAllVisits(0);

    }
}
