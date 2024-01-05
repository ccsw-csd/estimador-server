package com.ccsw.estimador.estimation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import com.ccsw.estimador.customer.model.CustomerDto;
import com.ccsw.estimador.estimation.model.EstimationEditDto;
import com.ccsw.estimador.estimation.model.EstimationEntity;

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
    List<EstimationEntity> findAll(boolean adminView);

    EstimationEditDto getEstimationForEdit(Long id);

    List<EstimationEntity> findVersion(Long projectId);

    EstimationEntity getLastEstimationByCustomer(CustomerDto customer);

    Long saveEstimation(Long id, EstimationEditDto data);

    EstimationEditDto duplicateEstimation(Long id, String version);

    File toExport(EstimationEditDto dto) throws FileNotFoundException;
}
