package com.rockthejvm.part1asMINE

import scala.annotation.tailrec

object Recap {

  //values ,types, expressions
  val aCondition = false

  val anIfExpression = if (aCondition) 42 else 55 //

  val codeBlock = {
    if (aCondition) 54
    100000
  }

  def aFunction(x: Int): Int = x + 1

  @tailrec def factorial(n: Int, acc: Int): Int =
    if (n <= 0) acc
    else factorial(n - 1, n * acc)

  class Animal

  class Dog extends Animal

  val aDog: Animal = new Dog

  //abstract
  trait Carnivore {
    infix def eat(a: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override infix def eat(a: Animal): Unit = println("I'm a croc, I will eat everything")
  }

  //method notation
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog //"operator/infix position

  val aCarnivore = new Carnivore {
    override infix def eat(a: Animal): Unit = print("Im a carnivore")
  }

  //generics
  abstract class LList[A] {
    //Type is know inside the implementation
  }

  //singleton and companions (same name)
  object LList //companion object used for instance-independent (static) fields or methods

  //case classes
  case class Person(name: String, age: Int)

  //enums
  enum BasicColors {
    case RED, GREEN, BLUE
  }

  def throwSomeException(): Int =
    throw new RuntimeException

  val aPotentialFailure = try {
    //code that might fail
    throwSomeException()
  } catch {
    case e: Exception => "I caught an exception"
  } finally {
    //closing resources
    println("some important logs")
  }

  //functional programing
  val incrementer = new Function[Int, Int] {
    override def apply(x: Int): Int = x + 1
  }

  val two = incrementer.apply(1)
  val two2 = incrementer(1)

  //lambdas
  val anomymousIncrementor = (x: Int) => x + 1
  //hofs = higher-order functions
  val anIncrementerList = List(1, 2, 3).map(anomymousIncrementor)
  //map, flatmap, filter

  //for-comprehensions
  val pairs = for {
    number <- List(1, 2, 3)
    char <- List('a', 'b')
  } yield s"$number-$char"

  val anOption: Option[Int] = Option(42)

  val x = 2
  val order = x match {
    case 1 => "first"
    case 2 => "second"
    case _ => "not important"
  }

  val bob = Person("Bob", 22)
  val greeting = bob match {
    case Person(n, _) => s"Hi, my name is $n"
  }


  def main(args: Array[String]): Unit = {
    print(anIfExpression)
    print(codeBlock)
  }

  //scala 3 braceless syntax
  val pairs_v2 = for
    number <- List(1, 2, 3)
    char <- List('a', 'b')
  yield s"$number-$char"

  val numbers: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 20)
  for (number <- numbers)
    if (number % 2 == 0)
      println(number)

  val number = for (number <- numbers if number % 2 ==0)
    println(number)


  println("*******************")
  for (
  number <- numbers
   if number % 2 ==0
   if number > 4
   ) println(number)

  class BracelessAnimal:
    def eat: Unit =
      println("I'm doing something")
      println("I'm eating")
    end eat
  end BracelessAnimal

}
