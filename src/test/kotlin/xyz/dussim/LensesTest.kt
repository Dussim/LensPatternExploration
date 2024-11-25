package xyz.dussim

import kotlin.test.Test
import kotlin.test.assertEquals

class LensesTest {
    private val person = Person(
        name = "John",
        age = 42,
        address = Address(
            streetName = StreetName("Baker Street"),
            streetNumber = StreetNumber("221B"),
            country = Country("UK")
        )
    )

    @Test
    fun `name lens gets Person name`() {
        assertEquals("John", Person.name.get(person))
    }

    @Test
    fun `name lens modifies Person name`() {
        assertEquals("John", person.name)

        val modified = Person.name.set(person, "Jake")

        assertEquals("Jake", Person.name.get(modified))
    }

    @Test
    fun `name lens modifies Person name using modify`() {
        assertEquals("John", person.name)

        val modified = Person.name.modify(person) { it.uppercase() }

        assertEquals("JOHN", Person.name.get(modified))
    }

    @Test
    fun `address lens gets Person address`() {
        assertEquals("Baker Street", Person.address.streetName.get(person).name)
    }

    @Test
    fun `address lens modifies Person address`() {
        assertEquals("Baker Street", Person.address.streetName.get(person).name)

        val modified = Person.address.streetName.set(person, StreetName("Oxford Street"))

        assertEquals("Oxford Street", Person.address.streetName.get(modified).name)
    }

    @Test
    fun `address lens modifies Person address using modify`() {
        assertEquals("Baker Street", Person.address.streetName.get(person).name)

        val modified = Person.address.streetName.name.modify(person) { it.uppercase() }

        assertEquals("BAKER STREET", Person.address.streetName.name.get(modified))
    }
}