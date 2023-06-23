const cop = require("./context-traits.js");

var TNode = {
	neighbors: {},
	id: "",
	defId: function(id) {
		this.id = id;
	},
	addNeighbor: function(node) {
		this.neighbors = node;
	},
	handle: function(info) {
		console.log("node handle");
		this.process(info);
	},
	process: function(info) {
		this.neighbors.handle(info);
	},
};

const TComputer = {
	process: function(info) {
		console.log(`Computation in progress for ${info}`);
	}
}
TComputer.__proto__ = TNode; 

const TPrinter = {
	processs: function(info) {
		console.log(`Printing ${info}`);
	}
}
TPrinter.__proto__ = TNode;

TNewNode = {
	twoNeighbors: {},
	newId: "",
	defNewId: function(id) {
		this.id = id;
	},
	newAddNeighbor: function(node) {
		this.neighbors = node;
	},
	newHandle: function(info) {
		console.log("node handle");
		this.process(info);
	},
	newProcess: function(info) {
		this.neighbors.handle(info);
	},
}

const NewNode = new cop.Context();
const NewnodeBehavior = cop.Trait({ 
	neighbors: [1],
	id: "new",
	defId: function(id) {
		this.id = id;
	},
	addNeighbor: function(node) {
		this.neighbors = node;
	},
	handle: function(info) {
		console.log("New handle handle");
		this.process(info);
	},
	process: function(info) {
		this.neighbors.handle(info);
	}
});
NewNode.adapt(TNode, NewnodeBehavior);

empty = {};
const NewNode2 = new cop.Context();
const NewnodeBehavior2 = cop.Trait({ 
	replace: function() {
		TNode = TNewNode;
	}
});
NewNode2.adapt(empty, NewnodeBehavior2);

var node = Object.create(TNode);
console.log(node);
console.log(node.neighbors);
//NewNode.activate();
NewNode2.activate();
empty.replace();
var node2 = Object.create(TNode);
console.log(node2.twoNeighbors);
NewNode2.deactivate();
console.log(empty);

/*
const TBuffer = { 
	buffer: [],
	handle: function(info) {
		if(Math.random() < 0.6)
			this.buffer.push(info);
		else
			$super(info);
	},
	process: function(info) {
		data = this.buffer.shfit();
		proceed(data);
	}
}

const Buffer = new cop.Context();
const CongestionBehavior = cop.Trait({ 
});


	handle: function(info) {
		console.log(`ignore message ${info}`);
	}
});	
Buffer.adapt(TNode, CongestionBehavior);


*/
