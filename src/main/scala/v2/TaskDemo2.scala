package v2

import scalaz.concurrent.Task
import scala.util.Random

// from tpolecat at https://www.reddit.com/r/scala/comments/3zofjl/why_is_future_totally_unusable/
object TaskDemo2 extends App {

    val task1: Task[(Int, Int)] = {
        val r = new Random(0L)
        val x = Task.delay(r.nextInt)
        for {
            a <- x
            b <- x
        } yield (a, b)
    }

    // same as task1, but x is inlined
    val task2: Task[(Int, Int)] = {
        val r = new Random(0L)
        for {
            a <- Task.delay(r.nextInt)
            b <- Task.delay(r.nextInt)
        } yield (a, b)
    }

    println(task1.unsafePerformSync)  //(-1155484576,-723955400)

    // when you inline `x` you get the same result as `task1`,
    // this fits the RT definition.
    println(task2.unsafePerformSync)  //(-1155484576,-723955400)

    // if you call task1.unsafePerformSync again, you get a different result.
    // this makes it seem like an impure function call.
    println(task1.unsafePerformSync)  //(1033096058,-1690734402)
    println(task1.unsafePerformSync)  //(-1557280266,1327362106)

}

