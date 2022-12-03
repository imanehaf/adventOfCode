object day03_2022 extends App {
  val fn = "input_data/input-03-2022.txt"
  val data = scala.io.Source.fromFile(fn).mkString.split("\n")
  val priorities = (('a' to 'z') ++ ('A' to 'Z')).zipWithIndex.toMap

  val out1 = data.flatMap { x =>    x.grouped(x.length / 2).map(_.toSet).reduce(_ intersect _)  }
  val out2 = data.grouped(3).flatMap { x =>    x.map(_.toSet).reduce(_ intersect _)  }.toArray
  
  def getSum(out: Array[Char]): Int = out.map(priorities(_) + 1).sum

  println("PB1: %d" format getSum(out1))
  println("PB2: %d" format getSum(out2))
}
