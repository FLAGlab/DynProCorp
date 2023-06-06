open class Node(private val id : Int, private val neighbors: List<Node>) {
    open fun handle(info : Information) {
        if(info.destination == this.id) {
            println("Generic process information at ${this.id}")
        } else {
            this.send(info)
        }
    }

    open fun send(info: Information) {
        neighbors.map { it.handle(info) }
    }

}