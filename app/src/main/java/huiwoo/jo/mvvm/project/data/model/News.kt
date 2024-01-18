package huiwoo.jo.mvvm.project.data.model

import java.io.Serializable

data class News(
    val title: String,
    val author: String,
    val imgUrl: String,
    val content : String,
    val publishedAt : String,
    val elapsed : String
) : Serializable
