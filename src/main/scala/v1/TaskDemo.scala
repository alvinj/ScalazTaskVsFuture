package v1

import scalaz.concurrent.Task
import scala.util.Random

// from tpolecat at https://www.reddit.com/r/scala/comments/3zofjl/why_is_future_totally_unusable/
object TaskDemo extends App {

    val task1 = {
        val r = new Random(0L)
        val x = Task.delay(r.nextInt)
        for {
            a <- x
            b <- x
        } yield (a, b)
    }

    // same as task1, but x is inlined
    val task2 = {
        val r = new Random(0L)
        for {
            a <- Task.delay(r.nextInt)
            b <- Task.delay(r.nextInt)
        } yield (a, b)
    }

    // `run` is deprecated, use `unsafePerformSync`
    println(task1.unsafePerformSync) // (-1155484576,-723955400)

    // when you inline `x` you get the same result as `task1`,
    // this fits the RT definition.
    println(task2.unsafePerformSync) // (-1155484576,-723955400)

}

