// data/UserApi.kt
package com.parishapp.mobile.data

import com.parishapp.mobile.model.RegisterRequest
import com.parishapp.mobile.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @POST("users/register")
    suspend fun register(@Body request: RegisterRequest): UserResponse

    @GET("users")
    suspend fun getUsers(): List<UserResponse>
}
