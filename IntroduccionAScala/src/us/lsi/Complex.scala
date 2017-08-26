package us.lsi

class Complex(real: Double, imaginary: Double) {
    def re = real
    def im = imaginary
    override def toString() =
        "" + re + (if (im < 0) "" else "+") + im + "i"
    override def equals(that: Any): Boolean =
        that.isInstanceOf[Complex] && {
        val o = that.asInstanceOf[Complex]
        o.re == re && o.im == im
    }
}