package us.lsi

abstract class Exp
  case class Prod(l: Exp, r: Exp) extends Exp
  case class Sum(l: Exp, r: Exp) extends Exp
  case class Var(n: String) extends Exp
  case class Const(v: Int) extends Exp
  