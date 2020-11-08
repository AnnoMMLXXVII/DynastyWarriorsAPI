package com.anno.dw8xl.kingdom.facade;

import java.util.Collection;

import com.anno.dw8xl.kingdom.model.KingdomI;

public interface KingdomFacadeInterface {

	public Collection<KingdomI> getAllKingdoms();

	public Collection<KingdomI> getKingdomsBy(String...names);

	public void addKingdom(KingdomI kingdom);

	public Collection<KingdomI> removeKingdom(KingdomI...kingdom);

}
