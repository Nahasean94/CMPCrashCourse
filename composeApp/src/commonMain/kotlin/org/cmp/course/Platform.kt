package org.cmp.course

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform