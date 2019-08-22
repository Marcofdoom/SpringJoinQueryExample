package com.bae.anprapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.anprapi.model.MobileCallRecords;
import com.bae.anprapi.model.MobileCallRecordsDTO;

@Service
public interface CallRecordsService {
	
	List<MobileCallRecordsDTO> getRecordsDTO(String phoneNumber);
}