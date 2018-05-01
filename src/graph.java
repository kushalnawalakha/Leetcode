/**
 * Created by kusha on 4/7/2018.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class graph {
}


class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Heading> headings = new ArrayList<>();
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            if (line.equals(""))
                break;
            headings.add(parse(line));
        }
        Node outline = toOutline(headings);
        String html = toHtml(outline);
        System.out.println(html);
    }

    private static Node toOutline(List<Heading> headings) {
        // Implement this function. Sample code below builds an
        // outline of only the first heading.
        Node root = new Node(new Heading(0, ""));
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        for (Heading heading : headings) {
            while (stack.peek().heading.weight >= heading.weight) {
                stack.pop();
            }
            Node currentNode = new Node(heading);
            stack.peek().children.add(currentNode);
            stack.push(currentNode);
        }
        return root;
    }

    /**
     * Parses a line of input.
     * This implementation is correct for all predefined test cases.
     */
    private static Heading parse(String record) {
        String[] parts = record.split(" ", 2);
        int weight = Integer.parseInt(parts[0].substring(1));
        Heading heading = new Heading(weight, parts[1].trim());
        return heading;
    }

    /**
     * Converts a node to HTML.
     * This implementation is correct for all predefined test cases.
     */
    private static String toHtml(Node node) {
        StringBuilder buf = new StringBuilder();
        if (!node.heading.text.isEmpty()) {
            buf.append(node.heading.text);
            buf.append("\n");
        }
        Iterator<Node> iter = node.children.iterator();
        if (iter.hasNext()) {
            buf.append("<ol>");

            while (iter.hasNext()) {
                Node child = iter.next();
                buf.append("<li>");
                buf.append(toHtml(child));
                buf.append("</li>");
                if (iter.hasNext()) {
                    buf.append("\n");
                }
            }
            buf.append("</ol>");
        }
        return buf.toString();
    }

    public static class Heading {
        protected int weight;
        protected String text;

        public Heading(int weight, String text) {
            this.weight = weight;
            this.text = text;
        }
    }

    public static class Node {
        protected Heading heading;
        protected List<Node> children;

        public Node(Heading heading) {
            this.heading = heading;
            this.children = new ArrayList<>();
        }
    }
}
