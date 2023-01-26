package pa.chan.shift_test.data.dto.typeConverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import pa.chan.shift_test.data.dto.BankEntity
import pa.chan.shift_test.data.dto.CountryEntity
import pa.chan.shift_test.data.dto.NumberEntity

class EntityConverter {

    @TypeConverter
    fun fromNumberEntityToGson(numberEntity: NumberEntity) : String  {
        return Gson().toJson(numberEntity)
    }

    @TypeConverter
    fun fromGsonToNumberEntity(stringNumberEntity: String) : NumberEntity {
        return Gson().fromJson(stringNumberEntity, NumberEntity::class.java)
    }

    @TypeConverter
    fun fromCountryEntityToGson(countryEntity: CountryEntity) : String  {
        return Gson().toJson(countryEntity)
    }

    @TypeConverter
    fun fromGsonToCountryEntity(stringCountryEntity: String) : CountryEntity {
        return Gson().fromJson(stringCountryEntity, CountryEntity::class.java)
    }

    @TypeConverter
    fun fromBankEntityToGson(bankEntity: BankEntity) : String  {
        return Gson().toJson(bankEntity)
    }

    @TypeConverter
    fun fromGsonToBankEntity(stringBankEntity: String) : BankEntity {
        return Gson().fromJson(stringBankEntity, BankEntity::class.java)
    }


}