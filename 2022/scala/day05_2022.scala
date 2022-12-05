import scala.collection.mutable.Queue

object day05_2022 extends App {
//  val fn = "input_data/input-05-2022.txt"
  val fn = "input_data/test_data/input-05-2022-test.txt"
  val data = scala.io.Source.fromFile(fn).mkString.split("\n\n")
  val Stack = data.head.split("\n").map(x=> x.grouped(4).toArray).transpose.map(x=> x.filter(_.matches(".*\\w.*")))
  val moves = data.last.split("\n").map(_.split(" "))
    .map { x =>x.filter(_.matches("\\d+"))}
    .map{x => (x(0).toInt, x(1).toInt - 1, x(2).toInt - 1)}

  def craning(stack: Array[Array[String]], model:Int): String= {
    moves.foreach { case (num, pv, nxt) =>
      val load = if (model==9000) stack(pv).splitAt(num)._1.reverse else stack(pv).splitAt(num)._1
      stack(nxt) = load ++ stack(nxt)
      stack(pv) = stack(pv).splitAt(num)._2
    }
    stack.map(_.head.replaceAll("[^\\w+\\s]","").trim).mkString
  }

  println("PB1: %s" format craning(Stack.clone(), 9000))
  println("PB2: %s" format craning(Stack, 9001))
}
