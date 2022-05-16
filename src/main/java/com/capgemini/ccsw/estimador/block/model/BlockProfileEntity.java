package com.capgemini.ccsw.estimador.block.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.capgemini.ccsw.estimador.profile.model.ProfileEntity;

@Entity
@Table(name = "block_profile")
public class BlockProfileEntity {

    @EmbeddedId
    private BlockProfileId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idBlock", referencedColumnName = "id", insertable = false, updatable = false)
    private BlockEntity block;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProfile", referencedColumnName = "id", insertable = false, updatable = false)
    private ProfileEntity profile;

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    public Integer getIdBlock() {
        return id.getIdBlock();
    }

    public Integer getIdProfile() {
        return id.getIdProfile();
    }

    public void setIdBlock(Integer idBlock) {
        this.id.setIdBlock(idBlock);
    }

    public void setIdProfile(Integer idProfile) {
        this.id.setIdProfile(idProfile);
    }

    public BlockProfileId getId() {
        return id;
    }

    public void setId(BlockProfileId id) {
        this.id = id;
    }

    public BlockEntity getBlock() {
        return block;
    }

    public void setBlock(BlockEntity block) {
        this.block = block;
    }

}
