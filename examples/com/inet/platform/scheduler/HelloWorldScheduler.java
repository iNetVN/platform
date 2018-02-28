/*****************************************************************
   Copyright 2018 by Hien Nguyen (hiennguyen@inetcloud.vn)

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
package com.inet.platform.scheduler;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

import com.inet.platform.bo.HelloWorldAccountBO;
import com.inet.xportal.nosql.web.scheduler.SchedulerBizBase;
import com.inet.xportal.web.annotation.XPortalCronExpression;

import net.sf.json.JSONObject;

/**
 * HelloWorldScheduler.
 * 
 * This scheduler will be started everyday at 1 AM
 * 
 * PURPOSE:
 * Just an example of scheduler implementation
 * 
 * @author Hien Nguyen
 * @version $Id: HelloWorldScheduler.java Feb 28, 2018 1:38:19 PM $
 *
 * @since 1.0
 */
@Named("HelloWorldScheduler")
@Default
@XPortalCronExpression(expression = "0 0 1 * * ? *")
public class HelloWorldScheduler extends SchedulerBizBase {
	@Inject
	private HelloWorldAccountBO accountBO;
	
	/*
	 * (non-Javadoc)
	 * @see com.inet.xportal.nosql.web.scheduler.SchedulerBizBase#biz(net.sf.json.JSONObject)
	 */
	@Override
    protected void biz(JSONObject parameter) 
	{
		// count the account datbase
		System.out.println(accountBO.count());
    }
}
