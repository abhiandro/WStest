package com.webspider.webspidertest.network;




import com.webspider.webspidertest.model.JsonResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    @GET("api/")
    Call<JsonResponse> JSON_RESPONSE_CALL (@Query("results") int number );



}
