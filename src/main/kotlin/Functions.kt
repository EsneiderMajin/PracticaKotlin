fun main(){


    printName("pedro","perez")

    var resultado = 0

    val sumar = {op1:Int, op2:Int -> op1+op2}

    //
    resultado = sumar(4,3)

    println(resultado)

    //tipo de dato (Int,Int) ->Int var resultado2 = sumar

    //println(sumar)
    //suma
    add3({op1:Int, op2:Int -> op1+op2}, 4, 8, "La suma es: ")
    //Multiplicacion
    add3({op1:Int, op2:Int -> op1*op2}, 4, 8, "La suma es: ")
    //Division
    add3({op1:Int, op2:Int -> op1/op2}, 4, 8, "La suma es: ")

    add4({op1,op2 -> "El precio  total es: $op1 $op2"}, "precio: ", 6.55, "Descuento de 10%" )

    val codificar:(String) -> String = {it.uppercase()}

    codificarHO("unicauca", codificar)

    codificarHO("unicauca", {it.uppercase()})


}


fun codificarHO(mensaje: String, codificar: (String)->String){
    println ("$mensaje codificado como ${codificar(mensaje)}")
}




fun add4(imprimir: (String,Double)->String, op1:String, op2:Double, texto: String){
    println("$texto ${imprimir(op1,op2)}")
}


fun printName(name:String, lastname:String="No lastname"):Unit{

    println("Hello $name $lastname")

}

fun add(op1:Int, op2:Int):Int{
    return op1 + op2
}

fun add2(op1:Int, op2:Int):Int = op1+op2

fun add3(sumar: (Int,Int)->Int, op1:Int, op2:Int, texto: String){
    println("$texto ${sumar(op1,op2)}")
}




