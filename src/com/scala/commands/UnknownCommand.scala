package com.scala.commands

import com.scala.filesystem.State

class UnknownCommand extends Command {

  override def apply(state: State): State = state.copy(output = "Command not found.")

}
