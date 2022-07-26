package com.ccsw.estimador.distribution.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ccsw.estimador.block.model.BlockEntity;
import com.ccsw.estimador.estimation.model.EstimationEntity;

/**
 * @author asolerpa
 *
 *         Entidad que representa los datos almacenados en la tabla summary
 *
 */
@Entity
@Table(name = "summary")
public class DistributionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estimation")
    private EstimationEntity estimation;

    @ManyToOne
    @JoinColumn(name = "block")
    private BlockEntity block;

    @Column(name = "a")
    private Double gradeA;

    @Column(name = "b")
    private Double gradeB;

    @Column(name = "c")
    private Double gradeC;

    @Column(name = "d")
    private Double gradeD;

    /**
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getid}.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return estimation
     */
    public EstimationEntity getEstimation() {

        return this.estimation;
    }

    /**
     * @param estimation new value of {@link #getestimation}.
     */
    public void setEstimation(EstimationEntity estimation) {

        this.estimation = estimation;
    }

    /**
     * @return block
     */
    public BlockEntity getBlock() {

        return this.block;
    }

    /**
     * @param block new value of {@link #getblock}.
     */
    public void setBlock(BlockEntity block) {

        this.block = block;
    }

    /**
     * @return gradeA
     */
    public Double getGradeA() {

        return this.gradeA;
    }

    /**
     * @param gradeA new value of {@link #getgradeA}.
     */
    public void setGradeA(Double gradeA) {

        this.gradeA = gradeA;
    }

    /**
     * @return gradeB
     */
    public Double getGradeB() {

        return this.gradeB;
    }

    /**
     * @param gradeB new value of {@link #getgradeB}.
     */
    public void setGradeB(Double gradeB) {

        this.gradeB = gradeB;
    }

    /**
     * @return gradeC
     */
    public Double getGradeC() {

        return this.gradeC;
    }

    /**
     * @param gradeC new value of {@link #getgradeC}.
     */
    public void setGradeC(Double gradeC) {

        this.gradeC = gradeC;
    }

    /**
     * @return gradeD
     */
    public Double getGradeD() {

        return this.gradeD;
    }

    /**
     * @param gradeD new value of {@link #getgradeD}.
     */
    public void setGradeD(Double gradeD) {

        this.gradeD = gradeD;
    }

}
