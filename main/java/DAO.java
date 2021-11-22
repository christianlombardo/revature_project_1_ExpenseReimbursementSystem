import java.util.List;

public interface DAO<T> {

    void insert(T obj);

    T readById(int id);

    List<T> readAll();

    void update(T obj);

    void delete(T obj);


}
