package com.carbook.models.car;

import com.carbook.repositories.car.CarManufacturerRepository;
import com.carbook.repositories.car.CarModelRepository;
import com.carbook.repositories.car.CarProfileRepository;
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
public class CarProfileTest extends TestCase {

    @Autowired
    private CarProfileRepository carProfileRepository;

    @Test
    public void testGetAll() {
        CarProfile cp1 = new CarProfile();
        cp1.setYearOfProduction(2000);
        cp1.setCcm(1200);
        cp1.setHp(80);
        carProfileRepository.save(cp1);

        CarProfile cp2 = new CarProfile();
        cp2.setYearOfProduction(2004);
        cp2.setCcm(2000);
        cp2.setHp(150);
        carProfileRepository.save(cp2);

        List<CarProfile> carProfiles = (List<CarProfile>) carProfileRepository.findAll();
        assertTrue("more than one", carProfiles.size() > 1);
    }

    @Test
    public void testGetOne(){
        CarProfile carProfile = new CarProfile();
        carProfile.setYearOfProduction(2003);
        carProfile.setCcm(1800);
        carProfile.setHp(100);
        carProfileRepository.save(carProfile);

        CarProfile carProfileFromM2 = carProfileRepository.findById(3).get();
        assertNotNull(carProfileFromM2.getId());
    }

}
