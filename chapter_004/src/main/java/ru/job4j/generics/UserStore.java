package ru.job4j.generics;

/**
 * Class UserStore | Task Solution: Implement Store<T extends Base> [#157]
 * @author Aleksey Sidorenko (mailto:sidorenko.aleksey@gmail.com)
 * @since 27.07.2018
 */
class UserStore extends AbstractStore<User> {

    /**
     * Constructor.
     */
    public UserStore(int size) {
        super(size);
    }
}