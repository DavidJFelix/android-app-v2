package co.instameals.dinnersolutions.api.v2

import co.instameals.dinnersolutions.api.v2.models.*
import co.instameals.dinnersolutions.api.v2.responses.*
import rx.Observable

class ApiV2Client(var dinnerSolutionsApiV2: DinnerSolutionsApiV2) {

    fun createNewAddress(newAddress: Address): Observable<AddressResponse> {
        return dinnerSolutionsApiV2.postAddress(newAddress.toRequest())
    }

    fun createNewImage(newImage: Image): Observable<ImageResponse> {
        return dinnerSolutionsApiV2.postImage(newImage.toRequest())
    }

    fun createNewMeal(newMeal: Meal): Observable<MealResponse> {
        return newMeal.buildNestedRequest(
                { a: Address -> createNewAddress(a) },
                { p: Price -> createNewPrice(p) },
                { i: Image -> createNewImage(i) }
        ).flatMap { req -> dinnerSolutionsApiV2.postMeal(req) }
    }

    fun createNewPrice(newPrice: Price): Observable<PriceResponse> {
        return dinnerSolutionsApiV2.postPrice(newPrice.toRequest())
    }
}