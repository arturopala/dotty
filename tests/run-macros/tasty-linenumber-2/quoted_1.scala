import scala.quoted._

class LineNumber(val value: Int) {
  override def toString: String = value.toString
}

object LineNumber {

  implicit inline def line: LineNumber = ${lineImpl}

  def lineImpl(using Quotes) : Expr[LineNumber] = {
    import quotes.reflect._
    '{new LineNumber(${Expr(Position.ofMacroExpansion.startLine)})}
  }

}
