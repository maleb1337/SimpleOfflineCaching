package cl.maleb.simpleofflinecaching.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurantTable")
    fun getAllRestaurants(): Flow<List<RestaurantData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurants(restaurantData: List<RestaurantData>)

    @Query("DELETE FROM restaurantTable")
    suspend fun deleteAllRestaurants()


}