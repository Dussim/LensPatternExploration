package xyz.dussim

data class Address(
    val streetName: StreetName,
    val streetNumber: StreetNumber,
    val country: Country
) {
    companion object {
        val streetName = Lens.of(
            get = Address::streetName,
            set = Address::withStreetName
        )
        val streetNumber = Lens.of(
            get = Address::streetNumber,
            set = Address::withStreetNumber
        )
        val country = Lens.of(
            get = Address::country,
            set = Address::withCountry
        )
    }

    private fun withStreetName(streetName: StreetName): Address = copy(streetName = streetName)
    private fun withStreetNumber(streetNumber: StreetNumber): Address = copy(streetNumber = streetNumber)
    private fun withCountry(country: Country): Address = copy(country = country)
}

inline val <S> Lens<S, Address>.streetName: Lens<S, StreetName> get() = compose(Address.streetName)
inline val <S> Lens<S, Address>.streetNumber: Lens<S, StreetNumber> get() = compose(Address.streetNumber)
inline val <S> Lens<S, Address>.country: Lens<S, Country> get() = compose(Address.country)