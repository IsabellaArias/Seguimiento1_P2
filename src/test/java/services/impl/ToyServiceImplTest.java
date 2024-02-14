package services.impl;
import mapping.dtos.ToyDto;
import mapping.mapper.ToyMapper;
import model.Toy;
import model.TypeToy;
import org.junit.jupiter.api.*;
import utilis.Constants;
import utilis.FileUtilis;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ToyServiceImplTest {

    private ToyServiceImpl service;

    @Test
    public void addTest() throws Exception {
        service = new ToyServiceImpl();
        File file = new File(Constants.PATH_TOYS);
        List<Toy> expected = new ArrayList<>();
        if (file.exists()) {
            expected = FileUtilis.getToys(file);
        }
        ToyDto newToy =  new ToyDto("ab89cd", TypeToy.FEMALE,23,10);

        assertEquals(expected.size(),service.listToys().size());

    //    expected.add(ToyMapper.mapFrom(newToy));

        List<ToyDto> result = service.addToy(newToy);
   //     assertEquals(expected.size(),service.listToys().size());
  //      service.deleteToy(newToy.name());

    }


    @Test
    public void listTest(){
        service = new ToyServiceImpl();
        ToyDto toy1 =  new ToyDto("test", TypeToy.FEMALE,23,10);
        List<ToyDto> expect = List.of(toy1);
        List<ToyDto> result = service.listToys();
        assertEquals(expect.size(),result.size());
    }

}