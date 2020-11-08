/**
 * 
 */
package com.anno.dw8xl.kingdom.model;

import com.anno.dw8xl.shared.KingdomDeserializer;
import com.anno.dw8xl.view.CharacterView;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Haku Wei
 *
 */
@JsonView({CharacterView.Kingdom.class, CharacterView.Officer.class})
@JsonSubTypes({ @Type(value = Kingdom.class, name = "Kingdom"), @Type(value = NullKingdom.class, name = "null"), })
@JsonDeserialize(using = KingdomDeserializer.class)
public interface KingdomI {

	public String getName();

	@Override
	public int hashCode();

	@Override
	public boolean equals(Object obj);

	@Override
	public String toString();

}
