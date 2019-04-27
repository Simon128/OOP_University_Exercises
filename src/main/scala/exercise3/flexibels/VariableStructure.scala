package exercise3.flexibels

trait VariableStructure {
  
  def add(o: Any)           // Hängt das Objekt 'o' an das Ende des Arrays an.
  def size(): Int           // Gibt die Anzahl der Objekte im Array zurück. Beachte: Indizes liegen zwischen '0' und 'size()-1'.
  def remove(i: Int): Any   // Entfernt das Objekt mit Index i aus dem Array und gibt es zurück.
  def get(i: Int): Any      // Gibt das Objekt mit Index i aus dem Array zurück.
  def isEmpty(): Boolean    // Prüft ob das Array genau 0 Elemente enthält.
  
}