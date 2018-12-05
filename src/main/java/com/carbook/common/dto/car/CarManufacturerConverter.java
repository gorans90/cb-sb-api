package com.carbook.common.dto.car;

import com.carbook.models.car.CarManufacturer;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by simic_000 on 3/19/2017.
 */
public class CarManufacturerConverter {

    public static CarManufacturerDTO toDTO(CarManufacturer carManufacturer) {
        CarManufacturerDTO carManufacturerDTO = new CarManufacturerDTO();

        ModelMapper mapper = new ModelMapper();
        mapper.map(carManufacturer, carManufacturerDTO);

        return carManufacturerDTO;
    }

    public static CarManufacturer fromDTO(CarManufacturerDTO carManufacturerDTO) {
        CarManufacturer carManufacturer = new CarManufacturer();

        ModelMapper mapper = new ModelMapper();
        mapper.map(carManufacturerDTO, carManufacturer);

        return carManufacturer;
    }

    public static List<CarManufacturerDTO> toDTOList(List<CarManufacturer> carManufacturers) {
        return carManufacturers.stream().map(CarManufacturerConverter::toDTO).collect(Collectors.toList());
    }

    public static List<CarManufacturer> toModelList(List<CarManufacturerDTO> carManufacturerDTOs) {
        return carManufacturerDTOs.stream().map(CarManufacturerConverter::fromDTO).collect(Collectors.toList());
    }
}
