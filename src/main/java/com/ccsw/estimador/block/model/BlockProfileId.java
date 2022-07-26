package com.ccsw.estimador.block.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BlockProfileId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idBlock;

    private Integer idProfile;

    public Integer getIdBlock() {
        return idBlock;
    }

    public void setIdBlock(Integer idBlock) {
        this.idBlock = idBlock;
    }

    public Integer getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
    }

}
