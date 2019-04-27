package exercise3.flexibels

object VariableTest { // Um dieses Objekt müssen sie sich gar nicht weiter kümmern!
   
  def run(toTest: VariableStructure){
    if(toTest==null) println("Setzen Sie zuerst die Aufgabe 1 (Variable Arrays) vom Übungsblatt um!")
    else{
      toTest.add("A")
      toTest.add("B")
      toTest.add("C")
      toTest.add("D")
      println("Element an der Position 1 ist: " + toTest.get(1) + " (sollte = 'B' sein)")
      println("Die Laenge des Arrays ist: " + toTest.size() + " (sollte = '4' sein)")
      println("Ist das Array leer?: " + toTest.isEmpty() + " (sollte = 'false' sein)")
      println("Das Element an der Position 2 wird nun entfernt und ist: " + toTest.remove(2) + " (sollte = 'C' sein)")
      println("Das verbleibende Array sieht nun so aus: " + toTest.toString() + " (sollte = '(A,B,D)' sein)")
    }
  }  
}