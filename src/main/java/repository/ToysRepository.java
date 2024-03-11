package repository;

import mapping.dtos.ToyDto;
import model.Toy;
import model.TypeToy;

import java.util.List;
import java.util.Map;

public interface ToysRepository<T>{
    void save(Toy toy);

    List<Toy> listToys();
    Integer totalToys() throws Exception;
    void delete(int id);
}
