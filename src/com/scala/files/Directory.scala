package com.scala.files

import com.scala.files.Directory._

case class Directory(override val parentPath: String, override val name: String, contents: List[DirEntry]) extends DirEntry(parentPath, name) {

  def hasEntry(name: String): Boolean = this.contents.exists(_.name == name)

  def addEntry(dirEntry: DirEntry): Directory = this.copy(contents = dirEntry :: this.contents)

  def getAllParentFolders: List[String] = parentPath.substring(1).split(SEPARATOR).filter(_.isEmpty).toList

  def path: String = parentPath.concat(SEPARATOR).concat(name)

  def findDescendant(path: List[String]): Directory = ???

  override def asDirectory: Directory = this

}

object Directory {
  val SEPARATOR = "/"
  val ROOT_PATH = "/"

  def ROOT: Directory = Directory.empty("", ROOT_PATH)

  def empty(parentPath: String, name: String): Directory = new Directory(parentPath, name, List())

}