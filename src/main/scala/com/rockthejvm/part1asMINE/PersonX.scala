package com.rockthejvm.part1asMINE

//apply method is special
object PersonX {
  def apply(firstName: String, lastName: String) = new PersonX(firstName, lastName)
}

class PersonX(firstName: String, lastName: String) {
  def getName: String = firstName + " " + lastName
}

//This get companion Object and apply method
//immutable aguments in parameter list
//copy method to make modified copies
//hashcode equals toString by default
//patern matching
case class Course(title: String, author: String)


//scala> val scalaCourse = Course("Scala", "Bora")
//val scalaCourse: Course = Course(Scala,Bora)
//
//scala> val anotherCourse = Course("Scala", "Bora")
//val anotherCourse: Course = Course(Scala,Bora)
//
//scala> scalaCourse == anotherCourse
//val res0: Boolean = true
//
//scala> val newScalaCourse = scalaCourse.copy(title = "New Scala")
//val newScalaCourse: Course = Course(New Scala,Bora)