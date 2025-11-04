package org.finos.waltz.model.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.waltz.model.scheduled_job.JobKey;
import org.junit.jupiter.api.Test;

class NamedSettingsDiffblueTest {
  /**
   * Method under test: {@link NamedSettings#mkScheduledJobParamSetting(JobKey)}
   */
  @Test
  void testMkScheduledJobParamSetting() {
    // Arrange, Act and Assert
    assertEquals("job.HIERARCHY_REBUILD_CHANGE_INITIATIVE.params",
        NamedSettings.mkScheduledJobParamSetting(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE));
  }
}
