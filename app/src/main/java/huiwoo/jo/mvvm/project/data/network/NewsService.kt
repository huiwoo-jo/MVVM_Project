package huiwoo.jo.mvvm.project.data.network

import huiwoo.jo.mvvm.project.data.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsService {
    @GET("news/{title}")
    fun getNews(
        @Path("news") owner: String
    ): Call<News>
}