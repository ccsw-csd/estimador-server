package com.capgemini.ccsw.estimador.estimation.model;

import org.springframework.data.domain.Pageable;

/**
 * @author iciudade
 */
public class EstimationSearchDto {

	private Pageable pageable;

	/**
	 * @return the pageable
	 */
	public Pageable getPageable() {
		return pageable;
	}

	/**
	 * @param pageable the pageable to set
	 */
	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}
	
}
