object day04_2022 extends App {
  val fn = "input_data/input-04-2022.txt"
  val data = scala.io.Source.fromFile(fn).mkString.split("\n")
    .map(_.split(',').map(_.split('-').map(_.toInt)))

  val out1 = data.count { x =>    (x.head zip x.last).map(a => a._2 - a._1).product <= 0  }

  val out2 = data.map { x =>    x.sortBy(_.head)  }.count { x => x.head.last >= x.last.head }

  println("PB1: %d" format out1)
  println("PB2: %d" format out2)
}
