package ru.job4j.tree;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Queue;

/**
 * Tree.
 * @param <E> - type of items stored in the tree.
 * @author Ivan Belyaev
 * @since 11.11.2018
 * @version 1.0
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /** Tree root. */
    private Node<E> root;
    /** The number of times this Tree has been structurally modified. */
    private int modCount = 0;

    /**
     * The constructor creates the object Tree.
     * @param value - value at the root.
     */
    public Tree(E value) {
        root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> node = findBy(parent);
        if (node.isPresent()) {
            node.get().add(new Node<>(child));
            modCount++;
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * The method checks if the tree is binary.
     * @return true if the tree is binary otherwise returns false.
     */
    public boolean isBinary() {
        return isBinaryTree(root);
    }

    /**
     * The method checks if the subtree is binary.
     * @param treeRoot - subtree root.
     * @return true if the subtree is binary otherwise returns false.
     */
    private boolean isBinaryTree(Node<E> treeRoot) {
        boolean result = true;
        int leavesSize = treeRoot.leaves().size();
        if (leavesSize == 0) {
            result = true;
        } else if (leavesSize > 2) {
            result = false;
        } else {
            for (int index = 0; index < leavesSize; index++) {
                if (!isBinaryTree(treeRoot.leaves().get(index))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Queue<Node<E>> list = new LinkedList<>();
            private int expectedModCount = modCount;

            {
                list.offer(root);
            }

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public E next() {
                if (list.isEmpty()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                Node<E> curNode = list.poll();
                for (Node<E> child : curNode.leaves()) {
                    list.offer(child);
                }
                return curNode.getValue();
            }
        };
    }
}