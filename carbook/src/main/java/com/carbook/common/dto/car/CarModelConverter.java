package com.carbook.common.dto.car;

import com.carbook.models.car.CarModel;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by simic_000 on 3/19/2017.
 */
public class CarModelConverter {

    public static CarModelDTO toDTO(CarModel carModel) {
        CarModelDTO carModelDTO = new CarModelDTO();

        ModelMapper mapper = new ModelMapper();
        mapper.map(carModel, carModelDTO);

        return carModelDTO;
    }

    public static CarModel fromDTO(CarModelDTO carModelDTO) {
        CarModel carModel = new CarModel();

        ModelMapper mapper = new ModelMapper();
        mapper.map(carModelDTO, carModel);

        return carModel;
    }

    public static List<CarModelDTO> toDTOList(List<CarModel> carModels) {
        return carModels.stream().map(CarModelConverter::toDTO).collect(Collectors.toList());
    }

    public static List<CarModel> toModelList(List<CarModelDTO> carModelDTOs) {
        return carModelDTOs.stream().map(CarModelConverter::fromDTO).collect(Collectors.toList());
    }
}
