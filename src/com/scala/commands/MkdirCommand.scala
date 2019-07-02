package com.scala.commands

import com.scala.files.{DirEntry, Directory}
import com.scala.filesystem.State

class MkdirCommand(name: String) extends Command {

  override def apply(state: State): State = {
    if (state.workingDirectory.hasEntry(name)){
      state.copy(output = s"$name already exists.")
    } else if (name.contains(Directory.SEPARATOR)){
      state.copy(output = s"$name: illegal name.")
    } else {
      val newContents = Directory.empty(state.workingDirectory.parentPath, name) :: state.workingDirectory.contents
      val newWD = state.workingDirectory.copy(contents = newContents)
      state.copy(workingDirectory = newWD)
    }

  }
    //val newDir: DirEntry =  Directory.empty(state.workingDirectory.parentPath, name)
    //state.copy(workingDirectory = state.workingDirectory.copy(contents = state.workingDirectory.contents :: newDir))


}
