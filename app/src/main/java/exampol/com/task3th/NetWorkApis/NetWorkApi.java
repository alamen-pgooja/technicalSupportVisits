package exampol.com.task3th.NetWorkApis;

import exampol.com.task3th.Models.ServerResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by amen on 31/12/17.
 */

public interface NetWorkApi {
   //get visits
    @GET("GetTasks/")
    Call<ServerResponse> getVisitsById(@Query("id") int visitId);
}
