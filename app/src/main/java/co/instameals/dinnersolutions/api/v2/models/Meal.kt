package co.instameals.dinnersolutions.api.v2.models

import co.instameals.dinnersolutions.api.v2.requests.MealRequest
import co.instameals.dinnersolutions.api.v2.responses.*
import co.instameals.dinnersolutions.api.v2.utils.MealRequestBuilder
import rx.Observable


class Meal(val address: Address, val price: Price, val previewImage: Image) {

    fun buildNestedRequest(
            addressBuilder:  (Address) -> Observable<AddressResponse>,
            priceBuilder: (Price) -> Observable<PriceResponse>,
            previewImageBuilder:  (Image) -> Observable<ImageResponse>
    ): Observable<MealRequest> {

        return Observable.just(MealRequestBuilder()).zipWith(
                addressBuilder(address),
                {m, a -> m.addressId = a.id; m}
        ).zipWith(
                priceBuilder(price),
                {m, p -> m.priceId = p.id; m}
        ).zipWith(
                previewImageBuilder(previewImage),
                {m, i -> m.previewImageId = i.id; m}
        ).map({m -> buildRequest(m)})
    }

    fun buildRequest(mealRequestBuilder: MealRequestBuilder): MealRequest {
        return MealRequest(
                addressId = mealRequestBuilder.addressId!!,
                previewImageId = mealRequestBuilder.previewImageId!!,
                priceId = mealRequestBuilder.priceId!!
        )
    }
}