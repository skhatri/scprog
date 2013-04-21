import org.scalatest.FunSuite

class PatternMatchTest extends FunSuite {

  trait Tests {
  }

  test("print even num") {
    for (i <- 1 until 10) {
      i match {
        case 2 => println("its 2")
        case _ => println("not 2")
      }
    }
  }

  test("list match sequence") {
    new Tests {
      val list1 = List(1, 2, 2, 3)
      val list2 = List(1, 2, 0)
      val emp = List()

      for (l <- List(list1, list2, emp)) {
        l match {
          case List(_, 2, _) => println("3 elements, 2nd is 2")
          case List(_*) => println("Any list with 0 or more elements")
        }
      }
    }
  }

  test("match on tuples") {
    val tupA = ("Hi", "There")
    val tupB = ("Data", "Te")
    for (tup <- List(tupA, tupB)) {
      tup match {
        case (first, second) if first == "Hi" => println("tuple starting with hi")
        case (first, second) => println("two things " + first + " and " + second)
      }
    }

  }
}
