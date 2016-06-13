package co.instameals.dinnersolutions.api.v2.utils

import java.util.*

data class MealRequestBuilder(
        var addressId: UUID? = null,
        var previewImageId: UUID? = null,
        var priceId: UUID? = null
)