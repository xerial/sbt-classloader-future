package sample

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.ExecutionContext
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}


case class A(id:Int)

object FutureSample {
  def main(args:Array[String]): Unit = {
     // OK
     val cl = Thread.currentThread.getContextClassLoader.loadClass("sample.A")
     println(cl.getName)      

     val f = Future {
        // Fails other than setting ClassLoaderLayeringStorategy.Flat or fork in run = true
	val cl = Thread.currentThread.getContextClassLoader.loadClass("sample.A")
	println(cl.getName)
     }
     Await.result(f, Duration.Inf)
  }
}
