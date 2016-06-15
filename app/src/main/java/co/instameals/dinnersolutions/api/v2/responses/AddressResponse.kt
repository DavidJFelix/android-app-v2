package co.instameals.dinnersolutions.api.v2.responses

import co.instameals.dinnersolutions.api.v2.utils.GeoJsonPoint
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class AddressResponse(
        val id: UUID,
        val line1: String,
        val line2: String,
        val city: String,
        val state: String,
        val country: String,

        @JsonProperty("postal_code")
        val postalCode: String,
        val coordinates: GeoJsonPoint
)
