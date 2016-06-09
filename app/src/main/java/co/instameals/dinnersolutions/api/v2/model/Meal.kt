package co.instameals.dinnersolutions.api.v2.model

import co.instameals.dinnersolutions.api.v2.request.MealRequest
import co.instameals.dinnersolutions.api.v2.response.AddressResponse
import co.instameals.dinnersolutions.api.v2.response.ImageResponse
import co.instameals.dinnersolutions.api.v2.response.PriceResponse
import co.instameals.dinnersolutions.api.v2.utils.MealRequestBuilder
import rx.Observable
import rx.functions.Func1



class Meal(val address: Address, val price: Price, val previewImage: Image) {

    fun buildNestedRequest(
            addressBuilder:  (a: Address) -> Observable<AddressResponse>,
            priceBuilder: (p: Price) -> Observable<PriceResponse>,
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