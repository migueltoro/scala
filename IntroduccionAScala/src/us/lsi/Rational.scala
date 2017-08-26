package us.lsi

class Rational(n: Int, d: Int) extends Ordered[Rational]{
    
    require(d != 0, "d debe ser distinto de cero")    // precondition, triggering an IllegalArgumentException if not met 
    
    private def gcd(x: Int, y: Int): Int = {
        if (x == 0) y
        else if (x < 0) gcd(-x,y)
        else if (y < 0) -gcd(x,-y)
        else gcd(y % x, x)
    }
    
    private val g = gcd(n, d)
   
    val numer: Int = n/g
    val denom: Int = d/g
    def + (that: Rational) =
        new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
    def - (that: Rational) =
        new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
    def * (that: Rational) = 
        new Rational(numer * that.numer, denom * that.denom)
    def / (that: Rational) = 
        new Rational(numer * that.denom, denom * that.numer)
    def compare(that: Rational): Int =
        if (numer * that.denom > that.numer * denom) 1
        else if (numer * that.denom < that.numer * denom) -1
        else 0
    override def toString() =
        "" + numer + "/" + denom
    override def equals(that: Any): Boolean =
        that.isInstanceOf[Rational] && {
        val o = that.asInstanceOf[Rational]
        o.numer == numer && o.denom == denom
    }
}