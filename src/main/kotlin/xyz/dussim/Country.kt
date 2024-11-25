package xyz.dussim

@JvmInline
value class Country(val name: String) {
    companion object {
        val name = Lens.of(Country::name, ::Country)
    }
}

inline val <S> Lens<S, Country>.name: Lens<S, String> get() = compose(Country.name)
