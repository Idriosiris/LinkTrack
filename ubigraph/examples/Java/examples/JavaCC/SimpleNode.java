/* Generated By:JJTree: Do not edit this line. SimpleNode.java */

import org.ubiety.ubigraph.UbigraphClient;

public class SimpleNode implements Node {
  protected Node parent;
  protected Node[] children;
  protected int id;
  protected JavaParser parser;

  protected static UbigraphClient graph;

  static {
    graph = new UbigraphClient();
    graph.clear();
  }

  public SimpleNode(int i) {
    id = i;
    graph.newVertex(hashCode());
    refreshLabel();
  }

  public SimpleNode(JavaParser p, int i) {
    this(i);
    parser = p;
    graph.newVertex(hashCode());
  }

  public void refreshLabel()
  {
    graph.setVertexAttribute(hashCode(), "label", this.toString());
  }

  protected void finalize()
  {
    graph.removeVertex(hashCode());
  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }
  
  public void jjtSetParent(Node n) { parent = n; }
  public Node jjtGetParent() { return parent; }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;

    graph.newEdge(hashCode(), n.hashCode());
  }

  public Node jjtGetChild(int i) {
    return children[i];
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */

  public String toString() { return JavaParserTreeConstants.jjtNodeName[id]; }
  public String toString(String prefix) { return prefix + toString(); }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
	SimpleNode n = (SimpleNode)children[i];
	if (n != null) {
	  n.dump(prefix + " ");
	}
      }
    }
  }
}

