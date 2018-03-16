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
import com.inet.xportal.nosql.web.bf.MagicContentBF;
import com.inet.xportal.nosql.web.bo.MagicContentBO;
import com.inet.xportal.nosql.web.data.SearchDTO;
import com.inet.xportal.web.context.ContentContext;
import com.inet.xportal.web.interfaces.BeanInitiateInvoke;
import com.inet.xportal.xdb.persistence.JSONDB;
import com.inet.xportal.xdb.query.impl.QueryImpl;

/**
 * HelloWorldAccountBO.
 *
 * @author Duyen Tang
 * @version $Id: AccountBo.java 2015-04-20 11:04:45z tttduyen $
 *
 * @since 1.0
 */
@Named("HelloWorldAccountBO")
public class HelloWorldAccountBO extends MagicContentBO<HelloWorldAccount>
    implements BeanInitiateInvoke {
  /**
   * Create {@link HelloWorldAccountBO} instance
   * 
   * @param contentBf the given {@link MagicContentBF}
   */
  @Inject
  protected HelloWorldAccountBO(@ContentContext(context = "HelloWorldContext") MagicContentBF contentBf) {
    super(contentBf, "account");
  }

  /**
   * Find {@link HelloWorldAccount} by name
   * 
   * @param name the given name
   * @return the result
   */
  public HelloWorldAccount findByName(String name) {
    QueryImpl<JSONDB> query = new QueryImpl<>();
    query.field("name").equal(name);

    return load(query);
  }

  /**
   * Search {@link HelloWorldAccount} by given key with paging
   * 
   * @param key the given key
   * @param pageSize the page size
   * @param pageNumber the page number
   * @return the result
   */
  public SearchDTO<HelloWorldAccount> search(String key, int pageSize, int pageNumber) {
    final QueryImpl<JSONDB> query = new QueryImpl<JSONDB>();
    query.limit(pageSize);
    query.offset(pageNumber * pageSize);
    
    if (key != null && !"".equals(key)) {
      query.or(
          query.criteria("name").like(key),
          query.criteria("fullname").like(key),
          query.criteria("email").like(key)
        );
    }
    
    return query(query);
  }

  @Override
  protected Class<HelloWorldAccount> getClassConvetor() {
    return HelloWorldAccount.class;
  }

  @Override
  public void init() {
    // index this field to database to speed up data query
    ensureIndex("name");
  }
}
