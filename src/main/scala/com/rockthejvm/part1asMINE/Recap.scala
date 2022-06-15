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


  //scala 3 braceless syntax
  val pairs_v2 = for
    number <- List(1, 2, 3)
    char <- List('a', 'b')
  yield s"$number-$char"

  val numbers: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 20)
  for (number <- numbers)
    if (number % 2 == 0)
      println(number)

  val number = for (number <- numbers if number % 2 == 0)
    println(number)


  println("*******************")
  for (
    number <- numbers
    if number % 2 == 0
    if number > 4
  ) println(number)

  class BracelessAnimal:
    def eat: Unit =
      println("I'm doing something")
      println("I'm eating")
    end eat
  end BracelessAnimal

  val letters = List("a", "b", "c")
  val numbers_v2 = List(1, 2, 3)

  for (number <- numbers) {
    for (letter <- letters) {
      println(number + " => " + letter)
    }
  }

  //Below is the same

  for {
    number <- numbers
    letter <- letters
  } println(number + " => " + letter)

  //Functional for loop does not mutate original list
  val numbers_v3 = List(1, 2, 3, 4, 5, 6, 6)
  for (number <- numbers) yield number * 2
  for (number <- numbers)
    yield {
      val n = number * 2
      println(n)
    }

  for (number <- numbers if (number % 2 == 0)) yield {
    number * 2
  }

  //generates new list
  val newList: List[String] = for {
    number <- numbers
    letter <- letters
  } yield number + " => " + letter
  println(newList)

  def plusOneOrZero(number: Int) = {
    if (number < 0) 0
    else number + 1
  }
  println(plusOneOrZero(-1))
  println(plusOneOrZero(99))

  //Anonymous function
  val product = (a: Int, b: Int) => a * b
  product(2,10)


  case class Fruit(name: String)


  val apple = Fruit("apple")
  val orange = Fruit("orange")
  val kiwi = Fruit("kiwi")

  println(apple)

  val fruitBasket = List(apple, orange, kiwi,orange, kiwi, kiwi, apple, orange)
  val listOfApple:List[Fruit] = fruitBasket.filter((fruit: Fruit) => fruit.name == "apple")
  val listOfApple_v2:List[Fruit] = fruitBasket.filter(fruit => fruit.name == "apple")
  val listOfApple_v3:List[Fruit] = fruitBasket.filter(_.name == "apple") //if var only used one right side
  listOfApple.foreach(println)

  def main(args: Array[String]): Unit = {
    print(anIfExpression)
    print(codeBlock)
  }

}
