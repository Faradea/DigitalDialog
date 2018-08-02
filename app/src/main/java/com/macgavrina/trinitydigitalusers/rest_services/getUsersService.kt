package com.macgavrina.trinitydigitalusers.rest_services

import com.google.gson.GsonBuilder
import com.macgavrina.trinitydigitalusers.model.User
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

const val SERVER_URL:String = "https://a11d.firebaseio.com/"

interface GetUsersService {
    @GET("users.json")
    fun performGetCall(): Single<List<User>>

    companion object ApiFactory{
        fun create():GetUsersService{

            val gson = GsonBuilder().create()

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(SERVER_URL)
                    .build()
            return retrofit.create(GetUsersService::class.java)
        }

    }
}