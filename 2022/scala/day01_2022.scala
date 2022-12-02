object day01_2022 extends App {
  val fn = "input_data/input-01-2022.txt"
  val data = scala.io.Source.fromFile(fn).mkString.split("\n\n").map(_.split("\n").map(_.toInt))
  val cals = data.map(_.sum)
  println("PB1: %d" format cals.max)
  println("PB2: %d" format cals.sorted.reverse.slice(0,3).sum)
}
