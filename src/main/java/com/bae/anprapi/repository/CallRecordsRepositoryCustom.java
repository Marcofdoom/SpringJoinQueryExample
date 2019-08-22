package com.bae.anprapi.repository;

import java.util.List;

import com.bae.anprapi.model.MobileCallRecordsDTO;

public interface CallRecordsRepositoryCustom {

	List<MobileCallRecordsDTO> getRecordsDTO(String phoneNumber);
}