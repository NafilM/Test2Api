package dxg.word.test2api.api;

import java.util.List;

import dxg.word.test2api.model.Test2ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("search?")
    Call<List<Test2ApiResponse>> getApiData(@Query("country") String country);

}
