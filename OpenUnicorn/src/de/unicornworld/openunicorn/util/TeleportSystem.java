package de.unicornworld.openunicorn.util;

import de.unicornworld.openunicorn.Component;

public class TeleportSystem {

	public static void calculateTeleport() {

		if (Component.worldName.contains("tutorial")) {
			Component.switchWorld("world");
		} else if (Component.worldName.contains("world")) {
			if (Component.location.getY() > 300) {
				Component.switchWorld("tutorial");
			} else {
				Component.switchWorld("mainmap");
			}
		} else {
			Component.switchWorld("world");
		}

	}

}
