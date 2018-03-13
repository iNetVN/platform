How to build project:

1. initial project
   ------------------------------------------
   mvn eclipse:clean
   mvn eclipse:eclipse

2. Install external libraries(if necessary):
   -----------------------------------------
    // cloud library
     mvn install:install-file -DgroupId=com.inet -DartifactId=cloud-docx -Dversion=3.0 -Dpackaging=jar -Dfile=lib/cloud-docx-3.0.jar
     mvn install:install-file -DgroupId=com.inet -DartifactId=cloud-protocol -Dversion=1.0 -Dpackaging=jar -Dfile=lib/cloud-protocol-1.0.jar
     mvn install:install-file -DgroupId=com.inet -DartifactId=icloud-analysis-web -Dversion=2.0 -Dpackaging=jar -Dfile=lib/icloud-analysis-web-2.0.jar
     mvn install:install-file -DgroupId=com.inet -DartifactId=icloud-common -Dversion=1.0 -Dpackaging=jar -Dfile=lib/icloud-common-1.0.jar
     mvn install:install-file -DgroupId=com.inet -DartifactId=icloud-config -Dversion=3.0 -Dpackaging=jar -Dfile=lib/icloud-config-3.0.jar
     mvn install:install-file -DgroupId=com.inet -DartifactId=icloud-core -Dversion=4.0 -Dpackaging=jar -Dfile=lib/icloud-core-4.0.jar
     mvn install:install-file -DgroupId=com.inet -DartifactId=icloud-nosql-web -Dversion=4.0 -Dpackaging=jar -Dfile=lib/icloud-nosql-web-4.0.jar
     mvn install:install-file -DgroupId=com.inet -DartifactId=icloud-plugin -Dversion=3.0 -Dpackaging=jar -Dfile=lib/icloud-plugin-3.0.jar
     mvn install:install-file -DgroupId=com.inet -DartifactId=icloud-web -Dversion=4.0 -Dpackaging=jar -Dfile=lib/icloud-web-4.0.jar
     mvn install:install-file -DgroupId=com.inet -DartifactId=icloud-xdb -Dversion=3.5.0 -Dpackaging=jar -Dfile=lib/icloud-xdb-3.5.0.jar     
     mvn install:install-file -DgroupId=com.inet -DartifactId=unifiedpush-lib -Dversion=2.0 -Dpackaging=jar -Dfile=lib/unifiedpush-lib-2.0.jar
     
    // base library
    mvn install:install-file -DgroupId=com.inet -DartifactId=com.inet.base -Dversion=2.5.1.RELEASE -Dpackaging=jar -Dfile=lib/com.inet.base-2.5.1.RELEASE.jar
    mvn install:install-file -DgroupId=com.inet -DartifactId=com.inet.web -Dversion=2.5.1.RELEASE -Dpackaging=jar -Dfile=lib/com.inet.web-2.5.1.RELEASE.jar
 
3. Build project
   -------------
    mvn install package
    

4. More command for developer
   -------------
   mvn eclipse:clean
   mvn eclipse:eclipse
   
Contributors:
===
- Hien Nguyen <hiennguyen@inetcloud.vn>
- Tung Luong <lqtung@inetcloud.vn>
- Phong Tran <phongtt@inetcloud.vn>
- Vy Nguyen <ntvy@inetcloud.vn>
- Tan Truong <tntan@inetcloud.vn>
- Hanh Le <hanhld@inetcloud.vn>
- Duyen Tang <tttduyen@inetcloud.vn>
- Cong Nguyen <nbccong@inetcloud.vn>
- Thoang Tran <thoangtd@inetcloud.vn>
