'use strict';

angular.module('gpromoteApp.cookiesServices', [])
.factory('Cookies', function () {

	return {
		/**
		 * Fetches a cookie value directly from the DOM document.
		 * @param cookieKey The key of the cookie value to fetch.
		 * @returns {*} Either the cookie value or "null" if no value matching the specfied key could be found.
		 */
		
		getFromDocument: function (cookieKey) {
			
			if (!cookieKey) {
				console.log("cookies null"  );
				return null;
			}
			return decodeURIComponent(document.cookie
					.replace(new RegExp("(?:(?:^|.*;)\\s*" + encodeURIComponent(cookieKey)
						.replace(/[\-\.\+\*]/g, "\\$&") + "\\s*\\=\\s*([^;]*).*$)|^.*$"), "$1")) || null;
		}
	};
});