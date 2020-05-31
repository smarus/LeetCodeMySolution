package aquarium

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main() {
//    (1..10000).forEach {
//        GlobalScope.launch {
//            val threadName = Thread.currentThread().name
//            println("$it printed on thread ${threadName}")
//        }
//    }
//    Thread.sleep(1000)

//    with(GlobalScope) {
//        val parentJob = launch {
//            delay(200)
//            println("I’m the parent")
//            delay(200)
//        }
//        launch(context = parentJob) {
//            delay(200)
//            println("I’m a child")
//            delay(200)
//        }
//        if (parentJob.children.iterator().hasNext()) {
//            println("The Job has children ${parentJob.children}")
//        } else {
//            println("The Job has NO children")
//        }
//        Thread.sleep(1000)
//    }

//    var isDoorOpen = false
//    println("Unlocking the door... please wait.\n")
//    GlobalScope.launch {
//        delay(3000)
//        isDoorOpen = true
//    }
//    GlobalScope.launch {
//        repeat(4) {
//            println("Trying to open the door...\n")
//            delay(800)
//            if (isDoorOpen) {
//                println("Opened the door!\n")
//            } else {
//                println("The door is still locked\n")
//            }
//        } }
//    Thread.sleep(5000)


    println("User hey")
    GlobalScope.launch {
        val user = getUser("101")
        println(user)
        println("user finish")
    }
    println("User stop")
    Thread.sleep(1500)
}

suspend fun getUser(userId: String): String {
    Thread.sleep(1000)
    return "dfsdfsd"
}