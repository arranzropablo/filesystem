package com.scala.filesystem

import java.util.Scanner

import com.scala.commands.Command
import com.scala.files.Directory

object Filesystem extends App {

  val root = Directory.ROOT
  var state = State(root, root)
  val scanner = new Scanner(System.in)

  while (true) {
    state.show()

    state = Command.from(scanner.nextLine()).apply(state)
  }
  print("$ ")
  println()

}