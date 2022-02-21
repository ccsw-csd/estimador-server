package com.capgemini.ccsw.estimador.estimation;

import org.springframework.data.domain.Page;

import com.capgemini.ccsw.estimador.estimation.model.EstimationSearchDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author iciudade
 */
public interface EstimationService {
	
	/**
	 * Metodo para recuperar un listado paginado de {@link com.capgemini.ccsw.estimador.estimation.model.EstimationEntity}
	 * @param dto
	 * @return
	 */
	Page<EstimationEntity> findPage(EstimationSearchDto dto);

}
