import org.scalatest.FunSuite

class RegexMatchTest extends FunSuite {

  trait Tests {
    val BookExtractorRE = """Book: title=([^,]+),\s+authors=(.+)""".r
    val ScoreExtractorRE = """Home: ([^,]+),\s+Away:\s+([^,]+),\s+Score:\s+([0-9]+)-([0-9]+)""".r

    val catalog = List(
      "Book: title=Programming in Scala, authors=Alex Payne",
      "Book: title=Scala in Depth, authors=Joshua Suereth",
      "App: title=Big Data, authors=Suresh Khatri",
      "Home: Real Madrid, Away: Athletico Madrid, Score: 3-1",
      "Home: Wigan, Away: Man United, Score: 0-4",
      "Home: Man City, Away: Arsenal, Score: 1-1"
    )
  }

  test("regex test exp extractor") {
    new Tests {
      for (item <- catalog) {
        item match {
          case BookExtractorRE(title, authors) =>
            println ("Book \"" + title + "\", written by " + authors)
          case ScoreExtractorRE(home, away, homescore, awayscore) =>
            println ("Home Team: "+home + " scored " + homescore +" and Away team: "+ away + " scored " + awayscore)
          case entry =>
            println ("Unrecognized!!! " + entry)
        }
      }
    }
  }

  test("multi match, match summary") {
    new Tests {
      for (item <- catalog) {
        item match {
          case ScoreExtractorRE(home, away, homescore, awayscore) if(homescore> awayscore) =>
            println (home + " beat " + away + " " + homescore + "-" + awayscore +" at home ")
          case ScoreExtractorRE(home, away, homescore, awayscore) if(awayscore> homescore) =>
            println (away + " beat " + home + " " + awayscore + "-" + homescore +" away from home ")
          case ScoreExtractorRE(home, away, homescore, awayscore) if (homescore == awayscore) =>
            println (home + " and " + away + " drew " + homescore + "-" + awayscore +".")
          case other => println()
        }
      }
    }
  }
}
