package cl.maleb.simpleofflinecaching.data.repository

import androidx.room.withTransaction
import cl.maleb.simpleofflinecaching.api.RestaurantApiService
import cl.maleb.simpleofflinecaching.data.AppDatabase
import cl.maleb.simpleofflinecaching.utils.networkBoundResource
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val apiService: RestaurantApiService,
    private val appDatabase: AppDatabase
) {
    private val restaurantDao = appDatabase.restaurantDao()


    fun getRestaurants() = networkBoundResource(
        databaseQuery = {
            restaurantDao.getAllRestaurants()
        },
        networkCall = {
            apiService.getRestaurants()
        },
        saveCallResult = { restaurants ->
            appDatabase.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(restaurants)
            }
        }
    )
}