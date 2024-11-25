package xyz.dussim

interface Lens<Target, Focus> {
    companion object;
    fun get(a: Target): Focus
    fun set(a: Target, b: Focus): Target
}

fun <Target, Focus> Lens.Companion.of(
    get: (Target) -> Focus,
    set: (Target, Focus) -> Target
): Lens<Target, Focus> {
    return object : Lens<Target, Focus> {
        override fun get(a: Target): Focus = get(a)
        override fun set(a: Target, b: Focus): Target = set(a, b)
    }
}

fun <Target, Focus> Lens.Companion.of(
    get: (Target) -> Focus,
    constructor: (Focus) -> Target
): Lens<Target, Focus> {
    return object : Lens<Target, Focus> {
        override fun get(a: Target): Focus = get(a)
        override fun set(a: Target, b: Focus): Target = constructor(b)
    }
}

fun <T, A, B> Lens<T, A>.compose(other: Lens<A, B>): Lens<T, B> {
    return Lens.of(
        get = { a -> other.get(get(a)) },
        set = { a, b -> set(a, other.set(get(a), b)) }
    )
}

fun <Target, Focus> Lens<Target, Focus>.modify(a: Target, f: (Focus) -> Focus): Target {
    return set(a, f(get(a)))
}