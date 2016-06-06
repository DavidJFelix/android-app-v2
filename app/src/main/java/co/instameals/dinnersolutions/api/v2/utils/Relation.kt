package co.instameals.dinnersolutions.api.v2.utils

import com.fasterxml.jackson.annotation.JsonValue
import java.util.UUID

class Relation<T>(val relationId: UUID) {
    var relatedObject: T? = null

    @JsonValue
    fun getRelationId(): String {
        return relationId.toString()
    }
}
