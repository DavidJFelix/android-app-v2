package co.instameals.dinnersolutions.api.v2.model

import co.instameals.dinnersolutions.api.v2.utils.Relation
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.joda.time.DateTime
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Meal(
        var id: UUID?,
        var name: String,
        var description: String,
        var allergens: List<Relation<Allergen>>,

        @JsonProperty("dietary_filters")
        var dietaryFilters: List<Relation<DietaryFilter>>,
        var ingredients: List<Relation<Ingredient>>,

        @JsonProperty("pickup_address")
        var pickupAddress: Relation<Address>,
        var portions: Int,

        @JsonProperty("portions_available")
        var portionsAvailable: Int,
        var price: Relation<Price>,

        @JsonProperty("available_from")
        var availableFrom: DateTime,

        @JsonProperty("available_to")
        var availableTo: DateTime,
        var seller: Relation<APIUser>,

        @JsonProperty("preview_image")
        var previewImage: Relation<Image>,
        var images: List<Relation<Image>>
)
