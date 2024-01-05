package com.ccsw.estimador.estimation;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

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
            + "and (e.lastUpdate = (select max(lastUpdate) from EstimationEntity t where t.project = e.project)) "//
            + "and (:username is null or e.id in (select c.estimation.id from CollaboratorEntity c where c.collaborator.username = :username))")
    @EntityGraph(attributePaths = { "project", "project.customer", "createdBy" })
    List<EstimationEntity> find(String username);

    EstimationEntity findFirstByProjectCustomerOrderByLastUpdateDesc(CustomerEntity customer);

    List<EstimationEntity> findByProjectIdOrderByLastUpdateDesc(Long projectId);
}
