package ru.job4j.set;

import org.junit.Test;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Class SimpleSetTest | Task Solution: Implement Set based on array [#996]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 11.08.2018
 */
public class SimpleSetTest {

    SimpleSet<Integer> set = new SimpleSet<>();

    @Test
    public void whenAddTwoSameIntegerValuesThenOnlyOneValueAdds() {
        set.add(15);
        set.add(15);
        Iterator iterator = set.iterator();
        assertThat(iterator.next(), is(15));
        assertThat(iterator.hasNext(), is(false));
    }
}