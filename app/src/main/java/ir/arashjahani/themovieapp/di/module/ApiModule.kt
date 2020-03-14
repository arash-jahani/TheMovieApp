package ir.arashjahani.themovieapp.di.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import ir.arashjahani.themovieapp.BuildConfig
import ir.arashjahani.themovieapp.data.remote.ApiService
import ir.arashjahani.themovieapp.utils.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created By ArashJahani on 2020/03/12
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun providesOKHttpClient() : OkHttpClient
    {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .retryOnConnectionFailure(true)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService( retrofit: Retrofit): ApiService
    {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesApiRetrofit(okHttpClient: OkHttpClient, gsonBuilder: GsonBuilder): Retrofit
    {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

}