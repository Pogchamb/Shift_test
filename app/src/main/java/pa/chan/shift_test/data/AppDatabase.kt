package pa.chan.shift_test.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pa.chan.shift_test.data.dto.CardInfoEntity
import pa.chan.shift_test.data.dto.typeConverter.EntityConverter

@Database(entities = [CardInfoEntity::class], version = 1)
@TypeConverters(EntityConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun cardInfoDao(): CardInfoDao
}