package domain;

public interface SearchCriteria<T> {

    boolean test(T element);
}
