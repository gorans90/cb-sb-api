package com.carbook.common.dto.car;

import com.carbook.common.dto.user.UserDTO;
import com.carbook.enums.DefaultStatus;
import com.carbook.models.car.CarManufacturer;
import com.carbook.models.car.CarModel;
import com.carbook.models.car.CarProfile;
import com.carbook.models.user.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simic_000 on 4/24/2017.
 */
public class CarProfileConverterTest {
    private CarProfile carProfile;
    private CarProfileDTO carProfileDTO;
    private List<CarProfile> carProfiles;
    private List<CarProfileDTO> carProfileDTOs;

    @Before
    public void init() {
        carProfiles = new ArrayList<>();
        carProfileDTOs = new ArrayList<>();

        CarModel carModel = new CarModel();
        carModel.setId(1);
        carModel.setActive(DefaultStatus.ACTIVE);
        carModel.setName("Fiesta");
        CarManufacturer carManufacturer = new CarManufacturer();
        carManufacturer.setId(1);
        carManufacturer.setActive(DefaultStatus.ACTIVE);
        carManufacturer.setCode("FORD");
        carManufacturer.setName("Ford");
        carModel.setCarManufacturer(carManufacturer);
        User userForValidate = new User();
        userForValidate.setId(1);
        userForValidate.setEmail("test@gmail.com");
        carProfile = new CarProfile();
        carProfile.setActive(DefaultStatus.ACTIVE);
        carProfile.setId(1);
        carProfile.setCarModel(carModel);
        carProfile.setCcm(1200);
        carProfile.setHp(80);
        carProfile.setPrimaryCar(true);
        carProfile.setYearOfProduction(2000);
        carProfile.setUser(userForValidate);

        carProfiles.add(carProfile);

        CarModelDTO carModelDTO = new CarModelDTO();
        carModelDTO.setId(1);
        carModelDTO.setActive(DefaultStatus.ACTIVE);
        carModelDTO.setName("Fiesta");
        CarManufacturerDTO carManufacturerDTO = new CarManufacturerDTO();
        carManufacturerDTO.setId(1);
        carManufacturerDTO.setActive(DefaultStatus.ACTIVE);
        carManufacturerDTO.setCode("FORD");
        carManufacturerDTO.setName("Ford");
        carModelDTO.setCarManufacturer(carManufacturerDTO);
        UserDTO userDtoForValidate = new UserDTO();
        userDtoForValidate.setId(1);
        userDtoForValidate.setEmail("test@gmail.com");
        carProfileDTO = new CarProfileDTO();
        carProfileDTO.setActive(DefaultStatus.ACTIVE);
        carProfileDTO.setId(1);
        carProfileDTO.setCarModel(carModelDTO);
        carProfileDTO.setCcm(1200);
        carProfileDTO.setHp(80);
        carProfileDTO.setPrimaryCar(true);
        carProfileDTO.setYearOfProduction(2000);
        carProfileDTO.setUser(userDtoForValidate);

        carProfileDTOs.add(carProfileDTO);
    }

    @Test
    public void testToDTO() {
        CarProfileDTO profileDTO = CarProfileConverter.toDTO(carProfile);
        Assert.assertEquals("toDTO - car profile is not the same", profileDTO, carProfileDTO);
    }

    @Test
    public void testFromDTO() {
        CarProfile profile = CarProfileConverter.fromDTO(carProfileDTO);
        Assert.assertEquals("fromDTO - car profile is not the same", profile, carProfile);
    }

    @Test
    public void testListToDTO() {
        List<CarProfileDTO> profileDTOs = CarProfileConverter.toDTOList(carProfiles);
        Assert.assertEquals("toDTOList - car profiles are not the same", profileDTOs, carProfileDTOs);
    }

    @Test
    public void testListFromDTO() {
        List<CarProfile> profiles = CarProfileConverter.toModelList(carProfileDTOs);
        Assert.assertEquals("fromDTOList - car profiles are not the same", profiles, carProfiles);
    }
}
