// Exer03
// Exer04
package exercises.c20_actors
import scala.actors.Actor
import java.io.File
import scala.io.Source
import scala.collection.JavaConversions._

class TraverseActor(dir: File) extends Actor {
  
  def act() {
    val files = getAllFiles(dir)
    val actors = new Array[FileActor](files.size)
    
    val accumulateActor = new AccumulateActor(files.size)
    accumulateActor.start()
    
    var i = 0
    for (file <- files) {
      actors(i) = new FileActor(file, accumulateActor)
      actors(i).start()
      
      i += 1
    }
    
    exit()
  }
  
  def getAllFiles(directory: File): Seq[File] = {
    val dirChildren: Seq[File] = directory.listFiles.filter(_.isDirectory)
    val fileChildren: Seq[File] = directory.listFiles.filter(!_.isDirectory)
    fileChildren ++ dirChildren.flatMap(getAllFiles _)
  }
}

class FileActor(file: File, accumulateActor: AccumulateActor) extends Actor {
  val regex = """[a-zA-Z0-9_\.]+[\s]*=[\s]*[a-zA-Z0-9_\.]""".r
  
  def act() {
    println("* Actor for file '" + file.getName() + "' started.")
    
    val content = try {
      Source.fromFile(file).mkString
    } catch {
      case e: java.nio.charset.MalformedInputException => ""
    }
    var nMatches = 0
    
    for (m <- regex.findAllIn(content)) {
      println(file.getCanonicalPath() + ": " + m)
      nMatches += 1
    }
    
    accumulateActor ! nMatches
    
    exit()
  }
}

class AccumulateActor(totalFiles: Int) extends Actor {
  var filesReceived = 0
  var totalMatches = 0
  
  def act() {
    println("* Accumulator will receive " + totalFiles + " files.")
    
    while (true) {
      receive {
        case nMatches: Int => {
          totalMatches += nMatches
          filesReceived += 1
          
          if (filesReceived == totalFiles) {
            println(totalMatches + " matches found.")
            exit()
          }
        }
      }
    }
    
  }
  
}

object FileActors extends App {
  new TraverseActor(new File(args(0))).start()
}