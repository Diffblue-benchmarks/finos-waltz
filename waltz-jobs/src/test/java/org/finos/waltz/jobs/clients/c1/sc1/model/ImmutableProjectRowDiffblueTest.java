package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.finos.waltz.jobs.clients.c1.sc1.model.ImmutableProjectRow.Builder;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableProjectRowDiffblueTest {
  /**
   * Test {@link ImmutableProjectRow#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableProjectRow#builder()}
   *   <li>{@link ImmutableProjectRow#endDate(Date)}
   *   <li>{@link ImmutableProjectRow#startDate(Date)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableProjectRow Builder.build()", "Builder Builder.endDate(Date)",
      "Builder Builder.startDate(Date)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableProjectRow.builder();
    Builder actualEndDateResult = actualBuilderResult
        .endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertSame(actualEndDateResult, actualEndDateResult
        .startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Test Builder {@link Builder#applicationId(String)}.
   * <p>
   * Method under test: {@link Builder#applicationId(String)}
   */
  @Test
  @DisplayName("Test Builder applicationId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationId(String)"})
  void testBuilderApplicationId() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationId("42"));
  }

  /**
   * Test Builder {@link Builder#applicationName(String)}.
   * <p>
   * Method under test: {@link Builder#applicationName(String)}
   */
  @Test
  @DisplayName("Test Builder applicationName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationName(String)"})
  void testBuilderApplicationName() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationName("Application Name"));
  }

  /**
   * Test Builder {@link Builder#from(ProjectRow)}.
   * <p>
   * Method under test: {@link Builder#from(ProjectRow)}
   */
  @Test
  @DisplayName("Test Builder from(ProjectRow)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProjectRow)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();
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
    builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).endDate();
    verify(instance).lifecyclePhase();
    verify(instance).projectName();
    verify(instance).projectObjectId();
    verify(instance).startDate();
    ImmutableProjectRow buildResult = builderResult.build();
    assertSame(fromResult, buildResult.endDate());
    assertSame(fromResult2, buildResult.startDate());
  }

  /**
   * Test Builder {@link Builder#from(ProjectRow)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProjectRow)}
   */
  @Test
  @DisplayName("Test Builder from(ProjectRow); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProjectRow)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();
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
   * Test Builder {@link Builder#from(ProjectRow)}.
   * <ul>
   *   <li>When {@link ProjectRow} {@link ProjectRow#endDate()} return {@code null}.</li>
   *   <li>Then return build endDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProjectRow)}
   */
  @Test
  @DisplayName("Test Builder from(ProjectRow); when ProjectRow endDate() return 'null'; then return build endDate is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProjectRow)"})
  void testBuilderFrom_whenProjectRowEndDateReturnNull_thenReturnBuildEndDateIsNull() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();
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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).endDate();
    verify(instance).lifecyclePhase();
    verify(instance).projectName();
    verify(instance).projectObjectId();
    verify(instance).startDate();
    assertNull(actualFromResult.build().endDate());
    ImmutableProjectRow buildResult = builderResult.build();
    assertNull(buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
  }

  /**
   * Test Builder {@link Builder#from(ProjectRow)}.
   * <ul>
   *   <li>When {@link ProjectRow} {@link ProjectRow#startDate()} return {@code null}.</li>
   *   <li>Then return build startDate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProjectRow)}
   */
  @Test
  @DisplayName("Test Builder from(ProjectRow); when ProjectRow startDate() return 'null'; then return build startDate is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProjectRow)"})
  void testBuilderFrom_whenProjectRowStartDateReturnNull_thenReturnBuildStartDateIsNull() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();
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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationId();
    verify(instance).applicationName();
    verify(instance).endDate();
    verify(instance).lifecyclePhase();
    verify(instance).projectName();
    verify(instance).projectObjectId();
    verify(instance).startDate();
    assertNull(actualFromResult.build().startDate());
    ImmutableProjectRow buildResult = builderResult.build();
    assertNull(buildResult.startDate());
    assertSame(fromResult, buildResult.endDate());
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   * <p>
   * Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Test Builder {@link Builder#projectName(String)}.
   * <p>
   * Method under test: {@link Builder#projectName(String)}
   */
  @Test
  @DisplayName("Test Builder projectName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.projectName(String)"})
  void testBuilderProjectName() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.projectName("Project Name"));
  }

  /**
   * Test Builder {@link Builder#projectObjectId(String)}.
   * <p>
   * Method under test: {@link Builder#projectObjectId(String)}
   */
  @Test
  @DisplayName("Test Builder projectObjectId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.projectObjectId(String)"})
  void testBuilderProjectObjectId() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.projectObjectId("42"));
  }
}
