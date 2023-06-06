class Computer(private val id : Int, private val neighbors: List<Node>) : Node(id, neighbors) {
    override fun handle(info: Information) {
        if(info.destination == this.id) {
            val data = info.data.replace(" ", "").uppercase()
            print("Data processed by the ${this.id} node - ")
            println("The processed data is:  $data")
        } else {
            this.send(info)
        }
    }
}