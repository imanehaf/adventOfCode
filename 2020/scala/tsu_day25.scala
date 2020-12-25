object tsu_day25 extends App {
  val fn = System.getenv().getOrDefault("FILE_PATH", "/home/tsunade/input-tsu-d25.txt").trim
  val publicKeys = scala.io.Source.fromFile(fn).getLines().map(_.trim.toLong).toArray

  val loopSize = publicKeys.map(encryption(7, _)._1.get)
  println("Encryption key: " + encryption(publicKeys.head, Long.MaxValue, loopSize.last + 1)._2) // Encryption key: 7269858
  println("It's a wrap, Folks!")

  def encryption(subjNum: Long, ekey: Long, lp: Int = Int.MaxValue): (Option[Int], Long) = {
    var v = 1L
    (Range(1, lp).find { _ =>
      v = (v * subjNum) % 20201227L
      v == ekey    }, v)
  }
}