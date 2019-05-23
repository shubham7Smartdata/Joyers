package com.sdi.joyers.data

import android.util.Patterns
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserModel() {
    constructor(userId: String?, email: String?, name: String?) : this() {
        this.email = email.toString()
        this.userId = userId.toString()
        this.name = name.toString()
    }

    @PrimaryKey
    lateinit var userId: String

    lateinit var name: String

    lateinit var email: String

    fun isEmailValid(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}
