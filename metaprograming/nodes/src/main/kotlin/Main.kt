fun main(args: Array<String>) {
    val nodes : MutableList<Node>
    nodes = mutableListOf<Node>()
    nodes.add(Node(0, emptyList<Node>()))
    for(i in 1..6) {
        val n = when((1..3).random()) {
            1 -> Computer(i, listOf(nodes[i-1]))
            2 -> Printer(i, listOf(nodes[i-1]))
            else -> Node(i, listOf(nodes[i-1]))
        }
        nodes.add(n)
    }

    val info = Information(3, "data to process as a string")
    val info2 = Information(6, "Text for the printer")
    nodes.last().handle(info)
    nodes.last().handle(info2)

    for(node in nodes) {
        val c = node::class
        println(c.qualifiedName)
        println(c.supertypes)
    }
}