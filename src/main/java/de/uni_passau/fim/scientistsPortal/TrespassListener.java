package de.uni_passau.fim.scientistsPortal;

import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;

/**
 * Checks requests on user authentication.
 */
public class TrespassListener implements PhaseListener {

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {

    }

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext fctx = event.getFacesContext();
        ExternalContext ctx = fctx.getExternalContext();
        // Map<String, Object> sessionMap = ctx.getSessionMap();

        boolean publicArea = false;
        UIViewRoot viewRoot = fctx.getViewRoot();
        if (viewRoot != null) {
            String url = viewRoot.getViewId();
            publicArea = url.endsWith("login.xhtml");
        } else {
            publicArea = true;
        }

        //boolean loggedIn = sessionMap.containsKey("loggedin");
        //if (!publicArea && !loggedIn) {
        //     todo redirect
        //}
    }
}
