package co.instameals.dinnersolutions.api.v2.utils

sealed class ResponseOrError<out T> {
    class Ok<T>(val response: T): ResponseOrError<T>()
    class Err(val error: Error): ResponseOrError<Error>()


}