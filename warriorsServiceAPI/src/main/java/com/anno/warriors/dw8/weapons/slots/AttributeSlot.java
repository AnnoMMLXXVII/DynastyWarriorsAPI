package com.anno.warriors.dw8.weapons.slots;

import com.anno.warriors.dw8.enums.attribute.AttributeInterface;
import com.anno.warriors.dw8.manager.DynastyWarriors8Object;

public abstract class AttributeSlot
			implements Comparable<AttributeSlot>, DynastyWarriors8Object<AttributeSlot> {
		private AttributeInterface attribute;

		protected AttributeSlot() {
			super();
		}

		protected AttributeSlot(AttributeInterface attribute) {
			this.attribute = attribute;
		}

		public String getName() {
			return attribute.getName();
		}
		
		public abstract Integer getLevel();

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AttributeSlot other = (AttributeSlot) obj;
			if (attribute == null) {
				if (other.attribute != null)
					return false;
			} else if (!attribute.equals(other.attribute))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "AttributeSlot [attribute=" + attribute.getName();
		}

	}