package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.report_grid.ImmutableReportSubject;
import org.finos.waltz.model.report_grid.ImmutableReportSubject.Builder;
import org.finos.waltz.model.report_grid.ReportSubject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KeyCellDiffblueTest {
  /**
   * Test {@link KeyCell#type()}.
   *
   * <p>Method under test: {@link KeyCell#type()}
   */
  @Test
  @DisplayName("Test type()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String KeyCell.type()"})
  void testType() {
    // Arrange, Act and Assert
    assertEquals(
        "Type",
        ImmutableKeyCell.builder()
            .externalId("42")
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .type("Type")
            .waltzId(1L)
            .build()
            .type());
  }

  /**
   * Test {@link KeyCell#fromSubject(ReportSubject)}.
   *
   * <p>Method under test: {@link KeyCell#fromSubject(ReportSubject)}
   */
  @Test
  @DisplayName("Test fromSubject(ReportSubject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KeyCell KeyCell.fromSubject(ReportSubject)"})
  void testFromSubject() {
    // Arrange
    Builder builderResult = ImmutableReportSubject.builder();
    ImmutableReportSubject subject =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .build();

    // Act
    KeyCell actualFromSubjectResult = KeyCell.fromSubject(subject);

    // Assert
    assertTrue(actualFromSubjectResult instanceof ImmutableKeyCell);
    assertEquals(EntityKind.ALL, actualFromSubjectResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualFromSubjectResult.lifecyclePhase());
    assertEquals(ApiTypes.KEYCELL, actualFromSubjectResult.type());
  }
}
