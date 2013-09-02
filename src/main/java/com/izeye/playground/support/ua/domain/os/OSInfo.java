package com.izeye.playground.support.ua.domain.os;

import com.izeye.playground.common.domain.StringConstants;
import com.izeye.playground.support.ua.domain.UnidentifiableUserAgentException;

// Reference:
// http://msdn.microsoft.com/en-us/library/ms537503%28v=vs.85%29.aspx
public class OSInfo {

	public static final OSInfo NOT_AVAILABLE = new OSInfo(OSType.NOT_AVAILABLE,
			StringConstants.NOT_AVAILABLE);

	private final OSType type;
	private final String version;

	public OSInfo(OSType type, String version) {
		this.type = type;
		this.version = version;
	}

	public OSType getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}

	private static String MAC_OS_X_SNOW_LEOPARD_VERSION = "10.6";
	private static String MAC_OS_X_SNOW_LEOPARD_ALIAS = "Snow Leopard";

	private static String MAC_OS_X_LION_VERSION = "10.7";
	private static String MAC_OS_X_LION_ALIAS = "Lion";

	private static String MAC_OS_X_MOUNTAIN_LION_VERSION = "10.8";
	private static String MAC_OS_X_MOUNTAIN_LION_ALIAS = "Mountain Lion";

	private static String MAC_OS_X_MOUNTAIN_MAVERICKS_VERSION = "10.9";
	private static String MAC_OS_X_MOUNTAIN_MAVERICKS_ALIAS = "Mavericks";

	private static String WINDOWS_95_VERSION = "95";
	private static String WINDOWS_95_ALIAS = "95";

	private static String WINDOWS_98_VERSION = "98";
	private static String WINDOWS_98_ALIAS = "98";

	// NOTE:
	// No information for Windows NT.
	private static String WINDOWS_NT_VERSION = "NT";
	private static String WINDOWS_NT_ALIAS = "NT";

	private static String WINDOWS_2000_VERSION = "NT 5.0";
	private static String WINDOWS_2000_ALIAS = "2000";

	private static String WINDOWS_XP_VERSION = "NT 5.1";
	private static String WINDOWS_XP_ALIAS = "XP";

	private static String WINDOWS_SERVER_2003_VERSION = "NT 5.2";
	private static String WINDOWS_SERVER_2003_ALIAS = "Server 2003 or XP x64 Edition";

	private static String WINDOWS_VISTA_VERSION = "NT 6.0";
	private static String WINDOWS_VISTA_ALIAS = "Vista";

	private static String WINDOWS_7_VERSION = "NT 6.1";
	private static String WINDOWS_7_ALIAS = "7";

	private static String WINDOWS_8_VERSION = "NT 6.2";
	private static String WINDOWS_8_ALIAS = "8";

	public String getDisplayName() {
		String alias = getAlias();

		StringBuilder sbDisplayName = new StringBuilder();
		sbDisplayName.append(type.getName());
		sbDisplayName.append(" ");
		sbDisplayName.append(version);
		sbDisplayName.append(" (");
		sbDisplayName.append(alias);
		sbDisplayName.append(")");
		return sbDisplayName.toString();
	}

	private String getAlias() {
		switch (type) {
		case MAC_OS_X:
			if (version.startsWith(MAC_OS_X_SNOW_LEOPARD_VERSION)) {
				return MAC_OS_X_SNOW_LEOPARD_ALIAS;
			} else if (version.startsWith(MAC_OS_X_LION_VERSION)) {
				return MAC_OS_X_LION_ALIAS;
			} else if (version.startsWith(MAC_OS_X_MOUNTAIN_LION_VERSION)) {
				return MAC_OS_X_MOUNTAIN_LION_ALIAS;
			} else if (version.startsWith(MAC_OS_X_MOUNTAIN_MAVERICKS_VERSION)) {
				return MAC_OS_X_MOUNTAIN_MAVERICKS_ALIAS;
			} else {
				throw new UnidentifiableUserAgentException(
						"Unidentifiable OS version: " + type + ", " + version);
			}

		case WINDOWS:
			if (version.equals(WINDOWS_95_VERSION)) {
				return WINDOWS_95_ALIAS;
			} else if (version.equals(WINDOWS_98_VERSION)) {
				return WINDOWS_98_ALIAS;
			} else if (version.equals(WINDOWS_NT_VERSION)) {
				return WINDOWS_NT_ALIAS;
			} else if (version.equals(WINDOWS_2000_VERSION)) {
				return WINDOWS_2000_ALIAS;
			} else if (version.equals(WINDOWS_XP_VERSION)) {
				return WINDOWS_XP_ALIAS;
			} else if (version.equals(WINDOWS_SERVER_2003_VERSION)) {
				return WINDOWS_SERVER_2003_ALIAS;
			} else if (version.equals(WINDOWS_VISTA_VERSION)) {
				return WINDOWS_VISTA_ALIAS;
			} else if (version.equals(WINDOWS_7_VERSION)) {
				return WINDOWS_7_ALIAS;
			} else if (version.equals(WINDOWS_8_VERSION)) {
				return WINDOWS_8_ALIAS;
			} else {
				throw new UnidentifiableUserAgentException(
						"Unidentifiable OS version: " + type + ", " + version);
			}

		case IOS:
			return OSType.IOS.getName();

		case ANDROID:
			return OSType.ANDROID.getName();

		case NOT_AVAILABLE:
			return OSType.NOT_AVAILABLE.getName();

		default:
			throw new UnidentifiableUserAgentException(
					"Unidentifiable OS version: " + type + ", " + version);
		}
	}

	@Override
	public String toString() {
		return "OSInfo [type=" + type + ", version=" + version
				+ ", getAlias()=" + getAlias() + "]";
	}

}
