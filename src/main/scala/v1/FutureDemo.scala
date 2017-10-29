package v1

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random

object FutureDemo extends App {

    val f1 = {
        val r = new Random(0L)
        val x = Future(r.nextInt)
        for {
            a <- x
            b <- x
        } yield (a, b)
    }

    // Same as f1, but I inlined `x`
    val f2 = {
        val r = new Random(0L)
        for {
            a <- Future(r.nextInt)
            b <- Future(r.nextInt)
        } yield (a, b)
    }

    f1.onComplete(println)  //Success((-1155484576,-1155484576))

    // when you inline `x` you get a different result. this violates the
    // definition of RT.
    f2.onComplete(println)  //Success((-1155484576,-723955400))  <-- not the same

}





