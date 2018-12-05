package com.carbook.common.dto.car;

import com.carbook.models.car.CarProfile;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by simic_000 on 3/19/2017.
 */
public class CarProfileConverter {

    public static CarProfileDTO toDTO(CarProfile carProfile) {
        CarProfileDTO carProfileDTO = new CarProfileDTO();

        ModelMapper mapper = new ModelMapper();
        mapper.map(carProfile, carProfileDTO);

        return carProfileDTO;
    }

    public static CarProfile fromDTO(CarProfileDTO carProfileDTO) {
        CarProfile carProfile = new CarProfile();

        ModelMapper mapper = new ModelMapper();
        mapper.map(carProfileDTO, carProfile);

        return carProfile;
    }

    public static List<CarProfileDTO> toDTOList(List<CarProfile> carProfiles) {
        return carProfiles.stream().map(CarProfileConverter::toDTO).collect(Collectors.toList());
    }

    public static List<CarProfile> toModelList(List<CarProfileDTO> carProfileDTOs) {
        return carProfileDTOs.stream().map(CarProfileConverter::fromDTO).collect(Collectors.toList());
    }
}
