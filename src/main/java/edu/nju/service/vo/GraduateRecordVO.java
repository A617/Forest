package edu.nju.service.vo;

import edu.nju.data.model.Role;

import java.util.Date;

/**
 * Created by Dora on 2016/9/10.
 */
public class GraduateRecordVO extends RecordVO{

    protected Role role;

    public GraduateRecordVO(String username, Role role, Date time) {
        super(username,time);
        this.role = role;
        this.category = RecordCategory.graduate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "GraduateRecordVO{" +
                "role=" + role +
                "} " + super.toString();
    }
}
