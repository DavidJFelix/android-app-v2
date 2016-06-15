package co.instameals.dinnersolutions.api.v2.models

import co.instameals.dinnersolutions.api.v2.requests.AddressRequest

class Address {
    fun toRequest(): AddressRequest {
        return AddressRequest()
    }
}