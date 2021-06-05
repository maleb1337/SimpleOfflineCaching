package cl.maleb.simpleofflinecaching.api

import cl.maleb.simpleofflinecaching.data.RestaurantData
import cl.maleb.simpleofflinecaching.utils.GET_RESTAURANTS
import retrofit2.http.GET

interface RestaurantApiService {

    @GET(GET_RESTAURANTS)
    suspend fun getRestaurants(): List<RestaurantData>
}