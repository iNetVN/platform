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
package com.inet.platform.bo;

import javax.inject.Inject;
import javax.inject.Named;

import com.inet.platform.model.HelloWorldAccount;
import com.inet.platform.model.HelloWorldAccount;
import com.inet.xportal.nosql.web.bf.MagicContentBF;
import com.inet.xportal.nosql.web.bo.MagicContentBO;
import com.inet.xportal.web.context.ContentContext;
import com.inet.xportal.web.interfaces.BeanInitiateInvoke;

/**
 * HelloWorldAccountBO.
 *
 * @author Duyen Tang
 * @version $Id: AccountBo.java 2015-04-20 11:04:45z tttduyen $
 *
 * @since 1.0
 */
@Named("HelloWorldAccountBO")
public class HelloWorldAccountBO extends MagicContentBO<HelloWorldAccount> implements BeanInitiateInvoke {
	/**
	 * Create {@link HelloWorldAccountBO} instance
	 * 
	 * @param contentBf
	 *            the given {@link MagicContentBF}
	 */
	@Inject
	protected HelloWorldAccountBO(@ContentContext(context = "HelloWorldContext") MagicContentBF contentBf) {
		super(contentBf, "account");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.inet.xportal.nosql.web.bo.SQLMagicBase#getClassConvetor()
	 */
	@Override
	protected Class<HelloWorldAccount> getClassConvetor() {
		return HelloWorldAccount.class;
	}

	/*
	 * (non-Javadoc)
	 * @see com.inet.xportal.web.interfaces.BeanInitiateInvoke#init()
	 */
	@Override
	public void init() {
		// index this field to database to speed up data query
		ensureIndex("name");
	}
}
