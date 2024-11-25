package xyz.dussim

@JvmInline
value class StreetName(val name: String) {
    companion object {
        val name = Lens.of(StreetName::name, ::StreetName)
    }
}

inline val <S> Lens<S, StreetName>.name: Lens<S, String> get() = compose(StreetName.name)
