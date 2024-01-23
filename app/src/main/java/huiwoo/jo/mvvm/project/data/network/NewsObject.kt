package huiwoo.jo.mvvm.project.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsObject {
    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor())
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/top-headlines?country=kr&apiKey=")
        .client(okHttp)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val githubService: NewsService = retrofit.create(NewsService::class.java)
}