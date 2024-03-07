// Deklaracja funkcji głównej
fun main() {
    // Deklaracja zmiennych
    val name: String = "John"
    var age: Int = 30

    // Wywołanie funkcji
    greet(name)

    // Instrukcje warunkowe
    if (age >= 18) {
        println("Jesteś dorosły")
    } else {
        println("Jesteś nieletni")
    }

    // Pętla for
    for (i in 1..5) {
        println("Liczba: $i")
    }

    // Pętla while
    var count = 0
    while (count < 5) {
        println("Pętla while: $count")
        count++
    }
}

// Deklaracja funkcji
fun greet(name: String) {
    println("Witaj, $name!")
}
