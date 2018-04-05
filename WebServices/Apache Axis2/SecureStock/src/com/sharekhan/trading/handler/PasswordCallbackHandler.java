package com.sharekhan.trading.handler;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class PasswordCallbackHandler implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		WSPasswordCallback callback = null;
		String username = null;
		String password = null;

		for (int i = 0; i < callbacks.length; i++) {
			callback = (WSPasswordCallback) callbacks[i];
			if (callback.getUsage() == WSPasswordCallback.USERNAME_TOKEN_UNKNOWN) {
				username = callback.getIdentifier();
				password = callback.getPassword();

				// connect to db
				if (username.equals("john") && password.equals("welcome1")) {
					return;
				} else {
					throw new UnsupportedCallbackException(callback,
							"username/password is not valid");
				}
			}
		}

	}

}
