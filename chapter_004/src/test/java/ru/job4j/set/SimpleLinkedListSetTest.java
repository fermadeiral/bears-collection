package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleLinkedListSetTest | Task Solution: Implement Set based on LinkedList [#997]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 11.08.2018
 */
public class SimpleLinkedListSetTest {

    SimpleLinkedListSet<Integer> set = new SimpleLinkedListSet();

    @Test
    public void whenAddTwoSameIntegerValuesThenOnlyOneValueAdds() {
        set.add(12);
        set.add(12);
        Iterator iterator = set.iterator();
        assertThat(iterator.next(), is(12));
        assertThat(iterator.hasNext(), is(false));
    }
}