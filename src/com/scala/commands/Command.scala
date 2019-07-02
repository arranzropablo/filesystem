package com.scala.commands

import com.scala.filesystem.State

trait Command {

  def apply(state: State): State

}

object Command {

  def incorrectCommand(name: String): Command = (state: State) => state.copy(output = s"Command $name has incorrect number of parameters")

  def from(input: String  ): Command = {
    val tokens = input.split(" ")

    tokens match {
      case Array("mkdir", _*) => {
        if (tokens.length != 2) incorrectCommand("mkdir") else new MkdirCommand(tokens(1))
      }
      case _ => new UnknownCommand
    }
  }

}