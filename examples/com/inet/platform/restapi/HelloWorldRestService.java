/*****************************************************************
   Copyright 2015 by Hien Nguyen (hiennguyen@inetcloud.vn)

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
package com.inet.platform.restapi;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.inet.platform.bo.HelloWorldAccountBO;
import com.inet.platform.model.HelloWorldAccount;
import com.inet.xportal.nosql.web.data.SearchDTO;
import com.inet.xportal.web.WebConstant;
import com.inet.xportal.web.annotation.XPortalRESTfulRequest;
import com.inet.xportal.web.interfaces.RESTfulServiceMarker;

/**
 * 
 * HelloWorldRestService.
 *
 * @author Hien Nguyen
 * @version $Id: HelloWorldRestService.java Feb 28, 2018 1:57:14 PM $
 *
 * @since 1.0
 */
@Path("/helloworld")
@XPortalRESTfulRequest(secure = WebConstant.ROLE_USER)
public class HelloWorldRestService extends RESTfulServiceMarker {
	@Inject
	private HelloWorldAccountBO accountBO;
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	@GET
	@Path("/query/{path}")
	@Produces("application/json")
	public SearchDTO<HelloWorldAccount> getdata(@PathParam("path") String path) {
		SearchDTO<HelloWorldAccount> result = accountBO.query();
		if (result == null)
			result = new SearchDTO<>();
		return result;
	}
}
