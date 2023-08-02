package cl.cat2814.a05retrofitexample.userInterface

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.cat2814.a05retrofitexample.data.LandRepository
import cl.cat2814.a05retrofitexample.data.remote.RetrofitClient
import kotlinx.coroutines.launch

class LandViewModel(application: Application): AndroidViewModel(application) {
    private val landRepository: LandRepository

    init {
        val api = RetrofitClient.getRetrofitClient()
        landRepository = LandRepository(api)
    }

    fun getAllLands() = viewModelScope.launch {
        landRepository.getLand()
    }
}