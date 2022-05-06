package com.capgemini.ccsw.estimador.estimation;

import org.springframework.data.domain.Page;

import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationSearchDto;

/**
 * @author iciudade
 */
public interface EstimationService {

    /**
     * Metodo para recuperar un listado paginado de
     * {@link com.capgemini.ccsw.estimador.estimation.model.EstimationEntity}
     *
     * @param dto
     * @return
     */
    Page<EstimationEntity> findPage(EstimationSearchDto dto);

    EstimationEntity getEstimation(Long id);
    
    Page<EstimationEntity> findVersion(EstimationSearchDto dto);

}