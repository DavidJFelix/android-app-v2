package co.instameals.dinnersolutions.api.v2.requests

import java.util.*

data class MealRequest(
        val id: UUID? = null,
        val addressId: UUID,
        val priceId: UUID,
        val previewImageId: UUID
)