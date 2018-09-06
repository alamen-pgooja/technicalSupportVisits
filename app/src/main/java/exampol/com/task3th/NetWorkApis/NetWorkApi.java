package exampol.com.task3th.NetWorkApis;

import java.util.List;

import exampol.com.task3th.Models.Visit;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by amen on 31/12/17.
 */

public interface NetWorkApi {
   //get visits
    @GET("GetTasks/")
    Call<Visit> getVisitsById(@Query("id") int visitId);
}
