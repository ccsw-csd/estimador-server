package com.capgemini.ccsw.estimador.estimation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationSearchDto;

/**
 * @author iciudade
 */
@Service
public class EstimationServiceImpl implements EstimationService{

	@Autowired
	EstimationRepository estimationRepository;

	@Override
	public Page<EstimationEntity> findPage(EstimationSearchDto dto) {

		return this.estimationRepository.findAll(dto.getPageable());
	}

}
