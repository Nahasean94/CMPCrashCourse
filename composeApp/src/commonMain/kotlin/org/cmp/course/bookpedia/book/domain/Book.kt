package org.cmp.course.bookpedia.book.domain

data class Book(
    val id:String,
    val title:String,
    val imageUrl:String,
    val authors:List<String>,
    val description:String?,
    val languages:List<String>,
    val firstPublishYear:String?,
    val averageRating:Double?,
    val ratingCount:Int?,
    var numPages:Int?,
    val numEditions:Int
)
