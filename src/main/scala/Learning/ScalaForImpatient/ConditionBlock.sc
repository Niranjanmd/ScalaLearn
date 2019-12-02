println("Welcome to test")

val x = 10
val y = 20

print(x>y )



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