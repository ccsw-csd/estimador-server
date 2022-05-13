package com.capgemini.ccsw.estimador.estimation;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.estimador.customer.model.CustomerEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author iciudade
 */
public interface EstimationRepository extends CrudRepository<EstimationEntity, Long> {

    /**
     * Metodo para recuperar un listado paginado de
     * {@link com.capgemini.ccsw.estimador.estimation.model.EstimationEntity}
     *
     * @param pageable
     * @return
     */
    @Query("select e FROM EstimationEntity e " + "WHERE (:customer is null or e.project.customer.id = :customer) "
            + "and (:project is null or e.project.name like '%'||:project||'%') "
            + "and (:startDate is null or :endDate is null or e.created BETWEEN :startDate and :endDate) and (e.lastUpdate = "
            + "(select max(lastUpdate) from EstimationEntity e2 where e2.project = e.project and e2.createdBy = e.createdBy))")
    @EntityGraph(attributePaths = { "project", "project.customer", "createdBy", "createdBy.role" })
    Page<EstimationEntity> find(@Param("customer") Long customer, @Param("project") String project,
            @Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);

    EstimationEntity getById(Long id);

    EstimationEntity findFirstByProjectCustomerOrderByLastUpdateDesc(CustomerEntity customer);

    List<EstimationEntity> findByProjectIdOrderByLastUpdateDesc(Long projectId);
}
