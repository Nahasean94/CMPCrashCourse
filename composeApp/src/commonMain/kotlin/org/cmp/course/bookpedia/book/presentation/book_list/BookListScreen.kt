package org.cmp.course.bookpedia.book.presentation.book_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalAutofill
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.cmp.course.bookpedia.book.domain.Book
import org.cmp.course.bookpedia.book.presentation.book_list.components.BookSearchBar
import org.cmp.course.bookpedia.core.domain.DataError
import org.cmp.course.bookpedia.core.presentation.DarkBlue

import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookListScreenRoot(
    viewModel: BookListViewModel = koinViewModel(),
    onBookClick: (Book) -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    BookListScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is BookListAction.OnBookClick -> onBookClick(action.book)
                else -> Unit
            }
            viewModel.onAction(action)
        },
    )
}

@Composable
fun BookListScreen(
    state: BookListState,
    onAction: (BookListAction) -> Unit,
) {
    val keyboardController= LocalSoftwareKeyboardController.current
Column (modifier = Modifier.fillMaxWidth().background(DarkBlue).statusBarsPadding(),
    horizontalAlignment = Alignment.CenterHorizontally){
    BookSearchBar(searchQuery = state.searchQuery,
        onSearchQueryChange = {
            onAction(BookListAction.OnSearchQueryChange(it))
        },
        onImeSearch = {
keyboardController?.hide()
        },
        modifier = Modifier.widthIn(max=400.dp).fillMaxWidth().padding(16.dp)
        )
}
}
