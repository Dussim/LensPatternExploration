package xyz.dussim

data class Company(
    val name: String,
    val address: Address
) {
    companion object {
        val name = Lens.of(
            get = Company::name,
            set = Company::withName
        )
        val address = Lens.of(
            get = Company::address,
            set = Company::withAddress
        )
    }

    fun withName(name: String): Company = copy(name = name)
    fun withAddress(address: Address): Company = copy(address = address)
}

inline val <S> Lens<S, Company>.name: Lens<S, String> get() = compose(Company.name)
inline val <S> Lens<S, Company>.address: Lens<S, Address> get() = compose(Company.address)