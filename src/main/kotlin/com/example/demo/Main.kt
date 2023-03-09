

data class Node<T>(var value: T, var next: Node<T>? = null) {

    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }

}

class LinkedList<T> {

    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0

    init {
        println("linkedList Constructed")
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun push(value: T) {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    fun append(value: T) {

        if (isEmpty()) {
            push(value)
            return
        }

        tail?.next = Node(value = value)
        tail = tail?.next
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode: Node<T>? = head
        var currentIndex = 0

        while (currentIndex != null && currentIndex < index) {
            currentNode = currentNode?.next
            currentIndex++
        }

        return currentNode
    }


}


fun main() {

    val list = LinkedList<Int>()
    list.append(1)
    list.append(2)
    list.append(3)
    println(list.head.toString())
}


