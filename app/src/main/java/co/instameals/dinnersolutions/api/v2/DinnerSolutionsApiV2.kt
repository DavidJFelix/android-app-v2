package co.instameals.dinnersolutions.api.v2

import co.instameals.dinnersolutions.api.v2.model.Meal


interface DinnerSolutionsApiV2 {
    fun getMealsNearby(latitude: Double, longitude: Double, range: Int?, units: String?): List<Meal>?
}