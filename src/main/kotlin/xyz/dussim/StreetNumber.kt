package xyz.dussim

@JvmInline
value class StreetNumber(val number: String) {
    companion object {
        val number = Lens.of(StreetNumber::number, ::StreetNumber)
    }
}

inline val <S> Lens<S, StreetNumber>.number: Lens<S, String> get() = compose(StreetNumber.number)
