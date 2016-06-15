package co.instameals.dinnersolutions.api.v2.responses

import java.util.*

data class PriceResponse(
        val id: UUID,
        val currency: String,
        val value: String
)
