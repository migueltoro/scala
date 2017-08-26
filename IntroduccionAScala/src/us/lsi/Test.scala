package us.lsi

import Exps._

import us.lsi._

object Test {
  
  def main(args: Array[String]) {

    val exp: Exp = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
    val env: Environment = { case "x" => 5 case "y" => 7 }
    println("Expression: " + exp.show())
    println("Evaluation with x=5, y=7: " + exp.eval(env))
    println("Derivative relative to x:\n " + exp.derive("x").show())
    println("Derivative relative to y:\n " + exp.derive("y").show())
    println("Exp:\n " + exp.show())
    println("Simplify Exp :\n " + exp.simplify().show())
    println("Simplify dx Exp :\n " + exp.derive("x").simplify().show())
    println("Simplify dy Exp :\n " + exp.derive("y").simplify().show())
    println(Sum(Var("x"),Var("x")).simplify())
    println(exp == exp.derive("x"))
    val exp1 = exp.copy()
    println(exp.eq(exp1))
    println(exp == exp1)
    println(Var("x") == Var("x"))
    Tuples.divmod(567, 451) match {
      case (n, d) => println("quotient: " + n + ", rest: " + d)
    }
    val r1 = new Rational(6, 4)
    val r2 = new Rational(14, 128)
    if (r1 > r2) println(r1)
    else println(r2)
    println(ForExamples.values(10) mkString "\n")
    val cell = new Reference[Int]
    cell.set(13)
    println("Reference contains the half of " + (cell.get * 2))
    val p = Punto.create(2.0, 30.0)
    println(p)
    Strings.ex()
    ForExamples.ex()
    RegularExpressions.ex1()
  }
}