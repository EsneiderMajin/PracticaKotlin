import java.util.*


fun main(){
    //primera parte: https://developer.android.com/courses/pathways/android-development-with-kotlin-1
    val c1 = Circle(2.0, name = "Circle 1")
    c1.printCircle()
    println(c1.brand)
    c1.brand = "Toyota"
    println(c1.brand)
    val c2 = Circle(4.0, name = "Circle 2")
    val c3 = Circle(diameter = 13.4)
    c2.printCircle()
    c3.printCircle()

    //segunda parte https://developer.android.com/courses/pathways/android-development-with-kotlin-2
    println("---------------------------------------------------------------")

    swim()   // uses default speed
    swim("slow")   // positional argument
    swim(speed="turtle-like")   // named parameter

    println()
    feedTheFish()

    println()
    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println(decorations.filter {it[0] == 'p'})

    // eager, crea una nueva lista
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")

    // lazy, espera hasta que se le pida evaluar
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    // fuerza la evaluación de la lista lazy
    var newList = filtered.toList()
    println("nueva lista: $newList")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println()
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")
    //map
    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")
    //flatten
    val mysports = listOf("baloncesto", "pesca", "correr")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Ángeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // lista de listas
    println("-----")
    println("Combinada: ${mylist.flatten()}")

    //lambdas
    val sumar = { x: Int, y: Int -> x + y }
    val resultado = sumar(5, 3) // resultado será 8
    var dirtyLevel = 20
    val waterFilter = { dirty : Int -> dirty / 2}
    println(waterFilter(dirtyLevel))
    //funciones de orden superior
    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter2))

    println(updateDirty(15, ::increaseDirty))

}
fun increaseDirty( start: Int ) = start + 1


fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}


fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else  -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun swim(speed: String = "fast") {
    println("nado $speed")
}


/*
fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println("Hoy es $day y los peces comen $food")
}
*/

/*
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
}
*/
fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "hojuelas"
        "Wednesday" -> "gusanos rojos"
        "Thursday" -> "gránulos"
        "Friday" -> "mosquitos"
        "Sunday" -> "plancton"
        else -> "nada"
    }
}



interface Shape{
    fun computerArea(): Double
}


class Circle (val radius: Double, val name: String = "default circle"):Shape{
        //val radius = 1.0
    var area: Double = 0.0
    var brand: String = "ACME"
        get() {
            return "brand = $field"
        }

    constructor(name: String): this(radius = 1.0, name = name)
    constructor(diameter: Double): this(radius = diameter/2.0){
    }

    init{
        area = Math.PI * radius * radius
    }

    fun printCircle(){
        println("Circle $name with radius $radius")
        println("Radius: $radius Area: ${Math.PI * radius * radius}")
        println("Area: $area ")
    }

    override fun computerArea(): Double {
        return Math.PI * radius * radius

    }
}

class Square(val lenght: Double):Shape{
    override fun computerArea(): Double {
        return lenght * lenght
    }
}



