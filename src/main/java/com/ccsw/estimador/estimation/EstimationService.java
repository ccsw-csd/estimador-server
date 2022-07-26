package com.ccsw.estimador.estimation;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ccsw.estimador.customer.model.CustomerDto;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;
import com.ccsw.estimador.estimation.model.EstimationSearchDto;

/**
 * @author iciudade
 */
public interface EstimationService {

    /**
     * Metodo para recuperar un listado paginado de
     * {@link com.ccsw.estimador.estimation.model.EstimationEntity}
     *
     * @param dto
     * @return
     */
    Page<EstimationEntity> findPage(EstimationSearchDto dto);

    EstimationEditDto getEstimationForEdit(Long id);

    List<EstimationEntity> findVersion(Long projectId);

    EstimationEntity getLastEstimationByCustomer(CustomerDto customer);

    Long saveEstimation(Long id, EstimationEditDto data);
}
