package com.jenin.jetpackcomposenoteapp.di

import android.app.Application
import androidx.room.Room
import com.jenin.jetpackcomposenoteapp.data.NoteDataBaseDao
import com.jenin.jetpackcomposenoteapp.local.AppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideAppDb(application: Application):AppDb {
        return Room.databaseBuilder(application,AppDb::class.java,"Note_Db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(appDb: AppDb):NoteDataBaseDao{
        return appDb.noteDao()
    }


}