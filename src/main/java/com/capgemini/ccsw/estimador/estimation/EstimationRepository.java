package com.capgemini.ccsw.estimador.estimation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author iciudade
 */
public interface EstimationRepository extends CrudRepository<EstimationEntity, Long>{

	/**
	 * Metodo para recuperar un listado paginado de {@link com.capgemini.ccsw.estimador.estimation.model.EstimationEntity}
	 * @param pageable
	 * @return
	 */
	Page<EstimationEntity> findAll(Pageable pageable);
}
