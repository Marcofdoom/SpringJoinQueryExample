package com.bae.anprapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.anprapi.model.MobileCallRecords;
import com.bae.anprapi.model.MobileCallRecordsDTO;
import com.bae.anprapi.repository.CallRecordsRepository;

@Service
public class CallRecordsServiceImpl implements CallRecordsService {

	private CallRecordsRepository callRecordsRepository;

	public CallRecordsServiceImpl(CallRecordsRepository callRecordsRepository) {
		this.callRecordsRepository = callRecordsRepository;
	}

	@Override
	public List<MobileCallRecordsDTO> getRecordsDTO(String phoneNumber) {
		return callRecordsRepository.getRecordsDTO(phoneNumber);
	}
}