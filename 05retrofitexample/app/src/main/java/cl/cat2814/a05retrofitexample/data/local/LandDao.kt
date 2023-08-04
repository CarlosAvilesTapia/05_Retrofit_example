package cl.cat2814.a05retrofitexample.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LandDao {
    @Insert
    suspend fun insertLand(land: LandEntity)

    @Query("SELECT * FROM land_table ORDER BY id ASC")
    fun getAllLands(): LiveData<List<LandEntity>>
}