package exampol.com.task3th.Views;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

import exampol.com.task3th.DataBase.VisitDatabase;
import exampol.com.task3th.Models.ServerResponse;
import exampol.com.task3th.Models.Visit;
import exampol.com.task3th.MyTask;
import exampol.com.task3th.NetWorkApis.ApiClient;
import exampol.com.task3th.NetWorkApis.NetWorkApi;
import exampol.com.task3th.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    final String TAG = "MainActivityTag";
    List<Visit> visitList;
    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    private VisitDatabase visitDatabase;
    private String dataBaseName = "mVisit";
    MyTask getTask;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.visitesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mSwipeRefreshLayout = findViewById(R.id.mSwipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        textView=findViewById(R.id.mod);
        ini_db();
        getAllVisits(1);
        getTask=new MyTask(this,dataBaseName,visitDatabase);
    }
//

    private void ini_db() {
        visitDatabase = Room.databaseBuilder(getApplicationContext(),
                VisitDatabase.class, dataBaseName)
                .fallbackToDestructiveMigration()
                .build();
    }


    private void getAllVisits(int visitId) {
        mSwipeRefreshLayout.setRefreshing(true);
        NetWorkApi netWorkApi = ApiClient.getClient(ApiClient.BASE_URL).create(NetWorkApi.class);
        Call<ServerResponse> callVisits = netWorkApi.getVisitsById(1);
        callVisits.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                Log.v(TAG, response.body().toString());

                textView.setText(" OnLine mod".toUpperCase());
                mSwipeRefreshLayout.setRefreshing(false);
                recyclerView.setAdapter(new VisitesAdapter(response.body().getSITEVISITLIST(), MainActivity.this));
                getTask.setOperationType(MyTask.operationList[0]);
                if (getTask.getStatus()!= AsyncTask.Status.FINISHED){
                    getTask.execute();
                }
                try {
                    if (getTask.get().size()==response.body().getSITEVISITLIST().size()){
                        Toast.makeText(MainActivity.this, "no new visits to load", Toast.LENGTH_SHORT).show();
                    }else {
                        insert(response.body().getSITEVISITLIST());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
                Log.v(TAG, t.getLocalizedMessage());
                final Dialog mDialog = new Dialog(MainActivity.this);
                mDialog.setContentView(R.layout.custom_dialog);
                TextView filerText;
                Button filerButton;
                filerButton = mDialog.findViewById(R.id.filerButton);
                filerText = mDialog.findViewById(R.id.filerText);
                filerText.setText(filerText.getText().toString() + "\n" + t.getMessage()+"\n"
                );
                filerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                    }
                });
                loadVisitsFromDb();
                mDialog.show();
            }
        });
        mSwipeRefreshLayout.setRefreshing(false);


    }

    @SuppressLint("SetTextI18n")
    private void loadVisitsFromDb() {
        textView.setText("OffLine mod".toUpperCase());
        getTask.setOperationType(MyTask.operationList[0]);

        if (getTask.getStatus()!= AsyncTask.Status.FINISHED){
            getTask.execute();
        }
        try {

            recyclerView.setAdapter(new VisitesAdapter(getTask.get(),MainActivity.this));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private void insert(final List<Visit> sitevisitlist) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                visitDatabase.daoAccess().insertMultipleVisits(sitevisitlist);
            }
        }).start();
    }

    private void getDataById(final int id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.v(TAG, visitDatabase.daoAccess().fetchOneVisitById(id).toString());
            }
        }).start();

    }
    private void getAll(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.v(TAG, visitDatabase.daoAccess().fetchAllVisits().toString());
            }
        }).start();
    }
    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        getAllVisits(0);

    }

}
