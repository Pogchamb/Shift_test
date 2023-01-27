package pa.chan.shift_test.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pa.chan.shift_test.data.AppDatabase
import pa.chan.shift_test.data.CardInfoApi
import pa.chan.shift_test.data.CardInfoDao
import pa.chan.shift_test.data.CardRepositoryImpl
import pa.chan.shift_test.domain.CardRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {


    companion object {
        private const val url = "https://lookup.binlist.net"

        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        }

        @Provides
        @Singleton
        fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun provideCardInfoApi(retrofit: Retrofit): CardInfoApi =
            retrofit.create(CardInfoApi::class.java)

        @Provides
        @Singleton
        fun provideDataBase(@ApplicationContext context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "card-database").build()
        }

        @Provides
        @Singleton
        fun provideCardInfoDao(appDatabase: AppDatabase) = appDatabase.cardInfoDao()
    }

    @Binds
    abstract fun bindCardRepository(cardRepositoryImpl: CardRepositoryImpl): CardRepository


}