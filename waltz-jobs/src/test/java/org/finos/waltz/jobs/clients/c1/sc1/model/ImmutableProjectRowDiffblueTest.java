package org.finos.waltz.jobs.clients.c1.sc1.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test Builder {@link Builder#applicationId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationId(String)}
   */
  @Test
  @DisplayName("Test Builder applicationId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationId(String)"})
  void testBuilderApplicationId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    // Act
    Builder actualApplicationIdResult = builderResult.applicationId("42");

    // Assert
    assertSame(builderResult, actualApplicationIdResult);
  }

  /**
   * Test Builder {@link Builder#applicationName(String)}.
   *
   * <ul>
   *   <li>When {@code Application Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationName(String)}
   */
  @Test
  @DisplayName("Test Builder applicationName(String); when 'Application Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationName(String)"})
  void testBuilderApplicationName_whenApplicationName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    // Act
    Builder actualApplicationNameResult = builderResult.applicationName("Application Name");

    // Assert
    assertSame(builderResult, actualApplicationNameResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#endDate(Date)}
   *   <li>{@link Builder#startDate(Date)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProjectRow Builder.build()",
    "Builder Builder.endDate(Date)",
    "Builder Builder.startDate(Date)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualApplicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");
    Date endDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    Builder actualProjectObjectIdResult =
        actualApplicationNameResult
            .endDate(endDate)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ImmutableProjectRow actualImmutableProjectRow =
        actualProjectObjectIdResult.startDate(startDate).build();

    // Assert
    assertEquals("42", actualImmutableProjectRow.applicationId());
    assertEquals("42", actualImmutableProjectRow.projectObjectId());
    assertEquals("Application Name", actualImmutableProjectRow.applicationName());
    assertEquals("Project Name", actualImmutableProjectRow.projectName());
    assertEquals(LifecyclePhase.PRODUCTION, actualImmutableProjectRow.lifecyclePhase());
    assertSame(endDate, actualImmutableProjectRow.endDate());
    assertSame(startDate, actualImmutableProjectRow.startDate());
  }

  /**
   * Test Builder {@link Builder#from(ProjectRow)}.
   *
   * <p>Method under test: {@link Builder#from(ProjectRow)}
   */
  @Test
  @DisplayName("Test Builder from(ProjectRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProjectRow)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow instance =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableProjectRow actualImmutableProjectRow = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableProjectRow);
    ImmutableProjectRow actualImmutableProjectRow2 = builderResult.build();
    assertEquals(instance, actualImmutableProjectRow2);
  }

  /**
   * Test Builder {@link Builder#from(ProjectRow)}.
   *
   * <p>Method under test: {@link Builder#from(ProjectRow)}
   */
  @Test
  @DisplayName("Test Builder from(ProjectRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProjectRow)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    Builder projectObjectIdResult =
        ImmutableProjectRow.builder()
            .applicationId("42")
            .applicationName("Application Name")
            .endDate(null)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow instance =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    ImmutableProjectRow actualImmutableProjectRow = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableProjectRow);
    ImmutableProjectRow actualImmutableProjectRow2 = builderResult.build();
    assertEquals(instance, actualImmutableProjectRow2);
  }

  /**
   * Test Builder {@link Builder#from(ProjectRow)}.
   *
   * <p>Method under test: {@link Builder#from(ProjectRow)}
   */
  @Test
  @DisplayName("Test Builder from(ProjectRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProjectRow)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");
    ImmutableProjectRow instance =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42")
            .startDate(null)
            .build();

    // Act and Assert
    ImmutableProjectRow actualImmutableProjectRow = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableProjectRow);
    ImmutableProjectRow actualImmutableProjectRow2 = builderResult.build();
    assertEquals(instance, actualImmutableProjectRow2);
  }

  /**
   * Test Builder {@link Builder#lifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test Builder lifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lifecyclePhase(LifecyclePhase)"})
  void testBuilderLifecyclePhase() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    // Act
    Builder actualLifecyclePhaseResult = builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(builderResult, actualLifecyclePhaseResult);
  }

  /**
   * Test Builder {@link Builder#projectName(String)}.
   *
   * <ul>
   *   <li>When {@code Project Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#projectName(String)}
   */
  @Test
  @DisplayName("Test Builder projectName(String); when 'Project Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.projectName(String)"})
  void testBuilderProjectName_whenProjectName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    // Act
    Builder actualProjectNameResult = builderResult.projectName("Project Name");

    // Assert
    assertSame(builderResult, actualProjectNameResult);
  }

  /**
   * Test Builder {@link Builder#projectObjectId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#projectObjectId(String)}
   */
  @Test
  @DisplayName("Test Builder projectObjectId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.projectObjectId(String)"})
  void testBuilderProjectObjectId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProjectRow.builder();

    // Act
    Builder actualProjectObjectIdResult = builderResult.projectObjectId("42");

    // Assert
    assertSame(builderResult, actualProjectObjectIdResult);
  }

  /**
   * Test {@link ImmutableProjectRow#copyOf(ProjectRow)}.
   *
   * <ul>
   *   <li>Then return applicationId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#copyOf(ProjectRow)}
   */
  @Test
  @DisplayName("Test copyOf(ProjectRow); then return applicationId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.copyOf(ProjectRow)"})
  void testCopyOf_thenReturnApplicationIdIs42() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow instance =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableProjectRow actualCopyOfResult = ImmutableProjectRow.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.applicationId());
    assertEquals("42", actualCopyOfResult.projectObjectId());
    assertEquals("Application Name", actualCopyOfResult.applicationName());
    assertEquals("Project Name", actualCopyOfResult.projectName());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableProjectRow#equals(Object)}, and {@link ImmutableProjectRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProjectRow#equals(Object)}
   *   <li>{@link ImmutableProjectRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProjectRow.equals(Object)",
    "int ImmutableProjectRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder applicationNameResult2 =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult2 =
        applicationNameResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow2 =
        projectObjectIdResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    assertEquals(immutableProjectRow, immutableProjectRow2);
    assertEquals(immutableProjectRow.hashCode(), immutableProjectRow2.hashCode());
  }

  /**
   * Test {@link ImmutableProjectRow#equals(Object)}, and {@link ImmutableProjectRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProjectRow#equals(Object)}
   *   <li>{@link ImmutableProjectRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProjectRow.equals(Object)",
    "int ImmutableProjectRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act and Assert
    assertEquals(immutableProjectRow, immutableProjectRow);
    int expectedHashCodeResult = immutableProjectRow.hashCode();
    assertEquals(expectedHashCodeResult, immutableProjectRow.hashCode());
  }

  /**
   * Test {@link ImmutableProjectRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProjectRow.equals(Object)",
    "int ImmutableProjectRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder()
            .applicationId("Application Name")
            .applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder applicationNameResult2 =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult2 =
        applicationNameResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act and Assert
    assertNotEquals(
        immutableProjectRow,
        projectObjectIdResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableProjectRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProjectRow.equals(Object)",
    "int ImmutableProjectRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("42");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder applicationNameResult2 =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult2 =
        applicationNameResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act and Assert
    assertNotEquals(
        immutableProjectRow,
        projectObjectIdResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableProjectRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProjectRow.equals(Object)",
    "int ImmutableProjectRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder applicationNameResult2 =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult2 =
        applicationNameResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act and Assert
    assertNotEquals(
        immutableProjectRow,
        projectObjectIdResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableProjectRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProjectRow.equals(Object)",
    "int ImmutableProjectRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder applicationNameResult2 =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult2 =
        applicationNameResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act and Assert
    assertNotEquals(
        immutableProjectRow,
        projectObjectIdResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableProjectRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProjectRow.equals(Object)",
    "int ImmutableProjectRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("42")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder applicationNameResult2 =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult2 =
        applicationNameResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act and Assert
    assertNotEquals(
        immutableProjectRow,
        projectObjectIdResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableProjectRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProjectRow.equals(Object)",
    "int ImmutableProjectRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("Application Name");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder applicationNameResult2 =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult2 =
        applicationNameResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act and Assert
    assertNotEquals(
        immutableProjectRow,
        projectObjectIdResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableProjectRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProjectRow.equals(Object)",
    "int ImmutableProjectRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    Builder applicationNameResult2 =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult2 =
        applicationNameResult2
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act and Assert
    assertNotEquals(
        immutableProjectRow,
        projectObjectIdResult2
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build());
  }

  /**
   * Test {@link ImmutableProjectRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProjectRow.equals(Object)",
    "int ImmutableProjectRow.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act and Assert
    assertNotEquals(
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableProjectRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProjectRow.equals(Object)",
    "int ImmutableProjectRow.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act and Assert
    assertNotEquals(
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build(),
        "Different type to ImmutableProjectRow");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProjectRow#toString()}
   *   <li>{@link ImmutableProjectRow#applicationId()}
   *   <li>{@link ImmutableProjectRow#applicationName()}
   *   <li>{@link ImmutableProjectRow#endDate()}
   *   <li>{@link ImmutableProjectRow#lifecyclePhase()}
   *   <li>{@link ImmutableProjectRow#projectName()}
   *   <li>{@link ImmutableProjectRow#projectObjectId()}
   *   <li>{@link ImmutableProjectRow#startDate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableProjectRow.applicationId()",
    "String ImmutableProjectRow.applicationName()",
    "Date ImmutableProjectRow.endDate()",
    "LifecyclePhase ImmutableProjectRow.lifecyclePhase()",
    "String ImmutableProjectRow.projectName()",
    "String ImmutableProjectRow.projectObjectId()",
    "Date ImmutableProjectRow.startDate()",
    "String ImmutableProjectRow.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");
    Date endDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(endDate)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    Date startDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    ImmutableProjectRow immutableProjectRow = projectObjectIdResult.startDate(startDate).build();

    // Act
    immutableProjectRow.toString();
    String actualApplicationIdResult = immutableProjectRow.applicationId();
    String actualApplicationNameResult = immutableProjectRow.applicationName();
    Date actualEndDateResult = immutableProjectRow.endDate();
    LifecyclePhase actualLifecyclePhaseResult = immutableProjectRow.lifecyclePhase();
    String actualProjectNameResult = immutableProjectRow.projectName();
    String actualProjectObjectIdResult = immutableProjectRow.projectObjectId();

    // Assert
    assertEquals("42", actualApplicationIdResult);
    assertEquals("42", actualProjectObjectIdResult);
    assertEquals("Application Name", actualApplicationNameResult);
    assertEquals("Project Name", actualProjectNameResult);
    assertEquals(LifecyclePhase.PRODUCTION, actualLifecyclePhaseResult);
    assertSame(endDate, actualEndDateResult);
    assertSame(startDate, immutableProjectRow.startDate());
  }

  /**
   * Test {@link ImmutableProjectRow#withApplicationId(String)}.
   *
   * <p>Method under test: {@link ImmutableProjectRow#withApplicationId(String)}
   */
  @Test
  @DisplayName("Test withApplicationId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withApplicationId(String)"})
  void testWithApplicationId() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableProjectRow actualWithApplicationIdResult = immutableProjectRow.withApplicationId("42");

    // Assert
    assertSame(immutableProjectRow, actualWithApplicationIdResult);
  }

  /**
   * Test {@link ImmutableProjectRow#withApplicationId(String)}.
   *
   * <ul>
   *   <li>Then return applicationId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#withApplicationId(String)}
   */
  @Test
  @DisplayName("Test withApplicationId(String); then return applicationId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withApplicationId(String)"})
  void testWithApplicationId_thenReturnApplicationIdIs42() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder()
            .applicationId("applicationId")
            .applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act
    ImmutableProjectRow actualWithApplicationIdResult =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withApplicationId("42");

    // Assert
    assertEquals("42", actualWithApplicationIdResult.applicationId());
    assertEquals("42", actualWithApplicationIdResult.projectObjectId());
    assertEquals("Application Name", actualWithApplicationIdResult.applicationName());
    assertEquals("Project Name", actualWithApplicationIdResult.projectName());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithApplicationIdResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableProjectRow#withApplicationName(String)}.
   *
   * <p>Method under test: {@link ImmutableProjectRow#withApplicationName(String)}
   */
  @Test
  @DisplayName("Test withApplicationName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withApplicationName(String)"})
  void testWithApplicationName() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("42");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableProjectRow actualWithApplicationNameResult =
        immutableProjectRow.withApplicationName("42");

    // Assert
    assertSame(immutableProjectRow, actualWithApplicationNameResult);
  }

  /**
   * Test {@link ImmutableProjectRow#withApplicationName(String)}.
   *
   * <ul>
   *   <li>Then return applicationId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#withApplicationName(String)}
   */
  @Test
  @DisplayName("Test withApplicationName(String); then return applicationId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withApplicationName(String)"})
  void testWithApplicationName_thenReturnApplicationIdIs42() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act
    ImmutableProjectRow actualWithApplicationNameResult =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withApplicationName("42");

    // Assert
    assertEquals("42", actualWithApplicationNameResult.applicationId());
    assertEquals("42", actualWithApplicationNameResult.applicationName());
    assertEquals("42", actualWithApplicationNameResult.projectObjectId());
    assertEquals("Project Name", actualWithApplicationNameResult.projectName());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithApplicationNameResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableProjectRow#withEndDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableProjectRow#withEndDate(Date)}
   */
  @Test
  @DisplayName("Test withEndDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withEndDate(Date)"})
  void testWithEndDate() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableProjectRow actualWithEndDateResult =
        immutableProjectRow.withEndDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableProjectRow, actualWithEndDateResult);
  }

  /**
   * Test {@link ImmutableProjectRow#withLifecyclePhase(LifecyclePhase)}.
   *
   * <p>Method under test: {@link ImmutableProjectRow#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withLifecyclePhase(LifecyclePhase)"})
  void testWithLifecyclePhase() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableProjectRow actualWithLifecyclePhaseResult =
        immutableProjectRow.withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertSame(immutableProjectRow, actualWithLifecyclePhaseResult);
  }

  /**
   * Test {@link ImmutableProjectRow#withLifecyclePhase(LifecyclePhase)}.
   *
   * <ul>
   *   <li>Then return applicationId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#withLifecyclePhase(LifecyclePhase)}
   */
  @Test
  @DisplayName("Test withLifecyclePhase(LifecyclePhase); then return applicationId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withLifecyclePhase(LifecyclePhase)"})
  void testWithLifecyclePhase_thenReturnApplicationIdIs42() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.DEVELOPMENT)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act
    ImmutableProjectRow actualWithLifecyclePhaseResult =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withLifecyclePhase(LifecyclePhase.PRODUCTION);

    // Assert
    assertEquals("42", actualWithLifecyclePhaseResult.applicationId());
    assertEquals("42", actualWithLifecyclePhaseResult.projectObjectId());
    assertEquals("Application Name", actualWithLifecyclePhaseResult.applicationName());
    assertEquals("Project Name", actualWithLifecyclePhaseResult.projectName());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithLifecyclePhaseResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableProjectRow#withProjectName(String)}.
   *
   * <p>Method under test: {@link ImmutableProjectRow#withProjectName(String)}
   */
  @Test
  @DisplayName("Test withProjectName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withProjectName(String)"})
  void testWithProjectName() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("42")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableProjectRow actualWithProjectNameResult = immutableProjectRow.withProjectName("42");

    // Assert
    assertSame(immutableProjectRow, actualWithProjectNameResult);
  }

  /**
   * Test {@link ImmutableProjectRow#withProjectName(String)}.
   *
   * <ul>
   *   <li>Then return applicationId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#withProjectName(String)}
   */
  @Test
  @DisplayName("Test withProjectName(String); then return applicationId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withProjectName(String)"})
  void testWithProjectName_thenReturnApplicationIdIs42() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");

    // Act
    ImmutableProjectRow actualWithProjectNameResult =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withProjectName("42");

    // Assert
    assertEquals("42", actualWithProjectNameResult.applicationId());
    assertEquals("42", actualWithProjectNameResult.projectName());
    assertEquals("42", actualWithProjectNameResult.projectObjectId());
    assertEquals("Application Name", actualWithProjectNameResult.applicationName());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithProjectNameResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableProjectRow#withProjectObjectId(String)}.
   *
   * <p>Method under test: {@link ImmutableProjectRow#withProjectObjectId(String)}
   */
  @Test
  @DisplayName("Test withProjectObjectId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withProjectObjectId(String)"})
  void testWithProjectObjectId() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableProjectRow actualWithProjectObjectIdResult =
        immutableProjectRow.withProjectObjectId("42");

    // Assert
    assertSame(immutableProjectRow, actualWithProjectObjectIdResult);
  }

  /**
   * Test {@link ImmutableProjectRow#withProjectObjectId(String)}.
   *
   * <ul>
   *   <li>Then return applicationId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProjectRow#withProjectObjectId(String)}
   */
  @Test
  @DisplayName("Test withProjectObjectId(String); then return applicationId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withProjectObjectId(String)"})
  void testWithProjectObjectId_thenReturnApplicationIdIs42() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("projectObjectId");

    // Act
    ImmutableProjectRow actualWithProjectObjectIdResult =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build()
            .withProjectObjectId("42");

    // Assert
    assertEquals("42", actualWithProjectObjectIdResult.applicationId());
    assertEquals("42", actualWithProjectObjectIdResult.projectObjectId());
    assertEquals("Application Name", actualWithProjectObjectIdResult.applicationName());
    assertEquals("Project Name", actualWithProjectObjectIdResult.projectName());
    assertEquals(LifecyclePhase.PRODUCTION, actualWithProjectObjectIdResult.lifecyclePhase());
  }

  /**
   * Test {@link ImmutableProjectRow#withStartDate(Date)}.
   *
   * <p>Method under test: {@link ImmutableProjectRow#withStartDate(Date)}
   */
  @Test
  @DisplayName("Test withStartDate(Date)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProjectRow ImmutableProjectRow.withStartDate(Date)"})
  void testWithStartDate() {
    // Arrange
    Builder applicationNameResult =
        ImmutableProjectRow.builder().applicationId("42").applicationName("Application Name");

    Builder projectObjectIdResult =
        applicationNameResult
            .endDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .projectName("Project Name")
            .projectObjectId("42");
    ImmutableProjectRow immutableProjectRow =
        projectObjectIdResult
            .startDate(
                Date.from(
                    LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()))
            .build();

    // Act
    ImmutableProjectRow actualWithStartDateResult =
        immutableProjectRow.withStartDate(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    assertEquals(immutableProjectRow, actualWithStartDateResult);
  }
}
