package cl.maleb.simpleofflinecaching.features.restaurants

import androidx.lifecycle.*
import cl.maleb.simpleofflinecaching.api.RestaurantApiService
import cl.maleb.simpleofflinecaching.data.RestaurantData
import cl.maleb.simpleofflinecaching.data.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {

//    private val restaurantLiveData = MutableLiveData<List<RestaurantData>>()
//    val restaurants: LiveData<List<RestaurantData>> = restaurantLiveData
//
//
//    init {
//        viewModelScope.launch {
//            val restaurants = apiService.getRestaurants()
//            restaurantLiveData.value = restaurants
//        }
//    }

    val restaurants = repository.getRestaurants().asLiveData()


}