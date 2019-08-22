package com.bae.anprapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bae.anprapi.model.MobileCallRecordsDTO;

@Repository
public class CallRecordsRepositoryCustomImpl implements CallRecordsRepositoryCustom {

	private EntityManager entityManager;

	@Autowired
	public CallRecordsRepositoryCustomImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<MobileCallRecordsDTO> getRecordsDTO(String phoneNumber) {

		TypedQuery<MobileCallRecordsDTO> queryCaller = entityManager.createQuery(
				"SELECT NEW com.bae.anprapi.model.MobileCallRecordsDTO(p.receiverMsisdn.forenames, p.receiverMsisdn.surname,p.receiverMsisdn.address,p.receiverMsisdn.dateOfBirth,p.timestamp)"
						+ " FROM MobileCallRecords p where p.callerMsisdn.phoneNumber = :phoneNumber",
				MobileCallRecordsDTO.class).setParameter("phoneNumber", phoneNumber);

		TypedQuery<MobileCallRecordsDTO> queryReceiver = entityManager.createQuery(
				"SELECT NEW com.bae.anprapi.model.MobileCallRecordsDTO(p.callerMsisdn.forenames, p.callerMsisdn.surname,p.callerMsisdn.address,p.callerMsisdn.dateOfBirth,p.timestamp)"
						+ " FROM MobileCallRecords p where p.receiverMsisdn.phoneNumber = :phoneNumber",
				MobileCallRecordsDTO.class).setParameter("phoneNumber", phoneNumber);

		List<MobileCallRecordsDTO> query1 = queryCaller.getResultList();
		List<MobileCallRecordsDTO> query2 = queryReceiver.getResultList();

		for (MobileCallRecordsDTO i : query1) {
			i.setType("Called");
		}

		for (MobileCallRecordsDTO i : query2) {
			i.setType("Received");
		}

		query1.addAll(query2);

		return query1;
	}
}