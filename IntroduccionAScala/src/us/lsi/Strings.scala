package us.lsi

object Strings {

  def ex() {
    val a = "foo"
    val b = "foo"
    val c = "bar"
    println(a == b) // true
    println(a == c) // false

    val foo = """This is 
    a multiline
    String"""

    val speech1 = """Four score and
               |seven years ago""".stripMargin

    val speech2 = """Four score and
               #seven years ago""".stripMargin('#')

    val speech3 = """Four score and
               |seven years ago
               |our fathers""".stripMargin.replaceAll("\n", " ")

    // use single- and double-quotes in a multiline string
    val s = """This is known as a
        "multiline" string
        or 'heredoc' syntax"""

    println(speech1)
    println(speech2)
    println(speech3)
    println(s)

    val name = "Joe"
    val age = 42
    val weight = 180.5

    // prints "Hello, Joe"
    println(s"Hello, $name")

    // prints "Joe is 42 years old, and weighs 180.5 pounds."
    println(f"$name is $age years old, and weighs $weight%.1f pounds.")

    // 'raw' interpolator
    println(raw"foo\nbar")
  }
}