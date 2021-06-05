package cl.maleb.simpleofflinecaching.di

import android.app.Application
import androidx.room.Room
import cl.maleb.simpleofflinecaching.api.RestaurantApiService
import cl.maleb.simpleofflinecaching.data.AppDatabase
import cl.maleb.simpleofflinecaching.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideRestaurantApi(retrofit: Retrofit): RestaurantApiService =
        retrofit.create(RestaurantApiService::class.java)

    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase =
        Room.databaseBuilder(application, AppDatabase::class.java, "restaurant_database")
            .build()

}