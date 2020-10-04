package Harman

class KotlinFactory {
    fun transpose(input: String?, type: String): String? {
        if (input.isNullOrEmpty())
            return null

        val factory = Factory()
        val operation = factory.getOperation(type)
        return operation.operation(input)
    }
}