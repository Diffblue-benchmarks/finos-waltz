package org.finos.waltz.model.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.scheduled_job.JobKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NamedSettingsDiffblueTest {
  /**
   * Test {@link NamedSettings#mkScheduledJobParamSetting(JobKey)}.
   *
   * <p>Method under test: {@link NamedSettings#mkScheduledJobParamSetting(JobKey)}
   */
  @Test
  @DisplayName("Test mkScheduledJobParamSetting(JobKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NamedSettings.mkScheduledJobParamSetting(JobKey)"})
  void testMkScheduledJobParamSetting() {
    // Arrange, Act and Assert
    assertEquals(
        "job.HIERARCHY_REBUILD_CHANGE_INITIATIVE.params",
        NamedSettings.mkScheduledJobParamSetting(JobKey.HIERARCHY_REBUILD_CHANGE_INITIATIVE));
  }
}
