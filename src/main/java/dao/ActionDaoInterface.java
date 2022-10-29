package dao;

import java.util.List;

public interface ActionDaoInterface<A> {
    A save (A a);

    List<A> findAllActions();
}
