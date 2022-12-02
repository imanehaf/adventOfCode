object day02_2022 extends App {
  //  val fn = "input_data/test_data/input-02-2022-test.txt"
  val fn = "input_data/input-02-2022.txt"
  val data = scala.io.Source.fromFile(fn).mkString.split("\n")
  val winning_strat = Map('A' -> 'Y', 'B' -> 'Z', 'C' -> 'X')
  val draw_strat = Map('A' -> 'X', 'B' -> 'Y', 'C' -> 'Z')
  val losing_strat = Map('A' -> 'Z', 'B' -> 'X', 'C' -> 'Y')
  val outcome = List('X', 'Y', 'Z').zip(List(losing_strat, draw_strat, winning_strat)).toMap

  val hand_score = List('X', 'Y', 'Z').zipWithIndex.toMap

  val total_score = data.map { x => hand_score(x.last) + 1 + round_score(x.head, x.last) }.sum

  val total_score2 = data.map { x =>
    val hand = outcome(x.last)(x.head)
    hand_score(hand) + 1 + round_score(x.head, hand)
  }.sum

  def round_score(in: Char, hand: Char): Int = {
    if (hand == winning_strat(in)) 6
    else if (hand == draw_strat(in)) 3
    else 0
  }

  println("PB1: %d" format total_score)
  println("PB2: %d" format total_score2)
}
