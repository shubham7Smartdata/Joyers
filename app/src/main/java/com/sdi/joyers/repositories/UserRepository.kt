package com.sdi.joyers.repositories

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sdi.joyers.data.UserModel
import com.sdi.joyers.room.DaoAccess
import com.sdi.joyers.room.RoomDb

class UserRepository(application: Application) {

    private val daoAccess: DaoAccess

    init {
        val database = RoomDb.getInstance(application)
        daoAccess = database.noteDao()
    }

    fun insert(note: UserModel) {
        InsertNoteAsyncTask(daoAccess).execute(note)
    }

    private class InsertNoteAsyncTask constructor(private val daoAccess: DaoAccess):
        AsyncTask< UserModel, Void, Void>() {

        override fun doInBackground(vararg notes:  UserModel): Void? {
            daoAccess.insert(notes[0])
            return null
        }
    }

}
