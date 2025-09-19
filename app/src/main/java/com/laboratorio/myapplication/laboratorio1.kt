package com.laboratorio.myapplication

//KOTLIN es sensible a las mayúsculas

var numeroFavorito: Int = 1

//Numeros enteros

var numeroEntero: Int = -269

//Numeros enteros de mayor rango

var numeroLargo: Long = 260000000

//Numeros decimales soporta hasta maximo de 6 decimales

var numeroDecimal: Float = 2.5f

// Numero para decimales para mas de 14 decimales (ocupan mucha memoria)

var numeroDecimalLargo: Double = 3.1416313292

// ============================= VARIABLES ALFANUMERICAS ======================


// Char guarda caracter de cualquier tipo (usa comillas simples '')

var charNumero: Char = '5'
var charLetra: Char = 'L'
var charCaracter: Char = '@'

// String, igual que char solo que permite mas caracteres (usa comillas "")

var muchoTexto: String = "Hola como estan me llamo kikin"

//Booleanos verdadero o falso

var voyaPasarLaMateria: Boolean = false
var voyAReprobar: Boolean = true

//======================================== TIPOS DE VALORES Y CONCATENACIÓN ==================================
//    var a = 8
//    var b = 3
//
//    print("Suma: ")
//    println(a + b)
//
//    print("Resta: ")
//    println(a - b)
//
//    print("Multiplicación: ")
//    println(a * b)
//
//    print("División: ")
//    println(a / b)
//
//    print("El módulo (resto): ")
//    println(a % b)
//
//    //Convertir valores flotantes a INT o viceversa
//    var c: Float = 8.5f
//    var d: Int = 3
//    var resultado : Int
//
//    print("Suma: ")
//     resultado =  c.toInt() + d
//
//    print(resultado)

//================CONCATENACIÓN===================
// Sumar dos strings o mas bien concatenarlos
//// Heredada de JAVA
////    val greeting = "Hola, me llamo"
////    val name = "Alex"
////    println(greeting + " " + name)
//
////La mas actual
//    val greeting = "Hola, me llamo"
//    val name = "Alex"
//
//    println("$greeting $name")
//
//// Kotlin prefiere varibles inmutables que no se pueden cambiar (VAL)
//
//    val introduction = "El resultado de"
//    val plus = "más"
//    val firstNumber = 2
//    val secondNumber = 5
//
//    println("$introduction $firstNumber $plus $secondNumber es: ${firstNumber + secondNumber}")

fun main(args: Array<String>) {
    showMyAge()
    showMyInformation("Alex", "Fernández", 31)
    var result = add(2,8)
    println(result)

    //WHEN

    getMonth(2)
    result("holi")

    //CICLOO FOR
    val weekDays = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

    for (posicion in weekDays.indices){
        println(weekDays.get(posicion))
    }
    //LISTAS --> A DIFERENCIA DE LOS ARRAYS EN ESTAS PUEDEN SER DE LECTURA O MODIFICABLES
    //LISTAS INMUTABLES
    val readOnly: List<String> = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    readOnly.size //Muestra el tamaño de la lista
    readOnly.get(3) //Devuelve el valor de la posición 3
    readOnly.first() //Devuelve el primer valor
    readOnly.last() //Devuelve el último valor
    println(readOnly) //[Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo]

    //LISTAS MUTABLES
    var mutableList: MutableList<String> = mutableListOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado")

    mutableList.add("domingo")

//ARRAYS limitante es que tienen que contar con un tamaño fijo
//    val weekDays = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
//
//    println(weekDays.get(0)) o println(weekDays[0])
//    println(weekDays.get(1)) o println(weekDays[1])
//    println(weekDays.get(2)) o println(weekDays[2])

    //PERO SI PODEMOS MODIFICAR LOS ARRAYS, siempre y cuando sea del mismo tipo
    //weekDays.set(2, "Por fin viernes") //Contenía Viernes o weekDays[3] = "Viernes chiquito" //Contenía Jueves


//    println(weekDays.get(3))
//    println(weekDays.get(4))
//    println(weekDays.get(5))
//    println(weekDays.get(6))
//EVITAR QUE NUESTRO ARRAY SE PASE DEL TAMAÑO USAMOS EL METODO SIZE QUE NOS DEVOLVERA EL TAMAÑO DEL ARRAY
//    if(weekDays.size >= 8){
//        println(weekDays.get(7))
//    }else{
//        println("no tiene más parámetros la array")
//    }

    //CONDICIONALES

    // OR ||
    // AND &&
//
//    var profe = "Arturo"
//    if (result > 5){
//        println("El resultado es mayor a 5")
//    }
//
//    if (profe == "ALEX"){
//        println("No ma es mi profi")
//    }else {
//        println("No es mi profi :(")
//    }


}
fun showMyName(){
    var a = 36
    var b = 48
    var resultado : Int

    println("Me llamo Alex")
    print("En esta funcion realizare sumas")

    resultado= a + b
    println(resultado)
}
fun showMyLastName(){

    val nombre: String =  "Kike"
    val apellido : String = "Ramírez"
    println("Mi Apellido es Fernández")
    println ("En esta función realizare concatenación: ")
    println("$nombre $apellido")

}
fun showMyAge(){
    showMyName()
    showMyLastName()
}

//FUNCION CON PARAMETRO DE ENTRADA

fun showMyInformation(name: String, lastName: String, age: Int){
    println("Me llamo $name $lastName y tengo $age años.")
}

//FUNCION CON PARAMETRO DE SALIDA

// =====>> FORMA CONVENCIONAL
//fun add(firstNumber: Int, secondNumber: Int) : Int{
//    return firstNumber + secondNumber
//
// =======>> KOTLIN
fun add(firstNumber: Int, secondNumber: Int) : Int = firstNumber + secondNumber

fun getMonth(month : Int) {

//Guardar el resultado de un WHEN
   val response :   Any = when (month) {
        1,13,14 -> print("Enero")
        2,18,19 -> print("Febrero")
        3 -> print("Marzo")
        4 -> print("Abril")
        5 -> print("Mayo")
        6 -> print("Junio")
        7 -> print("Julio")
        8 -> print("Agosto")
        9 -> print("Septiembre")
        10 -> print("Octubre")
        11 -> print("Noviembre")
        12 -> print("Diciembre")
        in 13..19 -> print("Eso ni existe")
        !in 1..12 -> "no es un mes válido"

        else -> {
            print("No corresponde a ningún mes del año")
        }
    }
}

fun result(value: Any){
    when (value){
        is Int -> print(value + 1)
        is String -> print("El texto es $value")
        is Boolean -> if (value) print("es verdadero") else print("es falso")
    }
}