fun main(){
    val c1 = Circle(2.0, name = "Circle 1")
    c1.printCircle()
    println(c1.brand)
    c1.brand = "Toyota"
    println(c1.brand)
    val c2 = Circle(4.0, name = "Circle 2")
    val c3 = Circle(diameter = 13.4)
    c2.printCircle()
    c3.printCircle()
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



