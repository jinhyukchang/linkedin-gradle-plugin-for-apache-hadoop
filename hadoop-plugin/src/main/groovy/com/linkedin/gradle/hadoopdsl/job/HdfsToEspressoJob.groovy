package com.linkedin.gradle.hadoopdsl.job;

import com.linkedin.gradle.hadoopdsl.NamedScope;

/**
 * Job class for type=hdfsToEspressoJob jobs.
 *
 * <p>
 * These are documented internally at LinkedIn at https://iwww.corp.linkedin.com/wiki/cf/pages/viewpage.action?pageId=145670487
 * This is the job type to move data from HDFS to Espresso
 * <p>
 * In the DSL, a HdfsToEspressoJob can be specified with:
 * <pre>
 *   hdfsToEspressoJob('jobName') {
 *     qps 1000                        //Required
 *     sourceHdfsPath '/job/data/src'  //Required
 *     espressoEndpoint 'www.foo.bar'  //Required
 *     espressoDatabaseName 'Account'  //Required
 *     espressoTableName 'Person'      //Required
 *     espressoContentType 'JSON/TEXT' //Required
 *     espressoKey 'id'                //Required
 *     espressoSubkeys 'sub_id,name'   //Optional
 *     espressoOperation 'put'         //Required
 *     errorHdfsPath '/job/data/err'   //Required
 *     set properties: [
 *       'force.error.overwrite' : true,
 *       'propertyName1' : 'propertyValue1',
 *       'propertyName2' : 'propertyValue2',
 *     ]
 *   }
 * </pre>
 */
class HdfsToEspressoJob extends Job {
  int qps;
  String sourceHdfsPath;
  String espressoEndpoint;
  String espressoDatabaseName;
  String espressoTableName;
  String espressoContentType;
  String espressoKey;
  String espressoSubkeys;
  String espressoOperation;
  String errorHdfsPath;

  public HdfsToEspressoJob(String jobName) {
    super(jobName);
    setJobProperty("type", "hdfsToEspresso");
  }

  void qps(int qps) {
    this.qps = qps;
    setJobProperty("espresso.qps", qps);
  }

  void sourceHdfsPath(String sourceHdfsPath) {
    this.sourceHdfsPath = sourceHdfsPath;
    setJobProperty("input.paths", sourceHdfsPath);
  }

  void espressoEndpoint(String espressoEndpoint) {
    this.espressoEndpoint = espressoEndpoint;
    setJobProperty("espresso.endpoint", espressoEndpoint);
  }

  void espressoDatabaseName(String espressoDatabaseName) {
    this.espressoDatabaseName = espressoDatabaseName;
    setJobProperty("espresso.database", espressoDatabaseName);
  }

  void espressoTableName(String espressoTableName) {
    this.espressoTableName = espressoTableName;
    setJobProperty("espresso.table", espressoTableName);
  }

  void espressoContentType(String espressoContentType) {
    this.espressoContentType = espressoContentType;
    setJobProperty("espresso.content.type", espressoContentType);
  }

  void espressoKey(String espressoKey) {
    this.espressoKey = espressoKey;
    setJobProperty("espresso.key", espressoKey);
  }

  void espressoSubkeys(String espressoSubkeys) {
    this.espressoSubkeys = espressoSubkeys;
    setJobProperty("espresso.subkeys", espressoSubkeys);
  }

  void espressoOperation(String espressoOperation) {
    this.espressoOperation = espressoOperation;
    setJobProperty("espresso.operation", espressoOperation);
  }

  void errorHdfsPath(String errorHdfsPath) {
    this.errorHdfsPath = errorHdfsPath;
    setJobProperty("error.path", errorHdfsPath);
  }

  /**
   * Clones the job.
   *
   * @return The cloned job
   */
  @Override
  HdfsToEspressoJob clone() {
    return clone(new HdfsToEspressoJob(name));
  }

  /**
   * Helper method to set the properties on a cloned job.
   * @param cloneJob The job being cloned
   * @return The cloned job
   */
  HdfsToEspressoJob clone(HdfsToEspressoJob cloneJob) {
    cloneJob.qps = qps;
    cloneJob.sourceHdfsPath = sourceHdfsPath;
    cloneJob.espressoEndpoint = espressoEndpoint;
    cloneJob.espressoDatabaseName = espressoDatabaseName;
    cloneJob.espressoTableName = espressoTableName;
    cloneJob.espressoContentType = espressoContentType;
    cloneJob.espressoKey = espressoKey;
    cloneJob.espressoSubkeys = espressoSubkeys;
    cloneJob.espressoOperation = espressoOperation;
    cloneJob.errorHdfsPath = errorHdfsPath;
    return super.clone(cloneJob);
  }
}
