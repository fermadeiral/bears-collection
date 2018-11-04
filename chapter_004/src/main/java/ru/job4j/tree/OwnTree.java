package ru.job4j.tree;

import java.util.*;

/**
 * Class ownTree | Task Solution: Make simple tree structure [#1711]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 07.10.2018
 */
public class OwnTree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;
    private int modCount;

    /**
     * Constructor.
     */
    OwnTree(E value) {
        root = new Node<>(value);
    }

    /**
     * Check tree for binary.
     * @return true if tree is binary
     */
    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        for (Node<E> element : data) {
            if (element.leaves().size() > 2) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Add child element in parent.
     * @param parent parent.
     * @param child child.
     * @return true if child element adds.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> parentNode = findBy(parent);
        if (parent != null && parentNode.isPresent()) {
            parentNode.get().add(new Node<>(child));
            modCount++;
            result = true;
        }
        return result;
    }

    /**
     * Find Node in tree by it's value.
     * @param value value.
     * @return Node
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.eqValue(value)) {
                result = Optional.of(element);
                break;
            }
            for (Node<E> child : element.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Queue<Node<E>> elements = new LinkedList<>();
            int expectedModCount = modCount;
            {
                elements.offer(root);
            }

            @Override
            public boolean hasNext() {
                return !elements.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                Node<E> result = elements.poll();
                for (Node<E> element : result.leaves()) {
                    elements.offer(element);
                }
                return result.getValue();
            }
        };
    }
}