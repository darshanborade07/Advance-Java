package com.sunbeam.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.DAO.UserDao;
import com.sunbeam.DAO.VehicleDao;
import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.DTO.SoldDetailsDTO;
import com.sunbeam.DTO.VehicleReqDTO;
import com.sunbeam.DTO.VehicleResDTO;
import com.sunbeam.DTO.VehicleReqDTO;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.entities.User;
import com.sunbeam.entities.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleDao vehicleDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public ApiResponse addNewVehicle(VehicleReqDTO dto, Long userId) {
		User user = userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("Invalid UserID!"));
		Vehicle vehicle = mapper.map(dto, Vehicle.class);
		vehicle.setUser(user);
		vehicleDao.save(vehicle);
		return new ApiResponse("New Vehicle Added!");
	}
	
	@Override
	public List<VehicleResDTO> getVehiclesByUsername(String userName) {
		List<Vehicle> persistentVehicles = vehicleDao.findByUserUname(userName);
		List<VehicleResDTO> vehiclesDtoList  = new ArrayList<>();
		for (Vehicle vehicle : persistentVehicles) {
			vehiclesDtoList.add(mapper.map(vehicle, VehicleResDTO.class));
		}
		return vehiclesDtoList;
	}

	@Override
	public ApiResponse deleteVehiclesByUsername(String userName) {
		List<Vehicle> persistentVehicles = vehicleDao.findByUserUname(userName);
		for (Vehicle vehicle : persistentVehicles) {
			vehicleDao.delete(vehicle);
		}
		return new ApiResponse("All Records Deleted for the given User!!");
	}

	@Override
	public List<SoldDetailsDTO> getVehicleDetailsByDate(String date) {
		LocalDate purchaseDate = LocalDate.parse(date);
		List<Vehicle> vehicleList = vehicleDao.findByPurchaseDate(purchaseDate);
		List<SoldDetailsDTO> soldDetails = new ArrayList<>();
		for (Vehicle vehicle : vehicleList) {
			 
			soldDetails.add(mapper.map(vehicle, SoldDetailsDTO.class));
		}
		
		return soldDetails;
	}

	

}
