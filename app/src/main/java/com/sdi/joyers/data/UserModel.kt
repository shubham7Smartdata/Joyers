package com.sdi.joyers.data

import android.util.Patterns
import androidx.room.Entity
import androidx.room.PrimaryKey

class UserModel(
/*
//    constructor(userId: String?, email: String?, name: String?) : this() {
//        this.email = email.toString()
//        this.userId = userId.toString()
//        this.password = name.toString()
//    }
//
//    @PrimaryKey
//    lateinit var userId: String
//
//    lateinit var password: String
//
//    lateinit var email: String
//
//    fun isEmailValid(): Boolean {
//        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
//    }
*/

    val `data`: Data,
    val msg: String
)

data class Data(
    val __v: Int,
    val _createdDate: String,
    val _id: String,
    val _isActive: Boolean,
    val _isDeleted: Boolean,
    val _updatedDate: String,
    val email: String,
    val password: String,
    val role: String,
    val status: String,
    val token: String,
    val userStatus: String
)