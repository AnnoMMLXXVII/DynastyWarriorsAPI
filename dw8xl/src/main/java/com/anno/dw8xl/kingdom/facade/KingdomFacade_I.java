package com.anno.dw8xl.kingdom.facade;

import java.util.Collection;

import com.anno.dw8xl.kingdom.model.KingdomI;

public interface KingdomFacade_I {

	public Collection<KingdomI> getAllKingdoms();
	public KingdomI getKingdomsByName(String name);
	
	public void addKingdom(KingdomI kingdom);
	public void removeKingdom(KingdomI kingdom);

	
}
