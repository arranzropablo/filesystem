package com.scala.filesystem

import com.scala.files.Directory
import State._

case class State(root: Directory, workingDirectory: Directory, output: String = "") {

  def show(): Unit = {
    println(output)
    print(SHELL_TOKEN)
  }

}

object State {
  val SHELL_TOKEN = "$ "
}