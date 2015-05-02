package br.com.caelum.notasfiscais.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class CicloDeVidaListener implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("Depois da fase: " + event.getPhaseId());

	}

	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("Antes da fase: " + event.getPhaseId());
	}

	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.ANY_PHASE;
	}

}
