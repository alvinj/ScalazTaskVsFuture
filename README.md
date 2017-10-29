# scalaz Task vs Scala Future

I created this repository to make it easy for people
to compare the scalaz Task and Scala Future. All I did was
add the necessary scalaz include statements to the *build.sbt* file,
and create `App`s from the original source code.

All credit for the code goes to [tpolecat](https://twitter.com/tpolecat), 
who created the original source code at this URL:

- https://www.reddit.com/r/scala/comments/3zofjl/why_is_future_totally_unusable/


## About the code

The *v1* directory contains tpolecat’s original source code, which
I created as Scala `App`s.

The *v2* directory contains slightly modified versions of those apps,
which calls the instances more than one time to see what the
behaviors are.


Alvin Alexander    
https://alvinalexander.com
