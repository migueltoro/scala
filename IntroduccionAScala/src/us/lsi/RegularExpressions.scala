package us.lsi

import scala.util.matching.Regex

object RegularExpressions {
  
   def ex1() = {
    // create a regex with '.r'
    val numPattern1 = "[0-9]+".r
    val address1 = "123 Main Street"                 // "123 Main Street"
    val match1 = numPattern1.findFirstIn(address1)    // Some(123)

    println(match1)
    
    // create a regex with Regex class
    
    val numPattern2 = new Regex("[0-9]+")
    val address2 = "123 Main Street Unit 639"
    val matches2 = numPattern2.findAllIn(address2).toList           // non-empty iterator
    val matches3 = numPattern2.findAllIn(address2).toArray mkString ("(",",",")") // Array(123, 639)
    
    println(matches2)
    println(matches3)
    
    val regex = "[0-9]".r
    regex.replaceAllIn("123 Main Street", "x")

    println("123 Main Street".replaceAll("[0-9]", "x"))   // "xxx Main Street"
	  println("Hello world".replaceFirst("H", "J"))         // "Jello world"
	  println("99 Luft Balloons".replaceAll("9", "1"))      // "11 Luft Balloons"
	  println("99 Luft Balloons".replaceFirst("9", "1"))    // "19 Luft Balloons"
	  
	  val pattern = "([A-Za-z]+) (\\d+), (\\d+)".r
    val pattern(month, day, year) = "June 22, 2012"

    println((month, day, year))
    
    val a = Array(1,2,3)
    println(a mkString)                  // "123"
    println(a mkString ",")             // "1,2,3"
    println(a mkString " ")             // "1 2 3"
    println(a mkString ("(",",",")"))   // "(1,2,3)"
    
    
    
   }
}