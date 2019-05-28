package com.sdi.joyers.room

import androidx.room.*
import com.sdi.joyers.data.UserModel

@Dao
interface DaoAccess {

    @Query("Select * From user_model where _id =:id")
    fun getUser(id: String): UserModel.DataBean

    @Insert
    fun insert(note: UserModel.DataBean)

    @Update
    fun update(note: UserModel.DataBean)

    @Delete
    fun delete(note: UserModel.DataBean)

    @Query("DELETE FROM user_model")
    fun deleteAllUsers()
}
