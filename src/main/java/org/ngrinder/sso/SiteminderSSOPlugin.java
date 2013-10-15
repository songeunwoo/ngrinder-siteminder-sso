package org.ngrinder.sso;

import java.util.Map;

import net.grinder.util.NoOp;

import org.ngrinder.extension.OnLoginRunnable;
import org.ngrinder.model.Role;
import org.ngrinder.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;

public class SiteminderSSOPlugin implements OnLoginRunnable {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(SiteminderSSOPlugin.class);

	SiteminderSSOPlugin() {
	}

	@Override
	public User loadUser(final String userId) {
		Map<String, String> map = SiteMinderFilter.threadStorage.get();
		User user = null;
		if (map != null) {
			user = new User();
			user.setUserId(userId);
			user.setUserName(getString(map, "name", ""));
			user.setEmail(getString(map, "email", ""));
			user.setMobilePhone(getString(map, "cellphone", ""));
			user.setAuthProviderClass(SiteminderSSOPlugin.this.getClass().getName());
			user.setEnabled(true);
			user.setExternal(true);
			user.setRole(Role.USER);
			SiteMinderFilter.threadStorage.remove();
		}
		return user;
	}

	private String getString(Map<String, String> map, String key, String defaultValue) {
		String value = map.get(key);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	@Override
	public boolean validateUser(String userId, String password, String encPass, Object encoder, Object salt) {
		throw new BadCredentialsException("no validation is permitted");
	}

	@Override
	public void saveUser(User user) {
		NoOp.noOp();
	}
}
