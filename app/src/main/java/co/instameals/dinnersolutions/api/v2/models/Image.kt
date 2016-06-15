package co.instameals.dinnersolutions.api.v2.models

import co.instameals.dinnersolutions.api.v2.requests.ImageRequest

class Image {
    fun toRequest(): ImageRequest {
        return ImageRequest()
    }
}