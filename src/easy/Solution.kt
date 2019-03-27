package easy

class Solution {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
//            println("Hello World")
//
//            val string = "RUSlAN"
//             var count = myWith(string){
//                 this.count()
//            }
//            println(count)
//            println(string)
//            print(string.hasVovels())
            var answer = "Test. ,replace"
            var ans = "+77"
            println(answer)
            answer = answer.replace("[^A-Za-z0-9 ]", "")
            println(answer)
            val re = Regex("[^A-Za-z0-9 ]")
            var re2 = Regex("[^6-7]{1}")
            answer = re.replace(answer, "")
            println(answer)

        }

        fun pascalTriangle(rows: Int) {
            var c = 1
            for (i in 0 until rows) {
                var bol = true
                for (j in 0 until i) {
                    if (j == 0 || i == 0) {
                        c = 1
                        if (i > 0)
                            print("1.")
                        else print(c)
                    } else {
                        c = c * (i - j + 1) / j
                        print(c.toString() + ".")

                    }
                }
                print("1")
                println()
            }
        }
    }

    fun bubbleSort(inputList: List<String>): IntArray {
        return inputList
                .map { it.toInt() }
                .sorted()
                .toIntArray()
    }


}

fun String.hasVovels(): Boolean {
    return contains("a")
}

fun myWith(name: String, block: String.() -> Int) {
    name.block()
}

class MyList<T> {
    fun get(pos: Int): T {
        TODO("implement")
    }

    fun addItem(item: T) {

    }
}

fun workWithMyList() {
    val intList: MyList<String>
}