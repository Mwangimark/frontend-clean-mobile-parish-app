// model/UserResponse.kt
package com.parishapp.mobile.model

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
    val role: String,
    val profileImageUrl: String?,
    val createdAt: String,
    val updatedAt: String
)

// model/RegisterRequest.kt
data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String
)
