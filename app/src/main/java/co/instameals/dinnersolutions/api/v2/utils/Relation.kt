package co.instameals.dinnersolutions.api.v2.utils

import java.util.UUID

class Relation<T>(val relationId: UUID) {
    var relatedObject: T? = null
}
