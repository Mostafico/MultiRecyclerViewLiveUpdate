package com.devgeeks.multirecyclerviewliveupdate

data class Order(val status: String, val id: String){
    constructor() : this("", "")
}