import org.scalatest.FunSuite

object Day extends Enumeration {
  val Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday = Value

  def isWorkDay(d:Day.Value) = !(d == Day.Sunday || d == Day.Saturday)
}


object Team extends Enumeration {
  val RM = Value("Real Madrid")
  val MU = Value("Man United")
  val BAR = Value("Barcelona")
  val BM = Value("Bayern Munich")
  val JUV = Value("Juventus")
  val ARS = Value("Arsenal")
  val ACM = Value("AC Milan")

  def isBig(t:Team.Value) = (t == Team.MU || t == Team.RM || t == Team.BAR)
}

class EnumerationTest extends FunSuite {


  test("enum print days") {
    for (day <- Day.values) {
      println(day.id + " " + day)
    }
    for (team <- Team.values) {
      println(team.id + " " + team)
    }
  }

  test("enum filter day before 3") {
    for {day <- Day.values
         if (day.id < 3)
    } println(day)

    Day.values.filter(p => Day.isWorkDay(p)).foreach(println)
  }

  test("enum print print big teams") {
    Team.values.filter(t=>Team.isBig(t)).foreach(println)
  }

}
