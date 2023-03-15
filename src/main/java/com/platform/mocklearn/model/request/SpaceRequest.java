package com.platform.mocklearn.model.request;

import com.platform.mocklearn.enums.SpaceEnum;
import org.apache.commons.lang3.ArrayUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

import static com.platform.mocklearn.common.Constants.INTERFACE_CREATION_WHITE_LIST;
import static com.platform.mocklearn.common.Constants.SPACE_CREATION_WHITE_LIST;

public class SpaceRequest implements Serializable {
    public interface Update {
    }

    public interface Insert {
    }

    @NotNull(groups = {Update.class})
    private Long id;

    @NotBlank(groups = {Insert.class, Update.class})
    private String label;

    @NotNull(groups = {Insert.class})
    private Long parentId;

    private SpaceEnum accessAuthority;

    private Integer level;

    private Date ctime;

    private Date mtime;

    public Boolean canCreateInterface() {
        return ArrayUtils.contains(INTERFACE_CREATION_WHITE_LIST, this.getLevel());
    }

    public Boolean canCreateSpace() {
        return ArrayUtils.contains(SPACE_CREATION_WHITE_LIST, this.getLevel());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public SpaceEnum getAccessAuthority() {
        return accessAuthority;
    }

    public void setAccessAuthority(SpaceEnum accessAuthority) {
        this.accessAuthority = accessAuthority;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    @Override
    public String toString() {
        return "SpaceRequest{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", parentId=" + parentId +
                ", accessAuthority=" + accessAuthority +
                ", level=" + level +
                ", cTime=" + ctime +
                ", mTime=" + mtime +
                '}';
    }
}
