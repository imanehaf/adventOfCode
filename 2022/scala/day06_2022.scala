object day06_2022 extends App {
  val fn = "input_data/input-06-2022.txt"
  val data = scala.io.Source.fromFile(fn).mkString.split("")

  def slider(s: Array[String], num: Int): Int = s.sliding(num, 1).takeWhile { x => x.toSet.size != num }.toArray.length + num

  println("PB1: %d" format slider(data, 4))
  println("PB2: %d" format slider(data, 14))
}
