package com.android.baseapp.data.local.lsp

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    @Singleton
    fun provideLocalSharedPreferences(@ApplicationContext context: Context): LocalSharedPreferences {
        return LocalSharedPreferences.getInstance(context)
    }
}
