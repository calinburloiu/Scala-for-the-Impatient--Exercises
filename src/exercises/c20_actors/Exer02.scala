// Exer02
package exercises.c20_actors
import javax.imageio.ImageIO
import java.io.File
import java.awt.image.BufferedImage
import java.io.IOException
import java.awt.image.DataBufferByte
import scala.actors.Actor
import scala.collection.mutable.ArrayBuffer
import java.io.ByteArrayInputStream

case class ImgMsg(pixels: Array[Byte])
case class InvImgMsg(pixels: Array[Byte], pieceId: Int)

class InverterActor(val id: Int, joinerActor: JoinerActor) extends Actor {
  def act() {
    while (true) {
      receive {
        case ImgMsg(pixels) => {
          invert(pixels)
          joinerActor ! InvImgMsg(pixels, id)
        }
      }
    }
  }
  
  def invert(pixels: Array[Byte]) {
    for (i <- 0 until pixels.size) {
      pixels(i) = (pixels(i) ^ 0xff).toByte
    }
  }
}

class JoinerActor(nPieces: Int, filename: String) extends Actor {
  val pieces = new Array[Array[Byte]](nPieces)
  var piecesReceived = 0
  
  def act() {
    while (true) {
      receive {
        case InvImgMsg(pixels, pieceId) => {
          println("* Received piece from InverterActor " + pieceId + ".")
          pieces(pieceId) = pixels
          piecesReceived += 1
          
          if (piecesReceived == nPieces)
            joinAndSave()
        }
      }
    }
  }
  
  def joinAndSave() {
    val bufSize = pieces.foldLeft(0) { _ + _.size }
    val buf = new ArrayBuffer[Byte](bufSize)
    
    // Join pieces.
    println("* Joining pieces...")
    for (i <- 0 until pieces.size) {
      buf ++= pieces(i)
    }
    
    val inputStream = new ByteArrayInputStream(buf.toArray)
    val img = ImageIO.read(inputStream)
    
    // Save.
    println("*Saving the output image...")
    ImageIO.write(img, "jpg", new File(filename))
  }
}

class ImageInverter(nPieces: Int, filenameIn: String, filenameOut: String) {
  val img: BufferedImage = ImageIO.read(new File(filenameIn))
  
  def start() {
    if (nPieces == 1) {
      startSerial()
    } else if (nPieces > 1) {
      startDistributed()
    } else {
      println("Invalid number of pieces!")
    }
  }
  
  def startSerial() {
    // Get pixels.
    val pixels = img.getRaster().getDataBuffer().asInstanceOf[DataBufferByte].getData()
    
    // Invert them.
    for (i <- 0 until pixels.size) {
      pixels(i) = (pixels(i) ^ 0xff).toByte
    }
    
    // Save.
    ImageIO.write(img, "jpg", new File(filenameOut))
  }
  
  def startDistributed() {
    val pixels = img.getRaster().getDataBuffer().asInstanceOf[DataBufferByte].getData();
    val pieceSize = pixels.size / nPieces
    
    val joinerActor = new JoinerActor(nPieces, filenameOut)
    joinerActor.start()
    
    val inverterActors = new Array[InverterActor](nPieces)
    for (id <- 0 until nPieces) {
      inverterActors(id) = new InverterActor(id, joinerActor)
      inverterActors(id).start()
      
      val piece = pixels.slice(pieceSize * id, pieceSize * (id + 1))
      println("* Sending piece to InverterActor " + id + "...")
      inverterActors(id) ! ImgMsg(piece)
    }
  }
}

/* Send as command line arguments the number of inverter actors, the input file
 * name and the output file name.
 */
object Exer02 extends App {
  println("* Application started.")
  new ImageInverter(args(0).toInt, args(1), args(2)).start()
}