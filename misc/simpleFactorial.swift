func FirstFactorial(_ num: Int) -> Int { 
    var factorial = 1
    for x in 2 ... num {
        factorial = factorial * x
    }
  return factorial
}