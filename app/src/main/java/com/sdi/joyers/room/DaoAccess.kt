package com.sdi.joyers.room

import androidx.room.*
import com.sdi.joyers.data.UserModel

@Dao
interface DaoAccess {

    @Query("Select * From UserModel where userId =:id")
    fun getUser(id: String): UserModel

    @Insert
    fun insert(note: UserModel)

    @Update
    fun update(note: UserModel)

    @Delete
    fun delete(note: UserModel)

    @Query("DELETE FROM UserModel")
    fun deleteAllUsers()
}
