package pa.chan.shift_test.data

import androidx.room.Database
import androidx.room.RoomDatabase
import pa.chan.shift_test.data.dto.CardInfoEntity

@Database(entities = [CardInfoEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cardInfoDao(): CardInfoDao
}