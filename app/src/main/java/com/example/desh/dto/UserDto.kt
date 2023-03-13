package com.example.desh.dto

class UserDto {
    data class UserLoginReq(
        val email : String,
        val password : String
    )

    data class UserLoginRes(
        val userId : Int,
        val email : String
    )

    data class UserSignUpReq(
        val email : String,
        val password : String,
        val name : String,
        val sex : String,
        val age : Int
    )
}