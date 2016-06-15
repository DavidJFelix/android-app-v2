package co.instameals.dinnersolutions.api.v2.responses

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import net.javacrumbs.jsonunit.JsonMatchers.jsonEquals
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import java.util.*

class MealResponseTest {

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {

    }

    @Test
    fun testJsonDeserializeStructure() {
        val testMealResponse: String = """{
            "id": "123e4567-e89b-12d3-a456-426655440000",
            "name": "Test Meal",
            "description": "A Meal to test meal creation",
            "allergens": [],
            "dietary_filters": [],
            "ingredients": [],
            "pickup_address": "123e4567-e89b-12d3-a456-426655440000",
            "portions": 0,
            "seller": "123e4567-e89b-12d3-a456-426655440000",
            "portions_available": 0,
            "price": "123e4567-e89b-12d3-a456-426655440000",
            "available_from": "2016-04-10T17:53:50.142Z",
            "available_to": "2016-04-10T17:53:50.142Z",
            "preview_image": "123e4567-e89b-12d3-a456-426655440000",
            "images": []
        }"""
        val testUUID = UUID.fromString("123e4567-e89b-12d3-a456-426655440000")
        val expected = MealResponse(
                id = testUUID,
                name = "Test Meal",
                description = "A Meal to test meal creation",
                allergens = ArrayList<UUID>(),
                dietaryFilters = ArrayList<UUID>(),
                ingredients = ArrayList<UUID>(),
                pickupAddress = testUUID,
                portions = 0,
                portionsAvailable = 0,
                seller = testUUID,
                price = testUUID,
                availableFrom = DateTime("2016-04-10T17:53:50.142Z", DateTimeZone.UTC),
                availableTo = DateTime("2016-04-10T17:53:50.142Z", DateTimeZone.UTC),
                previewImage = testUUID,
                images = ArrayList<UUID>()
        )
        val mapper = jacksonObjectMapper()
                .registerModule(JodaModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        val actual = mapper.readValue<MealResponse>(testMealResponse)
        assertThat(actual, jsonEquals<MealResponse>(expected))
    }
}