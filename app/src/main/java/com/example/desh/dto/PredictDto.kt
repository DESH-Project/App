package com.example.desh.dto

class PredictDto {
    data class Target(
        val gender : Int,
        val age : MutableList<Int> = mutableListOf()
    )

    data class PredictReq(
        val service : String,
        val target : Target,
        val quarterSales : Long,
        val weekdaySales : Long,
        val weekendSales : Long
    )
}