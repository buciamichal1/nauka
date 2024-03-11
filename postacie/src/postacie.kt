import kotlin.math.round
open class Postac(imie:String){
    var imie = imie
    var hp: Float = 100.0f
    var sila: Float = 10.0f
    var odpornosc_fizyczna: Float = 10.0f
    var odpornosc_magiczna: Float = 10.0f

}
open class Mag(imie:String,postac: Postac) : Postac(imie) {
    var mana: Float = 100f
    var odpornosc_mag: Float = round(((1 - ((3 * postac.odpornosc_magiczna) / 100)).toFloat())*100)/100
    var odpornosc_fiz: Float = round(((1 - ((1 * postac.odpornosc_magiczna) / 100)).toFloat())*100)/100
    var damage_mag: Float = round(((4 * postac.sila).toFloat())*100)/100
    var damage_fiz: Float = round(((1.5 * postac.sila).toFloat())*100)/100
    var zycie: Float = round(((1 * hp).toFloat())*100)/100

    fun atak_mag(postac: Postac, wojownik: Wojownik,crit: Float) {
        if(mana >= 20){
            var damage_mag_czarem = round(((crit * damage_mag * wojownik.odpornosc_mag).toFloat())*100)/100
            wojownik.zycie = round(((wojownik.zycie - damage_mag_czarem).toFloat())*100)/100
            mana -= 20
            println("${imie} zadałeś obrazenia magiczne czarem przeciwnikowi ${wojownik.imie} równe ${damage_mag_czarem}")
            println("${wojownik.imie} hp ${wojownik.zycie}")

    }}

    fun atak_fiz(postac: Postac, wojownik: Wojownik,crit: Float) {
        var damage_fiz_kosturem = round(((crit * damage_fiz * wojownik.odpornosc_fiz).toFloat())*100)/100
        wojownik.zycie = round(((wojownik.zycie - damage_fiz_kosturem).toFloat())*100)/100
        println("${imie} zadałeś obrazenia fizyczne kosturem przeciwnikowi ${wojownik.imie} równe ${damage_fiz_kosturem}")
        println("${wojownik.imie} hp ${wojownik.zycie}")
    }
}
open class Wojownik(imie:String,postac: Postac) : Postac(imie) {
    var stamina: Float = 100f
    var odpornosc_mag: Float = round(((1 - ((1.5 * postac.odpornosc_magiczna) / 100)).toFloat())*100)/100
    var odpornosc_fiz: Float = round(((1 - ((4 * postac.odpornosc_magiczna) / 100)).toFloat())*100)/100
    var damage_mag: Float = round(((0 * postac.sila).toFloat())*100)/100
    var damage_fiz: Float = round(((3 * postac.sila).toFloat())*100)/100
    var zycie: Float = round(((1.5 * hp).toFloat())*100)/100

    fun atak_mieczem(postac: Postac, mag: Mag,crit: Float) {
        if(stamina >= 15){
            var damage_fiz_mieczem = round(((crit * damage_fiz * mag.odpornosc_fiz).toFloat())*100)/100
            mag.zycie = round(((mag.zycie - damage_fiz_mieczem).toFloat())*100)/100
            stamina -= 15
            println("${imie} zadałeś obrazenia fizyczne mieczem przeciwnikowi ${mag.imie} równe ${damage_fiz_mieczem}")
            println("${mag.imie} hp ${mag.zycie}")

    }}

    fun atak_tarcza(postac: Postac, mag: Mag,crit: Float) {
        if(stamina >= 10){
            var damage_fiz_tarcza = round(((crit * 0.7 * damage_fiz * mag.odpornosc_fiz).toFloat())*100)/100
            mag.zycie = round(((mag.zycie - damage_fiz_tarcza).toFloat())*100)/100
            stamina -= 10
            println("${imie} zadałeś obrazenia fizyczne tarczą przeciwnikowi ${mag.imie} równe ${damage_fiz_tarcza}")
            println("${mag.imie} hp ${mag.zycie}")

    }}
}
fun krytyczny(): Float{
    var crit = (0..9).random()
    var kryt: Float = 1.5f
    var crit_value:Float = crit.toFloat()
    when(crit_value){
        in 0f..1f -> crit_value = (1f * kryt)
        in 2f..9f -> crit_value = 1f
    }
    return crit_value
}
fun statystyki(mag:Mag,wojownik: Wojownik){
    println("Mag ${mag.imie}")
    println("mana:${mag.mana}")
    println("hp:${mag.zycie}")
    println("Wojownik ${wojownik.imie}")
    println("stamina:${wojownik.stamina}")
    println("hp:${wojownik.zycie}")
}
fun start(mag:Mag,wojownik: Wojownik){
    println("Mag ${mag.imie}")
    println("obrażenia magiczne:${mag.damage_mag}")
    println("obrażenia fizyczne:${mag.damage_fiz}")
    println("odporność na magie:${round((((1 - mag.odpornosc_mag)*100).toFloat())*100)/100}%")
    println("odporność na obrażenia fizyczne:${round((((1 - mag.odpornosc_fiz)*100).toFloat())*100)/100}%")
    println("mana:${mag.mana}")
    println("hp:${mag.zycie}")
    println("Wojownik ${wojownik.imie}")
    println("obrażenia magiczne:${wojownik.damage_mag}")
    println("obrażenia fizyczne:${wojownik.damage_fiz}")
    println("odporność na magie:${round((((1 - wojownik.odpornosc_mag)*100).toFloat())*100)/100}%")
    println("odporność na obrażenia fizyczne:${round((((1 - wojownik.odpornosc_fiz)*100).toFloat())*100)/100}%")
    println("stamina:${wojownik.stamina}")
    println("hp:${wojownik.zycie}")
    println("---atakuj---")
}

fun main() {
    print("Podaj imie maga:")
    var imiemag = readLine()!!
    print("Podaj imie wojownik:")
    var imiewojownik = readLine()!!
    var magPostac = Postac(imiemag)
    var wojownikPostac = Postac(imiewojownik)
    var mag = Mag(imiemag, magPostac)
    var wojownik = Wojownik(imiewojownik, wojownikPostac)
    start(mag,wojownik)
    while (true) {
        var keyCode = System.`in`.read()
        var crit = krytyczny()
        when (keyCode){
            /*'\t'.toInt() -> {val key = System.`in`.read()
                                when(key){*/
                                    'w'.toInt() -> {mag.atak_mag(mag,wojownik,crit)}
                                    'd'.toInt() -> {mag.atak_fiz(mag,wojownik,crit)}
                                    /*else -> println("miss")
                                }}
            '+'.toInt() -> {val key = System.`in`.read()
                                when(key){*/
                                    '8'.toInt() -> {wojownik.atak_mieczem(wojownik,mag,crit)}
                                    '4'.toInt() -> {wojownik.atak_tarcza(wojownik,mag,crit)}
                                    /*else -> println("miss")
                                }}*/
            10 -> {statystyki(mag,wojownik)}
            else -> {println("Zły klawisz")}
        }
        if(mag.zycie < 1){println("Wygrał ${wojownik.imie}")
            break}
        if(wojownik.zycie < 1){println("Wygrał ${mag.imie}")
            break}

    }
    /*tomus.atak_mag(tomus, pawelek)
    // Poprawka: Zamieniono kolejność argumentów
    pawelek.atak_mieczem(pawelek, tomus)
    tomus.atak_fiz(tomus, pawelek)
    pawelek.atak_tarcza(pawelek, tomus)*/
}