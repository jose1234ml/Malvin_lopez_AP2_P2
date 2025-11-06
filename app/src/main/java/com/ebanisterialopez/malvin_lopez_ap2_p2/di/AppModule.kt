package com.ebanisterialopez.malvin_lopez_ap2_p2.di

import com.ebanisterialopez.malvin_lopez_ap2_p2.data.remote.api.GastoApi
import com.ebanisterialopez.malvin_lopez_ap2_p2.data.repository.GastoRepositoryImpl
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.repository.GastoRepository
import com.ebanisterialopez.malvin_lopez_ap2_p2.domain.usecase.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://gestionhuacalesapi.azurewebsites.net/api/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    @Singleton
    fun provideGastoApi(retrofit: Retrofit): GastoApi =
        retrofit.create(GastoApi::class.java)

    @Provides
    @Singleton
    fun provideGastoRepository(api: GastoApi): GastoRepository =
        GastoRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetGastosUseCase(repository: GastoRepository) = GetGastoUseCase(repository)

    @Provides
    @Singleton
    fun provideCreateGastoUseCase(repository: GastoRepository) = CreateGastoUseCase(repository)

    @Provides
    @Singleton
    fun provideUpdateGastoUseCase(repository: GastoRepository) = UpdateGastoUseCase(repository)

}