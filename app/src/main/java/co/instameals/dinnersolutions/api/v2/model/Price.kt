package co.instameals.dinnersolutions.api.v2.model

import co.instameals.dinnersolutions.api.v2.request.PriceRequest

class Price {
    fun toRequest(): PriceRequest {
        return PriceRequest()
    }
}