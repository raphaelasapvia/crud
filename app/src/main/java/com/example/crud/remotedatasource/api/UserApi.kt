package com.example.crud.remotedatasource.api

import com.example.crud.remotedatasource.response.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserApi {
    @POST("users")
    suspend fun createUser(@Body userItem: UserResponse): Response<UserResponse>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): Response<UserResponse>

    @GET("users")
    suspend fun getAllUsers(): Response<List<UserResponse>>

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") id: Int, @Body userItem: UserResponse): Response<UserResponse>

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") id: Int) : Response<Unit>
}