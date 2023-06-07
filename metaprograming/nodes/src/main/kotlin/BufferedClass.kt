class BufferedClass(private val id: Int, private val neighbors: List<Node>) {
    private val buffer = arrayOfNulls<Information>(10)
    private var last = 0

    open fun handle(info : Information) {
        if((0..2).random() > 0) {
            buffer[last] = info
            last++
        } else
            send(info)
    }

    open fun send(info: Information) {
        val first = buffer[0]
        for(i in 0 until last)
            buffer[i] = buffer[i+1]
        buffer[last] = null
        neighbors.map {
            if (first != null) {
                it.handle(first)
            }
        }
    }
}