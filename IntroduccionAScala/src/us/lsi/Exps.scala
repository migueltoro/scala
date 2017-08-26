package us.lsi

object Exps {

  type Environment = String => Int

  def eval(e: Exp, env: Environment): Int = e match {
    case Prod(l, r) => eval(l, env) * eval(r, env)
    case Sum(l, r) => eval(l, env) + eval(r, env)
    case Var(n) => env(n)
    case Const(v) => v
  }

  def isConst(e: Exp) : Boolean = e match {
    case Prod(l, r) => isConst(l)&&isConst(r)
    case Sum(l, r) => isConst(l)&&isConst(r)
    case Var(n) => false
    case Const(v) => true
  }
  
  def derive(e: Exp, v: String): Exp = e match {
    case Prod(l, r) => Sum(Prod(derive(l, v),r),Prod(l,derive(r, v)))
    case Sum(l, r) => Sum(derive(l, v), derive(r, v))
    case Var(n) if (v == n) => Const(1)
    case _ => Const(0)
  }

  def evalConst(e: Exp, v :String, env : Environment): Exp = e match {
    case Prod(l, r) => (isConst(l),isConst(r)) match {
      case(true,true) => Const(eval(l,env)*eval(r,env))
      case(true,false) => Prod(Const(eval(l,env)),evalConst(r,v,env))
      case(false,true) => Prod(evalConst(l,v,env), Const(eval(r,env)))
      case(false,false) => Prod(evalConst(l,v,env),evalConst(r,v,env))
    }
    case Sum(l, r) => (isConst(l),isConst(r)) match {
      case(true,true) => Const(eval(l,env)+eval(r,env))
      case(true,false) => Sum(Const(eval(l,env)),evalConst(r,v,env))
      case(false,true) => Sum(evalConst(l,v,env), Const(eval(r,env)))
      case(false,false) => Sum(evalConst(l,v,env),evalConst(r,v,env))
    }
    case Var(x) => Var(x)
    case Const(n) => Const(n)
  }
  
  def simplify(e: Exp): Exp = e match {
    case Prod(Const(0), r) => Const(0)
    case Prod(l,Const(0)) => Const(0)
    case Prod(Const(1), r) => simplify(r)
    case Prod(l,Const(1)) => l
    case Prod(l,r) => Prod(simplify(l),simplify(r))
    case Sum(Const(0), r) => simplify(r)
    case Sum(l,Const(0)) => simplify(l)
    case Sum(l,r) if(l==r) => Prod(Const(2),simplify(r))
    case Sum(l,r) if(l!=r) => Sum(simplify(l),simplify(r))
    case Var(x)  => Var(x)
    case Const(n) => Const(n)
  }
  
  
  def show(e: Exp): String = e match {
    case Prod(l, r) => "(" + show(l) + "*" + show(r) + ")"
    case Sum(l, r) => "(" + show(l) + "+" + show(r) + ")"
    case Var(n) => "" + n
    case Const(v) => "" + v
  }

  def copy(e: Exp): Exp = e match {
    case Prod(l, r) => Prod(copy(l),copy(r))
    case Sum(l, r) => Sum(copy(l),copy(r))
    case Var(x) => Var(x)
    case Const(n) => Const(n)
  }
  
  /**
   * Métodos de extensión para el tipo Exp
   */
  implicit class ExtendedExp(val e: Exp) extends AnyVal {

    def eval(env: Environment): Int = Exps.eval(e, env)

    def derive(v: String): Exp = Exps.derive(e, v)
    
    def simplify(): Exp = Exps.simplify(Exps.evalConst(e,null,null)) 
    
    def show(): String = Exps.show(e)
    
    def copy(): Exp = Exps.copy(e)

  }
  
}