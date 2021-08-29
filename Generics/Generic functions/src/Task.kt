fun <T, C : MutableCollection<T>> Iterable<T>.partitionTo(
    first: C,
    second: C,
    predicate: (T) -> Boolean
): Pair<C, C> =
    this.partition(predicate)
        .let {
            first.addAll(it.first)
            second.addAll(it.second)
            first to second
        }

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
        .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
        .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
