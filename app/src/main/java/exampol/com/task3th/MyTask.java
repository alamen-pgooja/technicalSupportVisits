package exampol.com.task3th;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import exampol.com.task3th.DataBase.VisitDatabase;
import exampol.com.task3th.Models.Visit;

public class MyTask extends AsyncTask<VisitDatabase, Void, List<Visit>> {
    @SuppressLint("StaticFieldLeak")
    private Context context;
    private String dataBaseName;
    List<Visit> visitList;
    private VisitDatabase visitDatabase;
    private String operationType;
    public static final String[] operationList = {
            "selectAll",
            "selectOne",
            "deleteOne",
            "deleteAll"};


    private int visitId;


    public MyTask(Context context,
                  String dataBaseName,
                  VisitDatabase visitDatabase
    ) {
        this.context = context;
        this.dataBaseName = dataBaseName;
        this.visitDatabase = visitDatabase;

    }

    @Override
    protected List<Visit> doInBackground(VisitDatabase... visitDatabasee) {
        if (operationType.equals(operationList[0])) {
            visitList = visitDatabase.daoAccess().fetchAllVisits();
        } else if (operationType.equals(operationList[1])) {
            visitList.add(visitDatabase.daoAccess().fetchOneVisitById(visitId));
        }
        return visitList;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        visitDatabase = Room.databaseBuilder(context,
                VisitDatabase.class, dataBaseName)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Override
    protected void onPostExecute(List<Visit> visitList) {
        super.onPostExecute(visitList);
        if (visitList.size() == 0) {
            Toast.makeText(context, "there no record stored locally in data base", Toast.LENGTH_SHORT).show();
        }
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }
}
