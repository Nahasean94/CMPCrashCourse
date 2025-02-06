package org.cmp.course.bookpedia.book.presentation.book_list

import org.cmp.course.bookpedia.core.presentation.UiText
import org.cmp.course.bookpedia.book.domain.Book

data class BookListState(
    val searchQuery:String="Kotlin",
    val searchResults:List<Book> =emptyList(),
    val favoriteBooks:List<Book> =emptyList(),
    val isLoading:Boolean=false,
    val selectedTabIndex:Int=0,
    val errorMessage: UiText?=null


)
