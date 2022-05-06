package com.capgemini.ccsw.estimador.estimation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.estimador.config.mapper.BeanMapper;
import com.capgemini.ccsw.estimador.customer.model.CustomerDto;
import com.capgemini.ccsw.estimador.customer.model.CustomerEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationEntity;
import com.capgemini.ccsw.estimador.estimation.model.EstimationSearchDto;

/**
 * @author iciudade
 */
@Service
public class EstimationServiceImpl implements EstimationService {

    @Autowired
    EstimationRepository estimationRepository;

    @Autowired
    BeanMapper beanMapper;

    @Override
    public Page<EstimationEntity> findPage(EstimationSearchDto dto) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date startDate;

        Date endDate;

        try {
            if (dto.getStartDate() == null)
                startDate = format.parse("2020-01-01");
            else
                startDate = dto.getStartDate();

            if (dto.getEndDate() == null)
                endDate = format.parse("2099-12-31");
            else
                endDate = dto.getEndDate();
        } catch (ParseException e) {
            e.printStackTrace();
            startDate = null;
            endDate = null;
        }

        return this.estimationRepository.find(dto.getCustomerId(), dto.getProjectName(), startDate, endDate,
                dto.getPageable());
    }

    @Override
    public EstimationEntity getEstimation(Long id) {

        return this.estimationRepository.getById(id);
    }

    @Override
    public EstimationEntity getLastEstimationByCustomer(CustomerDto customer) {

        return this.estimationRepository
                .findFirstByProjectCustomerOrderByLastUpdateDesc(this.beanMapper.map(customer, CustomerEntity.class));

    }
}
