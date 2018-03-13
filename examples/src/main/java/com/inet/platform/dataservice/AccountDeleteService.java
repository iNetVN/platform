/*****************************************************************
   Copyright 2015 by Duyen Tang (tttduyen@inetcloud.vn)

   Licensed under the iNet Solutions Corp.,;
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.inetcloud.vn/licenses

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 *****************************************************************/
package com.inet.platform.dataservice;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.inet.platform.bo.HelloWorldAccountBO;
import com.inet.xportal.web.WebConstant;
import com.inet.xportal.web.action.AbstractBaseAction;
import com.inet.xportal.web.annotation.XPortalDataService;
import com.inet.xportal.web.annotation.XPortalPageRequest;
import com.inet.xportal.web.exception.WebOSBOException;
import com.inet.xportal.web.interfaces.DataServiceMarker;
import com.inet.xportal.web.interfaces.ObjectWebDataservice;
import com.inet.xportal.web.interfaces.WebDataService;
import com.inet.xportal.web.util.XParamUtils;

/**
 * AccountDeleteService.
 *
 * @author Duyen Tang
 * @version $Id: AccountDeleteService.java 2015-04-20 11:09:38z tttduyen $
 *
 * @since 1.0
 */
@Named("helloworld_account_delete")
@XPortalDataService(roles = { WebConstant.ROLE_USER }, description = "Delete account")
@XPortalPageRequest(uri = "helloworld/accounts/delete", 
				    inherit = true,
				    transaction = true, 
				    result = WebConstant.ACTION_XSTREAM_JSON_RESULT)
public class AccountDeleteService extends DataServiceMarker {
	@Inject
	private HelloWorldAccountBO accountBO;

	/*
	 * (non-Javadoc)
	 * @see com.inet.xportal.web.interfaces.DataServiceMarker#service(com.inet.xportal.web.action.AbstractBaseAction, java.util.Map)
	 */
	@Override
	protected WebDataService service(AbstractBaseAction action, Map<String, Object> params) throws WebOSBOException {
		String accountID = XParamUtils.getString("acountID", params);
		
		// remove account
		accountBO.remove(accountID);

		return new ObjectWebDataservice<>(accountID);
	}

}
