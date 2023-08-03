package cl.cat2814.a05retrofitexample.userInterface

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cl.cat2814.a05retrofitexample.data.LandRepository
import cl.cat2814.a05retrofitexample.data.remote.Land
import cl.cat2814.a05retrofitexample.data.remote.RetrofitClientWtf
import kotlinx.coroutines.launch

class LandViewModel(application: Application) : AndroidViewModel(application) {

    private val landRepository: LandRepository
    val liveDataLands = MutableLiveData<List<Land>>()

    init {
        val api = RetrofitClientWtf.getRetrofitClient()
        landRepository = LandRepository(api)
    }

    fun getAllLands() = viewModelScope.launch {
        liveDataLands.value = landRepository.getLand()
    }
}