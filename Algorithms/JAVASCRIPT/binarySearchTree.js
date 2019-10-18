class BinaryTreeNode {
    constructor(value = null, left = null, right = null, parent = null) {
      this.left = left;
      this.right = right;
      this.value = value;
      this.parent = parent;
    }
  }
  
  BinaryTreeNode.prototype.setValue = function(value) {
    this.value = value;
  };
  
  BinaryTreeNode.prototype.setLeft = function(node) {
    if (this.left) this.left = null;
    this.left = node;
    if (this.left) this.left.parent = this;
  };
  
  BinaryTreeNode.prototype.setRight = function(node) {
    if (this.right) this.right = null;
    this.right = node;
    if (this.right) this.right.parent = this;
  };
  
  BinaryTreeNode.prototype.removeChild = function(node) {
    if (this.left === node) {
      this.left = null;
      return true;
    }
    if (this.right === node) {
      this.right = null;
      return true;
    }
    return false;
  };
  
  BinaryTreeNode.prototype.traverseInorder = function() {
    let traverse = [];
    if (this.left) traverse = [...traverse, ...this.left.traverseInorder()];
    traverse.push(this.value);
    if (this.right) traverse = [...traverse, ...this.right.traverseInorder()];
    return traverse;
  };
  
  BinaryTreeNode.prototype.traversePostorder = function() {
    let traverse = [];
    if (this.left) traverse = [...traverse, ...this.left.traversePostorder()];
    if (this.right) traverse = [...traverse, ...this.right.traversePostorder()];
    traverse.push(this.value);
    return traverse;
  };
  
  BinaryTreeNode.prototype.traversePreorder = function() {
    let traverse = [];
    traverse.push(this.value);
    if (this.left) traverse = [...traverse, ...this.left.traversePreorder()];
    if (this.right) traverse = [...traverse, ...this.right.traversePreorder()];
    return traverse;
  };
  
  BinaryTreeNode.prototype.traverseLevelorder = function() {
    const traversed = [];
    const queue = [this];
    while (queue.length !== 0) {
      const current = queue.shift();
      if (current.left) {
        queue.push(current.left);
      }
      if (current.right) {
        queue.push(current.right);
      }
      traversed.push(current.value);
    }
    return traversed;
  };
  
  class BinarySearchTreeNode extends BinaryTreeNode {
    constructor(value) {
      super(value);
    }
  }
  
  BinarySearchTreeNode.prototype.insert = function(value) {
    if (!this.value) {
      this.value = value;
      return this;
    }
  
    if (value <= this.value) {
      if (this.left) return this.left.insert(value);
      const newNode = new BinarySearchTreeNode(value);
      this.setLeft(newNode);
      return newNode;
    }
  
    if (value > this.value) {
      if (this.right) return this.right.insert(value);
      const newNode = new BinarySearchTreeNode(value);
      this.setRight(newNode);
      return newNode;
    }
    return this;
  };
  
  BinarySearchTreeNode.prototype.find = function(value) {
    if (this.value === value) {
      return this;
    }
    if (value < this.value && this.left) {
      return this.left.find(value);
    }
    if (value > this.value && this.right) {
      return this.right.find(value);
    }
    return null;
  };
  
  BinarySearchTreeNode.prototype.remove = function(value) {
    const nodeToRemove = this.find(value);
    if (!nodeToRemove) {
      throw new Error("Node not found");
    }
    const { parent = null, left, right } = nodeToRemove;
    if (!left && !right) {
      if (parent) parent.removeChild(nodeToRemove);
      nodeToRemove.setValue(null);
    } else if (left && right) {
      const inorderSuccessor = right.findMin();
      const inorderSuccessorValue = inorderSuccessor.value;
      if (inorderSuccessor === right) {
        nodeToRemove.setValue(inorderSuccessorValue);
        nodeToRemove.setRight(inorderSuccessor.right);
      } else {
        this.remove(inorderSuccessorValue);
        nodeToRemove.setValue(inorderSuccessorValue);
      }
      inorderSuccessor.parent = null;
    } else {
      let childNode = left || right;
      if (parent) {
        childNode.parent = parent;
        if (parent.left === nodeToRemove) {
          parent.left = childNode;
        } else if (parent.right === nodeToRemove) {
          parent.right = childNode;
        }
      } else {
        this.setLeft(childNode.left);
        this.setRight(childNode.right);
        this.setValue(childNode.value);
        childNode = null;
      }
    }
  };
  
  BinarySearchTreeNode.prototype.findMin = function() {
    if (!this.left) {
      return this;
    }
    return this.left.findMin();
  };
  
  const getCircularReplacer = () => {
    const seen = new WeakSet();
    return (key, value) => {
      if (typeof value === "object" && value !== null) {
        if (seen.has(value)) {
          return;
        }
        seen.add(value);
      }
      return value;
    };
  };
  
  class BinarySearchTree {
    constructor() {
      this.root = new BinarySearchTreeNode();
    }
  }
  
  BinarySearchTree.prototype.insert = function(value) {
    this.root.insert(value);
  };
  
  BinarySearchTree.prototype.find = function(value) {
    return this.root.find(value);
  };
  
  BinarySearchTree.prototype.remove = function(value) {
    return this.root.remove(value);
  };
  
  BinarySearchTree.prototype.traversePreorder = function() {
    return this.root.traversePreorder();
  };
  
  BinarySearchTree.prototype.traverseInorder = function() {
    return this.root.traverseInorder();
  };
  
  BinarySearchTree.prototype.traversePostorder = function() {
    return this.root.traversePostorder();
  };
  
  BinarySearchTree.prototype.traverseLevelorder = function() {
    return this.root.traverseLevelorder();
  };
  
  const bst = new BinarySearchTree();
  
  bst.insert(20);
  bst.insert(16);
  bst.insert(12);
  bst.insert(22);
  bst.insert(14);
  bst.insert(21);
  bst.insert(23);
  bst.insert(11);
  bst.insert(13);
  
  const minimum = bst.root.findMin();
  console.log("Minimum value => ", minimum && minimum.value);
  console.log(JSON.stringify(bst, getCircularReplacer(), 4));
  
  const preorder = bst.traversePreorder();
  console.log("Preorder => ", preorder);
  const postorder = bst.traversePostorder();
  console.log("Postorder => ", postorder);
  const inorder = bst.traverseInorder();
  console.log("Inorder", inorder);
  const levetorder = bst.traverseLevelorder();
  console.log("TraverseLevelorder", levetorder);
  
  const node = bst.find(14);
  console.log(node ? "Node Exist" : "Node doesn't exist");
  
  // bst.remove(20)
  // console.log(JSON.stringify(bst, getCircularReplacer(),4))