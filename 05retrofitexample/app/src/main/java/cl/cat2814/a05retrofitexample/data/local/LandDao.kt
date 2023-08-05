package cl.cat2814.a05retrofitexample.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LandDao {
    @Insert
    suspend fun insertLand(land: LandEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLands(lands: List<LandEntity>)

    @Query("SELECT * FROM land_table ORDER BY id ASC")
    fun getAllLands(): LiveData<List<LandEntity>>

    // Creación de query para pedir detalle del terreno desde la Database.
    @Query("SELECT * FROM land_table WHERE id = :id")
    fun getDetailLandFromDatabase(id: String): LiveData<LandEntity>
}