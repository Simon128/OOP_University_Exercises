package exercise3.flexibels

object Test {
  var testObj: VariableStructure = null
  
  def main(args: Array[String]): Unit = {
    testObj = new VariableArray()
    // Hier muss zu gegebener Zeit der Aufruf aus Aufgabe1 f) ergänzt werden!   
    VariableTest.run(testObj)
  }
}