package ss.week2;

/**
 * P-2.6, P-2.7
 */
public class ThreeWayLamp {
	private LampSetting setting;
	/**
	 * @ ensure this.setting == LampSetting.OFF
	 */
	public ThreeWayLamp() {
		this.setting = LampSetting.OFF;
	}

	/**
	 * @ pure
	 * @ ensure \result == this.setting
	 */
	public LampSetting currentSetting () {
		return this.setting;
	}

	/**
	 * @ ensure \old(currentSetting() == LampSetting.OFF ==> currentSetting() == LampSetting.LOW;
	 * 	        \old(currentSetting() == LampSetting.LOW ==> currentSetting() == LampSetting.MEDIUM;
 	 *          \old(currentSetting() == LampSetting.MEDIUM ==> currentSetting() == LampSetting.HIGH;
	 *          \old(currentSetting() == LampSetting.HIGH ==> currentSetting() == LampSetting.OFF;
	 */
	public void  switchSetting () {
		switch (this.setting) {
			case OFF:
				this.setting = LampSetting.LOW;
				break;

			case LOW:
				this.setting = LampSetting.MEDIUM;
				break;

			case MEDIUM:
				this.setting = LampSetting.HIGH;
				break;

			case HIGH:
				this.setting = LampSetting.OFF;
				break;
		}
	}
}
