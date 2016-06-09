package co.instameals.dinnersolutions.api.v2

import co.instameals.dinnersolutions.api.v2.request.*
import co.instameals.dinnersolutions.api.v2.response.*
import retrofit2.http.*
import rx.Observable


interface DinnerSolutionsApiV2 {

    @POST("/address")
    fun postAddress(@Body address: AddressRequest): Observable<AddressResponse>

    @POST("/images")
    fun postImage(@Body image: ImageRequest): Observable<ImageResponse>

    @GET("/meals")
    fun getMeals(
            @Query("lat") latitude: Double,
            @Query("lng") longitude: Double,
            @Query("range") range: Int?,
            @Query("units") units: String?): Observable<List<MealResponse>>

    @POST("/meals")
    fun postMeal(@Body meal: MealRequest): Observable<MealResponse>

    @PUT("/meals/{id}")
    fun putMeal(@Path("id") @Body meal: MealRequest): Observable<MealResponse>


    @POST("/prices")
    fun postPrice(@Body price: PriceRequest): Observable<PriceResponse>
}