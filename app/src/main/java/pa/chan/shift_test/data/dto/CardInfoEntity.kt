package pa.chan.shift_test.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CardInfoEntity (
    @PrimaryKey val id: Int?,
    val number: Any = {
        val length: Int
        val luhn: Boolean
    },
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val country: Any = {
        val numeric: Int
        val alpha2: String
        val name: String
        val emoji: String
        val currency: String
        val latitude: Int
        val longitude: Int
    },
    val bank: Any = {
        val name: String
        val url: String
        val phone: String
        val city: String
    }
)