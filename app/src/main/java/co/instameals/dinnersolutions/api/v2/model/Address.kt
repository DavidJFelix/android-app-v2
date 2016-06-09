package co.instameals.dinnersolutions.api.v2.model

import co.instameals.dinnersolutions.api.v2.request.AddressRequest

class Address {
    fun toRequest(): AddressRequest {
        return AddressRequest()
    }
}