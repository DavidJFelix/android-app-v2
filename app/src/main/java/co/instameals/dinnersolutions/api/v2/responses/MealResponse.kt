package co.instameals.dinnersolutions.api.v2.responses

import com.fasterxml.jackson.annotation.JsonProperty
import org.joda.time.DateTime
import java.util.*

data class MealResponse(
        var id: UUID,
        var name: String,
        var description: String,
        var allergens: List<UUID>,

        @JsonProperty("dietary_filters")
        var dietaryFilters: List<UUID>,
        var ingredients: List<UUID>,

        @JsonProperty("pickup_address")
        var pickupAddress: UUID,
        var portions: Int,

        @JsonProperty("portions_available")
        var portionsAvailable: Int,
        var price: UUID,

        @JsonProperty("available_from")
        var availableFrom: DateTime,

        @JsonProperty("available_to")
        var availableTo: DateTime,
        var seller: UUID,

        @JsonProperty("preview_image")
        var previewImage: UUID,
        var images: List<UUID>
)
