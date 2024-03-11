package repository;

import config.DatabaseConnection;
import mapping.dtos.ToyDto;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ToyStoreRepository implements ToysRepository<Toy> {
    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getInstance();
    }
    private Toy createToy(ResultSet resultSet) throws SQLException {
        Toy toy = new Toy();
        toy.setId(resultSet.getInt("id"));
        toy.setName(resultSet.getString("name"));
        toy.setType(new TypeToy(
                resultSet.getInt("id_type"),
                resultSet.getString("type_name")
        ));
        toy.setAmount(resultSet.getInt("amount"));
        toy.setPrice_unit(resultSet.getInt("price_unit"));
        toy.setPrice_total(resultSet.getInt("price_total"));

        return toy;
    }

    @Override
    public void save(Toy toy) {

    }

    @Override
    public List<Toy> listToys() {
        List<Toy> toyList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("""
            SELECT t.*, t.id as toy_id, t.name as toy_name, t.price_unit as toy_price,
                   tToys.id as type_id, tToys.type as Type_name
            FROM toys AS t 
            INNER JOIN type_toys AS tToys ON t.id_type = tToys.id;
            """)) {
            while (resultSet.next()) {
                Toy toy = createToy(resultSet);
                toyList.add(toy);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toyList;
    }

    @Override
    public Integer totalToys() throws Exception {
        Integer count = 0;
        for(Toy toy : listToys()){
            count += toy.getAmount();
        }
        return count;
    }

    @Override
    public void delete(int id) {
        try(PreparedStatement preparedStatement = getConnection()
                .prepareStatement("""
                                      DELETE FROM toys where id=?
                                      """)
        ){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
