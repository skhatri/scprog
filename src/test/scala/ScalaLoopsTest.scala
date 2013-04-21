import org.scalatest.FunSuite

class ScalaLoopsTest extends FunSuite {

  trait Tests {
    var projects = List("twitter", "facebook", "gowalla")
  }

  test("generator start to end") {
    for (i <- 1 to 10) print(i)
  }

  test("generator start until end") {
    for (i <- 1 until 10) print(i)
  }


}
