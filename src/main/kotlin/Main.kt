
fun main(args: Array<String>) {

    println("Hello World!")
    //Aplicacion funcional final

    //lamar a clase
    val aquarium = Aquarium()
    aquarium.printSize()


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    var numberOfBooks: Int? = null

    //using the safe call operator ? to call object's method
    //decrement  number og=f books if it is not null else do nothing


    //numberOfBooks = numberOfBooks.dec()


    //Warning: force
    //numberOfBooks = numberOfBooks!!.dec()


    //Elvis operator: if numberOfBooks is null
    //numberOfBooks = numberOfBooks?.dec() ?: 0
}











