package us.lsi

object ForExamples {
    
    def isPrime(n: Int) = List.range(2, n) forall (x => n % x != 0)

    def values(n: Int) = for(i <- 1 until n;
                             j <- 1 until i;
                             if isPrime(i+j)) yield (i, j)
                             
    // a custom method
    def toLower(c: Char):Char = (c.toByte+32).toChar

   

    // pass method to 'foreach'
    def printIt(c: Char) { println(c) }
    
    
    
    def ex() = {
       // map
	     println("HELLO".map(toLower))  // "hello"

       // for/yield
       println(for (c <- "HELLO") yield toLower(c))
       
       "HAL".foreach(c => printIt(c))
    
       "HAL".foreach(printIt)
    }

}