class StringUtil {
  def upper(strings: String*) = strings.map(_.toUpperCase())

  def lower(strings: String*) = strings.map(_.toLowerCase())
}
