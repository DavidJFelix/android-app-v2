package co.instameals.dinnersolutions.api.v2.models

import co.instameals.dinnersolutions.api.v2.requests.PriceRequest

class Price {
    fun toRequest(): PriceRequest {
        return PriceRequest()
    }
}