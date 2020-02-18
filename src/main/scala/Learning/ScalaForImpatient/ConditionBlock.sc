println("Welcome to test")

val x = 10
val y = 20

print(x>y )

val str = "/a/n/b/d/e/d"

println(str.substring(1))

println(str.substring(1).split("/").toList)



println("hello")


val data = 1 to 10

println(data)

for(i<-0 to data.length)
  println(i)

data.foreach(x=>print(x +","))

for(i<-1 to 3 ; j<-1 to 3)
  println((10 * i + j))


val res = for(i<-1 to 10 ) yield  i%2

res.foreach(x=>println(x))