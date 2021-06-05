package cl.maleb.simpleofflinecaching.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RestaurantData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao
}