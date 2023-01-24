package pa.chan.shift_test.data

import pa.chan.shift_test.data.dto.CardInfoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CardInfoApi {

    @GET("info")
    suspend fun getCardInfo(@Query("bin") bin: Int): CardInfoDto
}