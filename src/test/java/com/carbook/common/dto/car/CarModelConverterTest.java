package com.carbook.common.dto.car;

import com.carbook.enums.DefaultStatus;
import com.carbook.models.car.CarManufacturer;
import com.carbook.models.car.CarModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simic_000 on 4/24/2017.
 */
public class CarModelConverterTest {
    private CarModel carModel;
    private CarModelDTO carModelDTO;
    private List<CarModel> carModels;
    private List<CarModelDTO> carModelDTOs;

    @Before
    public void init() {
        carModels = new ArrayList<>();
        carModelDTOs = new ArrayList<>();

        carModel = new CarModel();
        carModel.setId(1);
        carModel.setActive(DefaultStatus.ACTIVE);
        carModel.setName("Fiesta");
        CarManufacturer carManufacturer = new CarManufacturer();
        carManufacturer.setId(1);
        carManufacturer.setActive(DefaultStatus.ACTIVE);
        carManufacturer.setCode("FORD");
        carManufacturer.setName("Ford");
        carModel.setCarManufacturer(carManufacturer);

        carModels.add(carModel);

        carModelDTO = new CarModelDTO();
        carModelDTO.setId(1);
        carModelDTO.setActive(DefaultStatus.ACTIVE);
        carModelDTO.setName("Fiesta");
        CarManufacturerDTO carManufacturerDTO = new CarManufacturerDTO();
        carManufacturerDTO.setId(1);
        carManufacturerDTO.setActive(DefaultStatus.ACTIVE);
        carManufacturerDTO.setCode("FORD");
        carManufacturerDTO.setName("Ford");
        carModelDTO.setCarManufacturer(carManufacturerDTO);

        carModelDTOs.add(carModelDTO);
    }

    @Test
    public void testToDTO() {
        CarModelDTO modelDTO = CarModelConverter.toDTO(carModel);
        Assert.assertEquals("toDTO - car model is not the same", modelDTO, carModelDTO);
    }

    @Test
    public void testFromDTO() {
        CarModel model = CarModelConverter.fromDTO(carModelDTO);
        Assert.assertEquals("fromDTO - car model is not the same", model, carModel);
    }

    @Test
    public void testListToDTO() {
        List<CarModelDTO> modelDTOs = CarModelConverter.toDTOList(carModels);
        Assert.assertEquals("toDTOList - car models are not the same", modelDTOs, carModelDTOs);
    }

    @Test
    public void testListFromDTO() {
        List<CarModel> models = CarModelConverter.toModelList(carModelDTOs);
        Assert.assertEquals("fromDTOList - car models are not the same", models, carModels);
    }
}
