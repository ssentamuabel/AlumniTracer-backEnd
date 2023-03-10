package org.pahappa.systems.alumniTracer.frontend.views.render;

import org.sers.webutils.model.security.User;
import org.sers.webutils.server.shared.SharedAppData;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "componentRenderer")
@SessionScoped
public class ComponentRenderer implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean administrator = false;

    private User loggedInUser;

    @PostConstruct
    public void init() {
        this.loggedInUser = SharedAppData.getLoggedInUser();
        this.administrator = loggedInUser.hasAdministrativePrivileges();
        this.setAdministrator(loggedInUser.hasPermission(org.sers.webutils.model.security.PermissionConstants.PERM_ADMINISTRATOR));
    }

    /**
     * @return the loggedInUser
     */
    public User getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * @param loggedInUser the loggedInUser to set
     */
    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    /**
     * @return the administrator
     */
    public boolean isAdministrator() {
        return administrator;
    }

    /**
     * @param administrator the administrator to set
     */
    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

}