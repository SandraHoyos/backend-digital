package dao;
//interfaz que define los metodos comunes a las implementaciones
public interface iDao<T> {
    T guardar(T t);
    T buscar(T  t);
}
