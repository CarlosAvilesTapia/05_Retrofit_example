package cl.cat2814.a05retrofitexample.userInterface.viewModel

import android.app.Application
import android.icu.text.NumberFormat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.cat2814.a05retrofitexample.data.LandRepository
import cl.cat2814.a05retrofitexample.data.local.LandDatabase
import cl.cat2814.a05retrofitexample.data.remote.RetrofitClientWtf
import kotlinx.coroutines.launch
import java.util.Locale

class LandViewModel(application: Application) : AndroidViewModel(application) {

    private val landRepository: LandRepository
    fun liveDataLands() = landRepository.getLands()

    // Creación de función que trae datos de terreno desde el repositorio.
    fun liveDataLandFromRepository(id: String) = landRepository.getLandFromDao(id)

    init {
        val api = RetrofitClientWtf.getRetrofitClient()
        val landDatabase = LandDatabase.getDatabase(application).getLandsDao()
        landRepository = LandRepository(api, landDatabase)
    }

    fun getAllLands() = viewModelScope.launch {
        landRepository.loadLands()
    }

    // Función para formatear Int del precio a un String en formato moneda.
    fun getPriceFormat(price: Int): String {
        val currency: NumberFormat = NumberFormat.getCurrencyInstance(Locale("en", "US"))
        return currency.format(price)
    }
}