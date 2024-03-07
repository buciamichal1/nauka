class Pies(waga:Int, szybkosc:Int, glos:Int, sila:Int){
    var waga = waga
    var szybkosc = szybkosc
    var glos = glos
    var sila = sila
}
class Kot(waga:Int,szybkosc:Int,glos:Int,sila:Int){
    var waga = waga
    var szybkosc = szybkosc
    var glos = glos
    var sila = sila
}
fun pojedynek(Pies:Pies,Kot:Kot){
    var Pies_p:Int = 0
    var Kot_p:Int = 0
    if(Pies.waga > Kot.waga){
        Pies_p += 1
    }
    if(Pies.waga < Kot.waga){
        Kot_p += 1
    }
    if(Pies.szybkosc > Kot.szybkosc){
        Pies_p += 1
    }
    if(Pies.szybkosc < Kot.szybkosc){
        Kot_p += 1
    }
    if(Pies.glos > Kot.glos){
        Pies_p += 1
    }
    if(Pies.glos < Kot.glos){
        Kot_p += 1
    }
    if(Pies.sila > Kot.sila){
        Pies_p += 1
    }
    if(Pies.sila < Kot.sila){
        Kot_p += 1
    }
    if(Pies_p > Kot_p){
        println("Wygrał pies")
    }
    if(Pies_p < Kot_p){
        println("Wygrał kot")
    }
    if(Pies_p == Kot_p){
        println("Remis")
    }

}
fun main(){
    var Azor = Pies(2,3,4,5)
    var Kitek = Kot(1,5,4,3)
    pojedynek(Azor,Kitek)
    /*var waga:Int?
    var szybkosc:Int
    var glos:Int
    var sila:Int

    println("Podaj parametry psa:")
    print("Waga:")
    waga = readLine()!!.toIntOrNull() ?:0
    print("Szybkość:")
    szybkosc = readLine()!!.toInt()
    print("Głos:")
    glos = readLine()!!.toInt()
    print("Siła:")
    sila = readLine()!!.toInt()
    var Azors = Pies(waga, szybkosc, glos, sila)
    pojedynek(Azors,Kitek)*/
}