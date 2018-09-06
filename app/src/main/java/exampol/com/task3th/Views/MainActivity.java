package exampol.com.task3th.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import exampol.com.task3th.Models.SITEVISITLISTItem;
import exampol.com.task3th.Models.Visit;
import exampol.com.task3th.NetWorkApis.ApiClient;
import exampol.com.task3th.NetWorkApis.NetWorkApi;
import exampol.com.task3th.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    final String TAG = "MainActivityTag";
    List<SITEVISITLISTItem> visitList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.visitesRecyclerView);
        getAllVisits(1);
    }

    private void getAllVisits(int visitId) {
        NetWorkApi netWorkApi = ApiClient.getClient(ApiClient.BASE_URL).create(NetWorkApi.class);
        Call<Visit> callVisits = netWorkApi.getVisitsById(1);
        callVisits.enqueue(new Callback<Visit>() {
            @Override
            public void onResponse(Call<Visit> call, Response<Visit> response) {
                Log.v(TAG, response.body().toString());
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(new VisitesAdapter(response.body().getSITEVISITLIST(),MainActivity.this));
            }

            @Override
            public void onFailure(Call<Visit> call, Throwable t) {
                Log.v(TAG, t.getLocalizedMessage());

            }
        });

    }
}
