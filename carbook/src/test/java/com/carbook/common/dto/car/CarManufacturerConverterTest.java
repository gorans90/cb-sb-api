package com.carbook.common.dto.car;

import com.carbook.enums.DefaultStatus;
import com.carbook.models.car.CarManufacturer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simic_000 on 4/23/2017.
 */
public class CarManufacturerConverterTest {
    private CarManufacturer carManufacturer;
    private CarManufacturerDTO carManufacturerDTO;
    private List<CarManufacturer> carManufacturers;
    private List<CarManufacturerDTO> carManufacturerDTOs;

    @Before
    public void init() {
        carManufacturers = new ArrayList<>();
        carManufacturerDTOs = new ArrayList<>();

        carManufacturer = new CarManufacturer();
        carManufacturer.setId(1);
        carManufacturer.setActive(DefaultStatus.ACTIVE);
        carManufacturer.setCode("FORD");
        carManufacturer.setName("Ford");

        carManufacturers.add(carManufacturer);

        carManufacturerDTO = new CarManufacturerDTO();
        carManufacturerDTO.setId(1);
        carManufacturerDTO.setActive(DefaultStatus.ACTIVE);
        carManufacturerDTO.setCode("FORD");
        carManufacturerDTO.setName("Ford");

        carManufacturerDTOs.add(carManufacturerDTO);
    }

    @Test
    public void testToDTO() {
        CarManufacturerDTO manufacturerDTO = CarManufacturerConverter.toDTO(carManufacturer);
        Assert.assertEquals("toDTO - car manufacturer is not the same", manufacturerDTO, carManufacturerDTO);
    }

    @Test
    public void testFromDTO() {
        CarManufacturer manufacturer = CarManufacturerConverter.fromDTO(carManufacturerDTO);
        Assert.assertEquals("fromDTO - car manufacturer is not the same", manufacturer, carManufacturer);
    }

    @Test
    public void testListToDTO() {
        List<CarManufacturerDTO> manufacturerDTOs = CarManufacturerConverter.toDTOList(carManufacturers);
        Assert.assertEquals("toDTOList - car manufacturers are not the same", manufacturerDTOs.get(0), carManufacturerDTOs.get(0));
    }

    @Test
    public void testListFromDTO() {
        List<CarManufacturer> manufacturers = CarManufacturerConverter.toModelList(carManufacturerDTOs);
        Assert.assertEquals("fromDTOList - car manufacturers are not the same", manufacturers.get(0), carManufacturers.get(0));
    }
}
