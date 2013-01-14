package exercises.c09_files_regex
import scala.io.Source
import java.io.PrintWriter

class WebPage(val url: String) {
  val reImgTag = """<img ([a-z\-]+="[^"]*" )*src="([^"]+)"[^\>]*""".r
  val reSrc = """.*src="([^"]+)".*""".r
  
  def getImgUrls = {
    val lines = Source.fromURL(url).getLines
    
    for (line <- lines; reSrc(img) = reImgTag.findAllIn(line)) yield img
  }
}

class OutputWriter(urls: Iterator[String], outputDir: String) {
  private val urlsPrinter = new PrintWriter(outputDir + "/" + "img_urls.txt")
  private var i = 0
  
  def run() {
    println(urls.toArray.length)
    for (url <- urls) {
      writeImage(url)
      appendUrl(url)
    }
    
    urlsPrinter.close
  }
  
  def writeImage(url: String) {
    
  }
  
  def appendUrl(url: String) {
    println(url)
    urlsPrinter.println(url)
  }
}

object ImgDownloader extends App {
  val pageUrl = args(0)
  val outputDir = args(1)

  val webPage = new WebPage(pageUrl)
  val outputWriter = new OutputWriter(webPage.getImgUrls, outputDir)
  outputWriter.run()
}