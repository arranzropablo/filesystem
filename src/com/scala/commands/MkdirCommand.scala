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
      doMkdir(state, name)
    }

  }

  def doMkdir(state: State, name: String): State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      if (path.isEmpty) {
        currentDirectory.addEntry(newEntry)
      }
    }

    val wd = state.workingDirectory

    val allDirsInPath = wd.getAllParentFolders
    val newDir = Directory.empty(wd.path, name)

    val newRoot = updateStructure(state.root, allDirsInPath, newDir)
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)
  }

}
