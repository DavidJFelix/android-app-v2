package co.instameals.dinnersolutions.api.v2.model

import co.instameals.dinnersolutions.api.v2.utils.Relation
import java.util.UUID
import org.joda.time.DateTime

data class Meal(
        var id: UUID,
        var name: String,
        var description: String,
        var allergens: List<Relation<Allergen>>,
        var dietaryFilters: List<Relation<DietaryFilter>>,
        var ingredients: List<Relation<Ingredient>>,
        var pickupAddress: Relation<Address>,
        var portions: Int,
        var portionsAvailable: Int,
        var price: Relation<Price>,
        var availableFrom: DateTime,
        var availableTo: DateTime,
        var seller: Relation<APIUser>,
        var previewImage: Relation<Image>,
        var images: List<Relation<Image>>
)
