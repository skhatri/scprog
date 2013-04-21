import org.scalatest.FunSuite


class StringUtilTest extends FunSuite {

  test("converts to upper") {
    val s = new StringUtil()
    assert(s.upper("abc").forall(item => item == "ABC"))
  }

  test("converts to lower") {
    val s = new StringUtil()
    assert(s.lower("VAL").forall(item => item == "val"))
  }

  test("Scala Type Test") {
    println("hello".length)

    println(List(1, 2, 3) size)
    def isEven(n: Int) = (n % 2) == 0
    List(1, 2, 3, 4) filter isEven foreach println

    val b = List(1, 2, 3, 4)
    val c = 5 :: b ++ List(7, 'c', "A")
    println(c)

  }

  trait Tests {
    var projects = List("twitter", "facebook", "geomap")
  }

  test("for comprehension") {
    new Tests {
      for (project <- projects) {
        println(project)
      }
    }
  }

  test("comprehension with filter") {
    new Tests {
      for (project <- projects
           if project.contains("twitter");
           if project.startsWith("tw")
      ) println(project)
    }
  }

  test("yield comprehension") {
    new Tests {
      var ts = for (project <- projects
                    if project.startsWith("t")
      ) yield project
      println("yield printing now")
      ts.foreach(w => println(w))
    }
  }

  test("expanded scope for comprehension") {
    new Tests {
      for {project <- projects
           projectUpper = project.toUpperCase()
      } println(projectUpper)
    }
  }

}
