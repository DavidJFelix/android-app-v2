package co.instameals.dinnersolutions.api.v2.utils;

import java.util.UUID;

public class Relation<T> {
    // FIXME: make this optional; create a JSON parser for it
    public T relatedObject;
    private final UUID relationId;

    public Relation(UUID relationId) {
        this.relationId = relationId;
    }
}
