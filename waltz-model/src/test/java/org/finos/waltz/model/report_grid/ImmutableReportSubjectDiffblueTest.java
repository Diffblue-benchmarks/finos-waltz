package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.Test;

class ImmutableReportSubjectDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableReportSubject.Builder#entityReference(EntityReference)}
   */
  @Test
  void testBuilderEntityReference() {
    // Arrange
    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableReportSubject.Builder#from(ReportSubject)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    ReportSubject instance = mock(ReportSubject.class);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableReportSubject.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lifecyclePhase();
    assertEquals(LifecyclePhase.PRODUCTION, actualFromResult.build().lifecyclePhase());
    assertEquals(LifecyclePhase.PRODUCTION, builderResult.build().lifecyclePhase());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableReportSubject.Builder#from(ReportSubject)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();
    ReportSubject instance = mock(ReportSubject.class);
    when(instance.lifecyclePhase()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).lifecyclePhase();
  }

  /**
   * Method under test:
   * {@link ImmutableReportSubject.Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderLifecyclePhase() {
    // Arrange
    ImmutableReportSubject.Builder builderResult = ImmutableReportSubject.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test: {@link ImmutableReportSubject#copyOf(ReportSubject)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportSubject instance = mock(ReportSubject.class);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    ImmutableReportSubject actualCopyOfResult = ImmutableReportSubject.copyOf(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lifecyclePhase();
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
  }

  /**
   * Method under test:
   * {@link ImmutableReportSubject#fromJson(ImmutableReportSubject.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReportSubject.Json json = new ImmutableReportSubject.Json();
    json.setEntityReference(mock(EntityReference.class));
    json.setLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Act
    ImmutableReportSubject actualFromJsonResult = ImmutableReportSubject.fromJson(json);

    // Assert
    assertEquals(LifecyclePhase.PRODUCTION, actualFromJsonResult.lifecyclePhase());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Method under test: {@link ImmutableReportSubject.Json#entityReference()}
   */
  @Test
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportSubject.Json()).entityReference());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableReportSubject.Json}
   *   <li>{@link ImmutableReportSubject.Json#setEntityReference(EntityReference)}
   *   <li>{@link ImmutableReportSubject.Json#setLifecyclePhase(LifecyclePhase)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableReportSubject.Json actualJson = new ImmutableReportSubject.Json();
    actualJson.setEntityReference(null);
    actualJson.setLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertNull(actualJson.entityReference);
    assertEquals(LifecyclePhase.PRODUCTION, actualJson.lifecyclePhase);
  }

  /**
   * Method under test: {@link ImmutableReportSubject.Json#lifecyclePhase()}
   */
  @Test
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportSubject.Json()).lifecyclePhase());
  }
}
