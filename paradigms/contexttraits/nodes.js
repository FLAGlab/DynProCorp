const cop = require("./context-traits.js");

const TNode = {
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

const Buffer = new cop.Context();
const BufferBehavior = cop.Trait({ 
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
});
Buffer.adapt(TNode, BufferBehavior);
Buffer.adapt(TComputer, BufferBehavior);



const Congestion = new cop.Context();
const CongestionBehavior = cop.Trait({ 
	handle: function(info) {
		console.log(`ignore message ${info}`);
	}
});	
Congestion.adapt(TNode, CongestionBehavior);

const root = Object.create(TNode);
root.defId("root");
let nodes = [root];
for(let i=1; i<10; i++) {
	let r = getRandomInt(1, 3);
	let n;
	switch (r) {
		case 0: n = Object.create(TNode);	break;
		case 1: n = Object.create(TComputer); break;
		case 2: n = Object.create(TPrinter); 
	}
	n.defId(i);
	nodes[i-1].addNeighbor(n);
	nodes.push(n);
	
}

let counter;
for(let i=1;i<=100; i++) {
	console.log(`--- ITERATION ${i} ---`)
	let send = Math.random();
	if(send <= 0.2) {
		Buffer.deactivate();
		Congestion.activate();
	} else if (0.2 < send <= 0.5) {
		Congestion.deactivate();
		Buffer.activate();
	}
	
	nodes[0].handle(`message ${i}`);
}

function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min) + min); // The maximum is exclusive and the minimum is inclusive
}