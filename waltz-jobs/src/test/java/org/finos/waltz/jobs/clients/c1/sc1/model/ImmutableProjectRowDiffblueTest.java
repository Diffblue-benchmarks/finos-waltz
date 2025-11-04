package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.Test;

class ImmutableProjectRowDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableProjectRow#builder()}
   *   <li>{@link ImmutableProjectRow#endDate(Date)}
   *   <li>{@link ImmutableProjectRow#startDate(Date)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableProjectRow.Builder actualBuilderResult = ImmutableProjectRow.builder();
    ImmutableProjectRow.Builder actualEndDateResult = actualBuilderResult
        .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertSame(actualEndDateResult, actualEndDateResult
        .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test: {@link ImmutableProjectRow.Builder#applicationId(String)}
   */
  @Test
  void testBuilderApplicationId() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationId("42"));
  }

  /**
   * Method under test: {@link ImmutableProjectRow.Builder#applicationId(String)}
   */
  @Test
  void testBuilderApplicationId2() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();
    builderResult.startDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.applicationId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableProjectRow.Builder#applicationName(String)}
   */
  @Test
  void testBuilderApplicationName() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationName("Application Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableProjectRow.Builder#applicationName(String)}
   */
  @Test
  void testBuilderApplicationName2() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();
    builderResult.startDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.applicationName("Application Name"));
  }

  /**
   * Method under test: {@link ImmutableProjectRow.Builder#from(ProjectRow)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();
    ProjectRow instance = mock(ProjectRow.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult2);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.projectName()).thenReturn("Project Name");
    when(instance.projectObjectId()).thenReturn("42");
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");

    // Act
    ImmutableProjectRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).endDate();
    verify(instance).lifecyclePhase();
    verify(instance).projectName();
    verify(instance).projectObjectId();
    verify(instance).startDate();
    ImmutableProjectRow buildResult = builderResult.build();
    assertEquals("42", buildResult.applicationId());
    assertEquals("42", buildResult.projectObjectId());
    assertEquals("Application Name", buildResult.applicationName());
    assertEquals("Project Name", buildResult.projectName());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertSame(fromResult, buildResult.endDate());
    assertSame(fromResult2, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableProjectRow.Builder#from(ProjectRow)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();
    ProjectRow instance = mock(ProjectRow.class);
    when(instance.startDate()).thenThrow(new IllegalStateException("instance"));
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.projectName()).thenReturn("Project Name");
    when(instance.projectObjectId()).thenReturn("42");
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).lifecyclePhase();
    verify(instance).projectName();
    verify(instance).projectObjectId();
    verify(instance).startDate();
  }

  /**
   * Method under test: {@link ImmutableProjectRow.Builder#from(ProjectRow)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();
    ProjectRow instance = mock(ProjectRow.class);
    when(instance.endDate()).thenReturn(null);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.projectName()).thenReturn("Project Name");
    when(instance.projectObjectId()).thenReturn("42");
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");

    // Act
    ImmutableProjectRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).endDate();
    verify(instance).lifecyclePhase();
    verify(instance).projectName();
    verify(instance).projectObjectId();
    verify(instance).startDate();
    ImmutableProjectRow buildResult = builderResult.build();
    assertEquals("42", buildResult.applicationId());
    assertEquals("42", buildResult.projectObjectId());
    assertEquals("Application Name", buildResult.applicationName());
    assertEquals("Project Name", buildResult.projectName());
    assertNull(buildResult.endDate());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableProjectRow.Builder#from(ProjectRow)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();
    ProjectRow instance = mock(ProjectRow.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult);
    when(instance.startDate()).thenReturn(null);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.projectName()).thenReturn("Project Name");
    when(instance.projectObjectId()).thenReturn("42");
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");

    // Act
    ImmutableProjectRow.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).endDate();
    verify(instance).lifecyclePhase();
    verify(instance).projectName();
    verify(instance).projectObjectId();
    verify(instance).startDate();
    ImmutableProjectRow buildResult = builderResult.build();
    assertEquals("42", buildResult.applicationId());
    assertEquals("42", buildResult.projectObjectId());
    assertEquals("Application Name", buildResult.applicationName());
    assertEquals("Project Name", buildResult.projectName());
    assertNull(buildResult.startDate());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertSame(fromResult, buildResult.endDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableProjectRow.Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderLifecyclePhase() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test:
   * {@link ImmutableProjectRow.Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderLifecyclePhase2() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();
    builderResult.startDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test: {@link ImmutableProjectRow.Builder#projectName(String)}
   */
  @Test
  void testBuilderProjectName() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.projectName("Project Name"));
  }

  /**
   * Method under test: {@link ImmutableProjectRow.Builder#projectName(String)}
   */
  @Test
  void testBuilderProjectName2() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();
    builderResult.startDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.projectName("Project Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableProjectRow.Builder#projectObjectId(String)}
   */
  @Test
  void testBuilderProjectObjectId() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.projectObjectId("42"));
  }

  /**
   * Method under test:
   * {@link ImmutableProjectRow.Builder#projectObjectId(String)}
   */
  @Test
  void testBuilderProjectObjectId2() {
    // Arrange
    ImmutableProjectRow.Builder builderResult = ImmutableProjectRow.builder();
    builderResult.startDate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.projectObjectId("42"));
  }

  /**
   * Method under test: {@link ImmutableProjectRow#copyOf(ProjectRow)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ProjectRow instance = mock(ProjectRow.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult2);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.projectName()).thenReturn("Project Name");
    when(instance.projectObjectId()).thenReturn("42");
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");

    // Act
    ImmutableProjectRow actualCopyOfResult = ImmutableProjectRow.copyOf(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).endDate();
    verify(instance).lifecyclePhase();
    verify(instance).projectName();
    verify(instance).projectObjectId();
    verify(instance).startDate();
    assertEquals("42", actualCopyOfResult.applicationId());
    assertEquals("42", actualCopyOfResult.projectObjectId());
    assertEquals("Application Name", actualCopyOfResult.applicationName());
    assertEquals("Project Name", actualCopyOfResult.projectName());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertSame(fromResult, actualCopyOfResult.endDate());
    assertSame(fromResult2, actualCopyOfResult.startDate());
  }

  /**
   * Method under test: {@link ImmutableProjectRow#copyOf(ProjectRow)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ProjectRow instance = mock(ProjectRow.class);
    when(instance.endDate()).thenReturn(null);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.projectName()).thenReturn("Project Name");
    when(instance.projectObjectId()).thenReturn("42");
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");

    // Act
    ImmutableProjectRow actualCopyOfResult = ImmutableProjectRow.copyOf(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).endDate();
    verify(instance).lifecyclePhase();
    verify(instance).projectName();
    verify(instance).projectObjectId();
    verify(instance).startDate();
    assertEquals("42", actualCopyOfResult.applicationId());
    assertEquals("42", actualCopyOfResult.projectObjectId());
    assertEquals("Application Name", actualCopyOfResult.applicationName());
    assertEquals("Project Name", actualCopyOfResult.projectName());
    assertNull(actualCopyOfResult.endDate());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertSame(fromResult, actualCopyOfResult.startDate());
  }

  /**
   * Method under test: {@link ImmutableProjectRow#copyOf(ProjectRow)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ProjectRow instance = mock(ProjectRow.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult);
    when(instance.startDate()).thenReturn(null);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.projectName()).thenReturn("Project Name");
    when(instance.projectObjectId()).thenReturn("42");
    when(instance.applicationName()).thenReturn("Application Name");
    when(instance.applicationId()).thenReturn("42");

    // Act
    ImmutableProjectRow actualCopyOfResult = ImmutableProjectRow.copyOf(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).endDate();
    verify(instance).lifecyclePhase();
    verify(instance).projectName();
    verify(instance).projectObjectId();
    verify(instance).startDate();
    assertEquals("42", actualCopyOfResult.applicationId());
    assertEquals("42", actualCopyOfResult.projectObjectId());
    assertEquals("Application Name", actualCopyOfResult.applicationName());
    assertEquals("Project Name", actualCopyOfResult.projectName());
    assertNull(actualCopyOfResult.startDate());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertSame(fromResult, actualCopyOfResult.endDate());
  }
}
