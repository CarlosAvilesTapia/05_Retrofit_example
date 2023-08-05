package cl.cat2814.a05retrofitexample.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "land_table")
data class LandEntity(
    @PrimaryKey val id: String,
    val price: Int,
    val type: String,
    val imgUrl: String
)

