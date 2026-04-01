package main.generics;

import java.util.HashSet;
import java.util.Set;

public class Squad<T> {
    private final Set<T> members = new HashSet<>();

    public void addMember(T member) {
        members.add(member);
    }

    public Set<T> getMembers() {
        return members;
    }
}
