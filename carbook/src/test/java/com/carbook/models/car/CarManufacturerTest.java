package com.carbook.models.car;

import com.carbook.repositories.car.CarManufacturerRepository;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CarManufacturerTest extends TestCase {

    @Autowired
    private CarManufacturerRepository carManufacturerRepository;

    @Test
    public void testGetAll() {
        CarManufacturer cm1 = new CarManufacturer();
        cm1.setName("Fiat");
        cm1.setCode("FIAT");
        carManufacturerRepository.save(cm1);

        CarManufacturer cm2 = new CarManufacturer();
        cm2.setName("Bmw");
        cm2.setCode("BMW");
        carManufacturerRepository.save(cm2);

        List<CarManufacturer> carManufacturers = (List<CarManufacturer>) carManufacturerRepository.findAll();
        assertTrue("more than one", carManufacturers.size() > 1);
    }

    @Test
    public void testGetOne(){
        CarManufacturer carManufacturer = new CarManufacturer();
        carManufacturer.setName("Ford");
        carManufacturer.setCode("FORD");
        carManufacturerRepository.save(carManufacturer);

        CarManufacturer carManufacturerFromM2 = carManufacturerRepository.findById(3).get();
        assertNotNull(carManufacturerFromM2.getId());
    }
}