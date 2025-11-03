package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.report_grid.ReportSubject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class KeyCellDiffblueTest {
  /**
   * Test {@link KeyCell#fromSubject(ReportSubject)}.
   * <p>
   * Method under test: {@link KeyCell#fromSubject(ReportSubject)}
   */
  @Test
  @DisplayName("Test fromSubject(ReportSubject)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"KeyCell KeyCell.fromSubject(ReportSubject)"})
  void testFromSubject() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.externalId()).thenReturn(ofResult);
    when(entityReference.id()).thenReturn(1L);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult2);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    ReportSubject subject = mock(ReportSubject.class);
    when(subject.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(subject.entityReference()).thenReturn(entityReference);

    // Act
    KeyCell actualFromSubjectResult = KeyCell.fromSubject(subject);

    // Assert
    verify(entityReference).externalId();
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(entityReference).name();
    verify(subject, atLeast(1)).entityReference();
    verify(subject).lifecyclePhase();
    assertTrue(actualFromSubjectResult instanceof ImmutableKeyCell);
    assertEquals(EntityKind.ALL, actualFromSubjectResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualFromSubjectResult.lifecyclePhase());
    assertEquals(ApiTypes.KEYCELL, actualFromSubjectResult.type());
  }
}
