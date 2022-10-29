package com.example.foosball.di

import android.content.Context
import androidx.room.Room
import com.example.foosball.data.db.FoosballDatabase
import com.example.foosball.other.Constants.FOOSBALL_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFoosballDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        FoosballDatabase::class.java,
        FOOSBALL_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideFoosballDao(db: FoosballDatabase) = db.getFoosballDao()
}