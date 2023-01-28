package pa.chan.shift_test.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pa.chan.shift_test.data.dto.CardInfoEntity

@Dao
interface CardInfoDao {

    @Query("SELECT * FROM cardinfoentity")
    suspend fun getAll(): List<CardInfoEntity>

    @Insert
    suspend fun insert(cardInfo: CardInfoEntity)
}