package co.instameals.dinnersolutions.api.v2.model

import co.instameals.dinnersolutions.api.v2.request.ImageRequest

class Image {
    fun toRequest(): ImageRequest {
        return ImageRequest()
    }
}