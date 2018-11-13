package com.vinsofts.apisecond.remote;

import com.vinsofts.apisecond.model.ContactsRespone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIs {

    @GET("2.2/answers?order=desc&sort=activity&site=stackoverflow")
    Call<ContactsRespone> getData(@Query("tagged") String tags);

    @GET("2.2/answers?order=desc&sort=activity&site=stackoverflow")
    Call<ContactsRespone> getRespone();

//    @GET("2.2/answers?order=desc&sort=activity&site=stackoverflow")
//    Call<ContactsRespone> getWeb(@Query("tagged") String tags);
//
//    @GET("2.2/answers?order=desc&sort=activity&site=stackoverflow")
//    Call<ContactsRespone> getJava(@Query("tagged") String tags);
}
