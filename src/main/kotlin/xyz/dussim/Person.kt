package xyz.dussim

data class Person(
    val name: String,
    val age: Int,
    val address: Address
) {
    companion object {
        val name = Lens.of(
            get = Person::name,
            set = Person::withName
        )
        val age = Lens.of(
            get = Person::age,
            set = Person::withAge
        )
        val address = Lens.of(
            get = Person::address,
            set = Person::withAddress
        )
    }

    fun withName(name: String): Person = copy(name = name)
    fun withAge(age: Int): Person = copy(age = age)
    fun withAddress(address: Address): Person = copy(address = address)
}

inline val <S> Lens<S, Person>.name: Lens<S, String> get() = compose(Person.name)
inline val <S> Lens<S, Person>.age: Lens<S, Int> get() = compose(Person.age)
inline val <S> Lens<S, Person>.address: Lens<S, Address> get() = compose(Person.address)