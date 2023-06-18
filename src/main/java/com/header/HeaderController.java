package com.header;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.A;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;

public class HeaderController extends SelectorComposer<Div> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Wire
	private A homePage,shopping,soccerSkills,support,aboutUs;
	@Override
	public void doAfterCompose(Div comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}
	@Listen("onClick=#shopping")
	public void sho() {
		Messagebox.show("ss");
	}
}
