package pa.chan.shift_test.data

import pa.chan.shift_test.data.dto.CardInfoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CardInfoApi {

    @GET("/{bin}")
    suspend fun getCardInfo(@Path(value = "bin") bin: Int): CardInfoDto
}