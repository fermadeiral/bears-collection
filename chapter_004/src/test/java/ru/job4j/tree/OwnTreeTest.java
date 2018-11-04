package ru.job4j.tree;

import org.junit.Test;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class ownTreeTest | Task Solution: Make simple tree structure [#1711]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 07.10.2018
 */
public class OwnTreeTest {
    @Test
    public void when6ElFindLastThen6() {
        OwnTree<Integer> tree = new OwnTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        OwnTree<Integer> tree = new OwnTree<>(1);
        tree.add(1, 2);
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void iteratorTest() {
        OwnTree<Integer> tree = new OwnTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        Iterator<Integer> it = tree.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenTwoChildElementsInEachNodeThenTreeIsBinary() {
        OwnTree<Integer> tree = new OwnTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(3, 5);
        tree.add(3, 6);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenThreeChildElementsInNodeThenTreeIsNotBinary() {
        OwnTree<Integer> tree = new OwnTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 5);
        assertThat(tree.isBinary(), is(false));
    }
}