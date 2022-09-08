package com.ccsw.estimador.estimation;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.estimador.customer.model.CustomerEntity;
import com.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author iciudade
 */
public interface EstimationRepository extends CrudRepository<EstimationEntity, Long> {

    /**
     * Metodo para recuperar un listado paginado de
     * {@link com.ccsw.estimador.estimation.model.EstimationEntity}
     *
     * @param pageable
     * @return
     */
    @Query("select e FROM EstimationEntity e " //
            + "WHERE e.id > 1 " //
            + "and (:customer is null or e.project.customer.id = :customer) " //
            + "and (:project is null or e.project.name like '%'||:project||'%') " //
            + "and (:startDate is null or :endDate is null or e.created BETWEEN :startDate and :endDate) " //
            + "and (e.lastUpdate = (select max(lastUpdate) from EstimationEntity t where t.project = e.project)) "//
            + "and (:username is null or e.id in (select c.estimation.id from CollaboratorEntity c where c.collaborator.username = :username))")
    @EntityGraph(attributePaths = { "project", "project.customer", "createdBy" })
    Page<EstimationEntity> find(@Param("customer") Long customer, @Param("project") String project, @Param("startDate") Date startDate, @Param("endDate") Date endDate, String username, Pageable pageable);

    EstimationEntity findFirstByProjectCustomerOrderByLastUpdateDesc(CustomerEntity customer);

    List<EstimationEntity> findByProjectIdOrderByLastUpdateDesc(Long projectId);
}
