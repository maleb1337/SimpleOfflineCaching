package cl.maleb.simpleofflinecaching.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "restaurantTable")
data class RestaurantData(
    @SerializedName("name")
    @PrimaryKey val name: String,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("logo")
    val logo: String? = null,
    @SerializedName("address")
    val address: String? = null
)