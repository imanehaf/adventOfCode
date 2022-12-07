object day07_2022 extends App {
  val fn = "input_data/input-07-2022.txt"
  val data = scala.io.Source.fromFile(fn).mkString
   .split("\\$ ").map(x=>x.trim.split("\n").flatMap(_.split(" "))).drop(1)

  var dir_tree = Map[String, (Int, Array[String])]()
  var path = Array[String]()
  data.foreach{cmd =>
    if (cmd(0)=="cd"){
      if (cmd(1)=="/") { path = Array("/")}
      else if (cmd(1)=="..") {  path = path.dropRight(1)}
      else {path ++= Array(cmd(1))}
    }else{
      val (dirs, size) = cmd.tail.grouped(2).partition(x=> x(0).startsWith("dir"))
      dir_tree += (path.mkString("/") -> (size.map(_(0).toInt).sum, dirs.map(_(1)).toArray))
    }

  }
  def recurse(dir:(String, (Int,  Array[String]))): Int ={
    val nsize = dir._2._1 + dir._2._2.map{ x=>
      val px = dir._1+"/"+x
      recurse((px,dir_tree(px)))
    }.sum
    dir_tree += (dir._1-> (nsize, dir._2._2))
    nsize
  }

  recurse(("/", dir_tree("/")))

  val out1 = dir_tree.values.filter(_._1<=100000).map(_._1).sum
  val out2 = dir_tree.values.map(_._1).filter(x=>( dir_tree("/")._1 - x)<=40000000).min

  println("PB1: %d" format out1)
  println("PB2: %d" format out2)
}
