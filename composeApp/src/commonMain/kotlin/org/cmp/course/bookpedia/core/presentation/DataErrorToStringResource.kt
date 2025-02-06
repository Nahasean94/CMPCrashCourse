package org.cmp.course.bookpedia.core.presentation


import cmpcrashcourse.composeapp.generated.resources.Res
import cmpcrashcourse.composeapp.generated.resources.error_disk_full
import cmpcrashcourse.composeapp.generated.resources.error_unknown
import cmpcrashcourse.composeapp.generated.resources.error_too_many_requests
import cmpcrashcourse.composeapp.generated.resources.error_no_internet
import cmpcrashcourse.composeapp.generated.resources.error_serialization

import org.cmp.course.bookpedia.core.domain.DataError

fun DataError.toUiText(): UiText {
    val stringRes = when(this) {
        DataError.Local.DISK_FULL -> Res.string.error_disk_full
        DataError.Local.UNKNOWN -> Res.string.error_unknown
        DataError.Remote.REQUEST_TIMEOUT -> Res.string.error_unknown
        DataError.Remote.TOO_MANY_REQUESTS -> Res.string.error_too_many_requests
        DataError.Remote.NO_INTERNET -> Res.string.error_no_internet
        DataError.Remote.SERVER -> Res.string.error_unknown
        DataError.Remote.SERIALIZATION -> Res.string.error_serialization
        DataError.Remote.UNKNOWN -> Res.string.error_unknown
    }

    return UiText.StringResourceId(stringRes)
}
