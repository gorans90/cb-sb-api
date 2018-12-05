package com.carbook.models.car;

import com.carbook.repositories.car.CarModelRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarModelTest extends TestCase {

  @Autowired
  private CarModelRepository carModelRepository;

  @Test
  public void testGetAll() {
    CarModel cm = new CarModel();
    cm.setName("FIAT");
    carModelRepository.save(cm);

    CarModel cm2 = new CarModel();
    cm2.setName("BMW");
    carModelRepository.save(cm2);

    List<CarModel> carModels = (List<CarModel>) carModelRepository.findAll();
    assertTrue("more than one", carModels.size() > 1);
  }

  @Test
  public void testGetOne() {
    CarModel cm = new CarModel();
    cm.setName("BMW");
    carModelRepository.save(cm);
    CarModel carModel = this.carModelRepository.findById(3).get();
    assertNotNull(carModel.getId()); //should not be null
  }

}