class Node {
    constructor(value = null, parent = null, children = []) {
      this.value = value;
      this.children = children;
    }
  }
  
  Node.prototype.traverseBFS = function() {
    const traverse = [];
    const queue = [this];
    while (queue.length !== 0) {
      const item = queue.shift();
      traverse.push(item.value);
      if (Array.isArray(item.children)) {
        item.children.forEach(_item => queue.push(_item));
      }
    }
    return traverse;
  };
  
  Node.prototype.traverseDFS = function() {
    let traverse = [];
    traverse.push(this.value);
    if (Array.isArray(this.children)) {
      this.children.forEach(_item => {
        traverse = [...traverse, ..._item.traverseDFS()];
      });
    }
    return traverse;
  };
  
  class Tree {
    constructor(value) {
      this.root = new Node(value);
    }
  }
  
  Tree.prototype.traverseBFS = function() {
    return this.root.traverseBFS();
  };
  
  Tree.prototype.traverseDFS = function() {
    return this.root.traverseDFS();
  };
  
  const tree1 = new Tree("root node");
  
  tree1.root.children.length = 3;
  tree1.root.children[0] = new Node("L1-0");
  tree1.root.children[1] = new Node("L1-1");
  tree1.root.children[2] = new Node("L1-2");
  
  tree1.root.children[0].children.length = 3;
  tree1.root.children[0].children[0] = new Node("L2-0-0");
  tree1.root.children[0].children[1] = new Node("L2-0-1");
  tree1.root.children[0].children[2] = new Node("L2-0-2");
  
  tree1.root.children[1].children.length = 3;
  tree1.root.children[1].children[0] = new Node("L2-1-0");
  tree1.root.children[1].children[1] = new Node("L2-1-1");
  tree1.root.children[1].children[2] = new Node("L2-1-2");
  
  tree1.root.children[2].children.length = 3;
  tree1.root.children[2].children[0] = new Node("L2-2-0");
  tree1.root.children[2].children[1] = new Node("L2-2-1");
  tree1.root.children[2].children[2] = new Node("L2-2-2");
  
  console.log(tree1.traverseBFS());
  
  console.log(tree1.traverseDFS());