class Printer(private val id : Int, private val neighbors: List<Node>) : Node(id, neighbors) {
    override fun handle(info: Information) {
        if(info.destination == this.id) {
            print("Data processed by the ${this.id} node + ")
            println("just printing:  ${info.data}")
        } else {
            this.send(info)
        }
    }
}