package dxg.word.test2api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dxg.word.test2api.adapter.RecyclerAdapter;
import dxg.word.test2api.api.ApiGenerator;
import dxg.word.test2api.api.ApiService;
import dxg.word.test2api.model.Test2ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Test2ApiResponse> responsedataList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        apiCall();

    }
    private void apiCall(){
        ApiService apiService = ApiGenerator.createService(ApiService.class);
        Call<List<Test2ApiResponse>> call = apiService.getApiData("India");
        call.enqueue(new Callback<List<Test2ApiResponse>>() {
            @Override
            public void onResponse(Call<List<Test2ApiResponse>> call, Response<List<Test2ApiResponse>> response) {
                if (response.isSuccessful()){
                    if (response.body() != null) {

                        List<Test2ApiResponse> test2ApiResponse = response.body();
                        responsedataList = test2ApiResponse;
                        recyclerAdapter = new RecyclerAdapter(responsedataList, context, new RecyclerAdapter.MyClickListener() {
                            @Override
                            public void onClicked(String link) {
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(link));
                                startActivity(i);
                            }
                        });
                        recyclerView.setAdapter(recyclerAdapter);
                        Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Test2ApiResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}