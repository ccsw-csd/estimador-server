package com.capgemini.ccsw.estimador.config.mapper;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.ccsw.estimador.estimation.model.EstimationDto;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;

/**
* @author coedevon
*/
public interface BeanMapper extends com.devonfw.module.beanmapping.common.api.BeanMapper {

  /**
  * Mapea el genérico de un Page en otro tipo de genérico
  * @param <T>
  * @param source
  * @param targetClass
  * @return
  */
  <T> Page<T> mapPage(Page source, Class<T> targetClass);

List<EstimationDto> mapList(Page<EstimationEntity> findVersion, Class<EstimationDto> class1);

}