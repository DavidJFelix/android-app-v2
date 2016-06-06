package co.instameals.dinnersolutions.api.v2.model

import co.instameals.dinnersolutions.api.v2.utils.Relation
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class MealTest {

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {

    }

    @Test
    fun testJsonSerializeStructure() {
        val expected = """{
            "name": 'Test Meal',
            "description": 'A Meal to test meal creation',
            "allergens": [],
            "dietary_filters": [],
            "ingredients": [],
            "pickup_address": '123e4567-e89b-12d3-a456-426655440000',
            "portions": 0,
            "seller": '123e4567-e89b-12d3-a456-426655440000',
            "portions_available": 0,
            "price": '123e4567-e89b-12d3-a456-426655440000',
            "available_from": '2016-04-10T17:53:50.142Z',
            "available_to": '2016-04-10T17:53:50.142Z',
            "preview_image": '123e4567-e89b-12d3-a456-426655440000',
            "images": []
        }"""
        val testUUID = UUID.fromString("123e4567-e89b-12d3-a456-426655440000")
        val testMeal = Meal(
                id = null,
                name = "Test Meal",
                description = "A Meal to test meal creation",
                allergens = ArrayList<Relation<Allergen>>(),
                dietaryFilters = ArrayList<Relation<DietaryFilter>>(),
                ingredients = ArrayList<Relation<Ingredient>>(),
                pickupAddress = Relation<Address>(testUUID),
                portions = 0,
                portionsAvailable = 0,
                seller = Relation<APIUser>(testUUID),
                price = Relation<Price>(testUUID),
                availableFrom = DateTime("2016-04-10T17:53:50.142Z", DateTimeZone.UTC),
                availableTo = DateTime("2016-04-10T17:53:50.142Z", DateTimeZone.UTC),
                previewImage = Relation<Image>(testUUID),
                images = ArrayList<Relation<Image>>()
        )
        val mapper = ObjectMapper()
                .registerModule(KotlinModule())
                .registerModule(JodaModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        val actual = mapper.writeValueAsString(testMeal)
        System.out.println(actual)
        assertThat(actual, jsonEquals(expected))
    }
}