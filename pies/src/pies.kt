data class Pies(var waga: Int, var szybkosc: Int, var glos: Int, var sila: Int)

data class Kot(var waga: Int, var szybkosc: Int, var glos: Int, var sila: Int)

fun pojedynek(pies: Pies, kot: Kot) {
    var pies_p: Int = 0
    var kot_p: Int = 0

    if (pies.waga > kot.waga) {
        pies_p += 1
    } else if (pies.waga < kot.waga) {
        kot_p += 1
    }

    if (pies.szybkosc > kot.szybkosc) {
        pies_p += 1
    } else if (pies.szybkosc < kot.szybkosc) {
        kot_p += 1
    }

    if (pies.glos > kot.glos) {
        pies_p += 1
    } else if (pies.glos < kot.glos) {
        kot_p += 1
    }

    if (pies.sila > kot.sila) {
        pies_p += 1
    } else if (pies.sila < kot.sila) {
        kot_p += 1
    }

    when {
        pies_p > kot_p -> println("Wygrał pies")
        pies_p < kot_p -> println("Wygrał kot")
        else -> println("Remis")
    }
}
fun main(){
    var Azor = Pies(2,3,4,5)
    var Kitek = Kot(1,5,4,3)
    pojedynek(Azor,Kitek)
    var waga:Int?
    var szybkosc:Int
    var glos:Int
    var sila:Int

    println("Podaj parametry psa:")
    print("Waga:")
    waga = readLine()!!.toInt()
    print("Szybkość:")
    szybkosc = readLine()!!.toInt()
    print("Głos:")
    glos = readLine()!!.toInt()
    print("Siła:")
    sila = readLine()!!.toInt()
    var Azors = Pies(waga, szybkosc, glos, sila)
    println("Podaj parametry kota:")
    print("Waga:")
    waga = readLine()!!.toInt()
    print("Szybkość:")
    szybkosc = readLine()!!.toInt()
    print("Głos:")
    glos = readLine()!!.toInt()
    print("Siła:")
    sila = readLine()!!.toInt()
    var Kiteks = Kot(waga, szybkosc, glos, sila)
    pojedynek(Azors,Kiteks)
}