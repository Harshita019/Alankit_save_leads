package com.example.alankit_leads;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitAPI {

    @FormUrlEncoded
    @POST("Save")
    Call<Post> getUser(@Field("Name") String name,
                       @Field("Email") String email,
                       @Field("Mobile") String mobile,
                       @Field("Company") String company,
                       @Field("Designation") String designation,
                       @Field("State") String state,
                       @Field("Address") String address);

    @FormUrlEncoded
    @POST("Logincheck")
    Call<UserResponse> UserDetail (@Field("Userid") String userid,
                                   @Field("Userpass") String userpass,
                                   @Field("Lastlogin") String lastlogin);
}

