/**
 * 
 */
package com.dw8xl.restdw8xl.model.weapon.length;

/**
 * @author Haku Wei
 *
 */
public class Length {

	private Integer foot, inch;
	/**
	 * 
	 */
	public Length() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param foot
	 * @param inch
	 */
	public Length(Integer foot, Integer inch) {
		super();
		this.foot = foot;
		this.inch = inch;
	}
	
	public Length(String length) {
		String[] regex = length.split("'");
		String inch = regex[1].substring(0, regex[1].length()-1);
		this.foot = Integer.parseInt(regex[0]);
		this.inch = Integer.parseInt(inch);
	}
	/**
	 * @return the foot
	 */
	public Integer getFoot() {
		return foot;
	}
	/**
	 * @return the inch
	 */
	public Integer getInch() {
		return inch;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foot == null) ? 0 : foot.hashCode());
		result = prime * result + ((inch == null) ? 0 : inch.hashCode());
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
		Length other = (Length) obj;
		if (foot == null) {
			if (other.foot != null)
				return false;
		} else if (!foot.equals(other.foot))
			return false;
		if (inch == null) {
			if (other.inch != null)
				return false;
		} else if (!inch.equals(other.inch))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Length [foot=" + foot + ", inch=" + inch + "]";
	}
	
	

}
